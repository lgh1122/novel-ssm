package com.novel.rest.storage.impl;

import com.novel.common.pojo.TbNovel;

import com.novel.rest.converter.ManageConvent;
import com.novel.rest.listener.ServiceLocator;
import com.novel.rest.service.TbNovelService;
import com.novel.rest.storage.ChapterProcessor;
import com.novel.spider.configuration.Configuration;
import com.novel.spider.entitys.SpiderChapter;
import com.novel.spider.entitys.SpiderNovel;
import com.novel.spider.intf.IChapterSpider;
import com.novel.spider.intf.INovelDescSpider;
import com.novel.spider.util.ChapterSpiderFactory;
import com.novel.spider.util.CommonUtil;
import com.novel.spider.util.NovelSpiderFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


/**
 * 章节数据的更新和操作时根据书籍对象来的，在这一个不使用书籍集合进行多线程
 * 处理，涉及多线程处理的部分可以在外部实现
 * 同时该类也不建议操作数据库
 */
public abstract class AbstractChapterStorage implements ChapterProcessor {
	protected SqlSessionFactory sqlSessionFactory;

	public AbstractChapterStorage() {
		 
	}
	@Autowired
	private TbNovelService tbNovelService;
	
	/**
	 * 通过小说对象 获取小说的简介和图片路径
	 */
	@Override
	public TbNovel processNovelIntroductionAndImgPath(TbNovel tbNovel) {
		 SpiderNovel n =	ManageConvent.tbNovelToSpiderNovel(tbNovel);
		
		INovelDescSpider spider = NovelSpiderFactory.getNovelDescSpider(n.getNetUrl());
		try {
			SpiderNovel  spidernovel = spider.getsNovelDescImg(n.getNetUrl());
			spidernovel.setNetUrl(n.getNetUrl());
			spidernovel.setId(n.getId());
			
			tbNovel=	ManageConvent.spiderToTbNovel(spidernovel);
			tbNovelService =  (TbNovelService) ServiceLocator.getService("tbNovelService");
			tbNovelService.updateTbNovel(tbNovel);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tbNovel;
	}


	@Override
	public Map spiderChapterUpdate(TbNovel tbNovel) {
		SpiderNovel spiderNovel = ManageConvent.tbNovelToSpiderNovel(tbNovel);
		IChapterSpider chapterSpider = ChapterSpiderFactory.getChapterSpider(spiderNovel.getNetUrl());
		return null;
	}

	/**
	 * 不用的方法
	 * @param tbNovel
	 */
	@Deprecated
	public void processChapterInsert(TbNovel tbNovel){
		SpiderNovel spiderNovel = ManageConvent.tbNovelToSpiderNovel(tbNovel);
		IChapterSpider chapterSpider = ChapterSpiderFactory.getChapterSpider(spiderNovel.getNetUrl());
		spiderNovel.setLatestchapterid(null);
		Map<String, Object> map = chapterSpider.getsChapter(spiderNovel);
		List<SpiderChapter> SpiderChapters  = (List<SpiderChapter>) map.get("insertchapter");
		for (SpiderChapter spiderChapter : SpiderChapters) {
			System.out.println(spiderChapter);
		}

		if(map == null || map.size() ==0){

			System.out.println(Thread.currentThread().getName()+"小说---  疑似太监" );

		}
		if(map.size() > 0){

			System.out.println(Thread.currentThread().getName()+"小说--- 正在抓取章节列表" );
			if(map.get("novel")!=null ){
				SpiderNovel sNovel = (SpiderNovel) map.get("novel");
				spiderNovel.setUpdatetime(new Date());
				//要更新的小说书籍对象
			}
			SpiderChapter  upChapter  = (SpiderChapter) map.get("updateChapter");
			if(upChapter != null){
				// 原最后一章节需要更新
			}
			System.out.println(upChapter);
			List<SpiderChapter> piderChapters  = (List<SpiderChapter>) map.get("insertchapter");
			if(SpiderChapters != null&& SpiderChapters.size() > 0){

				if(SpiderChapters.size() > 50){
					Map<String, List<SpiderChapter>> subListMap  = CommonUtil.subChapterList(SpiderChapters, 50);
					for (Entry<String, List<SpiderChapter>> entry : subListMap.entrySet()) {
						List<SpiderChapter> childChapters =   entry.getValue() ;
						//批量插入
					}
				}else{
					//批量插入
				}
					//session.insert("novel.spider.mapper.SpiderChapterMapper.batchInsert", SpiderChapters);
				}
			}
		}
	
	@Override
	public void downImage(Configuration config, List<TbNovel> list) {
		
        // 从数据库获取要插入章节的小说集合
		List<TbNovel> novelList  = list;
		if(novelList != null && novelList.size() > 0 ){
			// 根据章节实体分配任务
			// 根据集合来决定创建多少个线程处理任务
			int size = config.getSize();
			int maxThreadSize = (int) Math.ceil(novelList.size() * 1.0 / size);
			Map<String, List<TbNovel>> downloadTaskAlloc = new HashMap<>();
			for (int i = 0; i < maxThreadSize; i++) {
				int fromIndex = i * config.getSize();
				int toIndex = i == maxThreadSize - 1 ? novelList.size() : (i + 1) * config.getSize();
				downloadTaskAlloc.put((i+1)+"", novelList.subList(fromIndex, toIndex)); 
			}
			
			ExecutorService service = Executors.newFixedThreadPool(downloadTaskAlloc.size());
			List<Future<String>> futures = new ArrayList<Future<String>>(downloadTaskAlloc.size());
			for (Entry<String, List<TbNovel>> entry : downloadTaskAlloc.entrySet()) {
				final String key = entry.getKey();
				final List<TbNovel> value = entry.getValue();
				futures.add(service.submit(new Callable<String> () {
					public String call() throws Exception {
						for (TbNovel tbNovel : value) {
							SqlSession session = null;
							try {
								SpiderNovel spiderNovel = ManageConvent.tbNovelToSpiderNovel(tbNovel);
								String imgurl = spiderNovel.getImgpath();
								String path = "D:\\image\\image\\"+key;
								String fileName = spiderNovel.getId()+  imgurl.substring(imgurl.lastIndexOf("."));
							    boolean flag =	CommonUtil.writeFile(imgurl, path, fileName); 
								if(flag){
									//session =  sqlSessionFactory.openSession();
									//spiderNovel.set("/"+key+"/"+fileName);
									//spiderNovel.setUpdateTime(new Date());
									//session.update("novel.spider.mapper.SpiderNovelMapper.updateByPrimaryKeySelective", SpiderNovel);
									//session.commit();
								}
							} catch (Exception e) {
								if(session != null){
									session.rollback();
									session.close();
								}
								e.printStackTrace();
							} finally {  
					            try {  
					                if(session != null){
										session.close();
									}
					            } catch (Exception e) {  
					                e.printStackTrace();  
					            }  
					        }  
							
						}
						return key;
					}
					
				}));
			}
			service.shutdown();
			for (Future<String> future : futures) {
				try {
					System.out.println("抓取[" + future.get() + "]图片结束！");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}	
	}




	/*@Override
	public void process(Configuration config, List<SpiderNovel> list) {
		        // 从数据库获取要插入章节的小说集合
				List<SpiderNovel> novelList  = list; 
				if(novelList != null && novelList.size() > 0 ){
					// 根据章节实体分配任务
					// 根据集合来决定创建多少个线程处理任务
					int size = config.getSize();
					int maxThreadSize = (int) Math.ceil(novelList.size() * 1.0 / size);
					Map<String, List<SpiderNovel>> downloadTaskAlloc = new HashMap<>();
					for (int i = 0; i < maxThreadSize; i++) {
						int fromIndex = i * config.getSize();
						int toIndex = i == maxThreadSize - 1 ? novelList.size() : (i + 1) * config.getSize();
						downloadTaskAlloc.put(fromIndex + "-" + toIndex, novelList.subList(fromIndex, toIndex)); 
					}
					
					ExecutorService service = Executors.newFixedThreadPool(downloadTaskAlloc.size());
					List<Future<String>> futures = new ArrayList<Future<String>>(downloadTaskAlloc.size());
					for (Entry<String, List<SpiderNovel>> entry : downloadTaskAlloc.entrySet()) {
						final String key = entry.getKey();
						final List<SpiderNovel> value = entry.getValue();
						futures.add(service.submit(new Callable<String> () {
							public String call() throws Exception {
								for (SpiderNovel SpiderNovel : value) {
									SqlSession session = null;
									//Transaction newTransaction = null;  
									//TransactionFactory transactionFactory = new JdbcTransactionFactory(); // 事务工厂  
									try {
										IChapterSpider chapterSpider = ChapterSpiderFactory.getChapterSpider(SpiderNovel.getNetUrl());
										Map<String, Object> map = chapterSpider.getsChapter(SpiderNovel);
										
										
									*//*	newTransaction = transactionFactory.newTransaction(session
							                    .getConnection());  
										 *//*
										if(map == null || map.size() ==0){
											session =  sqlSessionFactory.openSession();
											System.out.println(Thread.currentThread().getName()+"小说---"+SpiderNovel.getId()+" "+SpiderNovel.getTitle()+" 疑似太监" );
											SpiderNovel.setIntroduction(null);
											//SpiderNovel.setVaild((byte)4);
											session.update("novel.spider.mapper.SpiderNovelMapper.updateByPrimaryKeySelective", SpiderNovel);
											session.commit();
										}
										if(map.size() > 0){
											session =  sqlSessionFactory.openSession();

											System.out.println(Thread.currentThread().getName()+"小说---"+SpiderNovel.getId()+" "+SpiderNovel.getTitle()+" 正在抓取章节列表" );
											if(map.get("novel")!=null ){
												SpiderNovel spiderNovel = (SpiderNovel) map.get("novel");
												spiderNovel.setUpdatetime(new Date());
												session.update("novel.spider.mapper.SpiderNovelMapper.updateByPrimaryKeySelective", SpiderNovel);
											}
											 SpiderChapter  upChapter  = (SpiderChapter) map.get("updateChapter");
											if(upChapter != null){
												session.update("novel.spider.mapper.SpiderChapterMapper.updateByPrimaryKeySelective", upChapter);
											}
											System.out.println(upChapter);
											List<SpiderChapter> SpiderChapters  = (List<SpiderChapter>) map.get("insertchapter");
											if(SpiderChapters != null&& SpiderChapters.size() > 0){

												if(SpiderChapters.size() > 50){
													Map<String, List<SpiderChapter>> subListMap  = CommonUtil.subChapterList(SpiderChapters, 50);
													 for (Map.Entry<String, List<SpiderChapter>> entry : subListMap.entrySet()) {
														 List<SpiderChapter> childChapters =   entry.getValue() ;
														 session.insert("novel.spider.mapper.SpiderChapterMapper.batchInsert", childChapters);
												    }
												}else{
													 session.insert("novel.spider.mapper.SpiderChapterMapper.batchInsert", SpiderChapters);
												}
											}
											
											session.commit();
										}
									} catch (Exception e) {
										System.err.println(SpiderNovel.getId()+" "+SpiderNovel.getTitle()+"--失败" );
										if(session != null){
											session.rollback();
											session.close();
										}
										e.printStackTrace();
									} finally {  
							            try {  
							                if(session != null){
												session.close();
											}
							            } catch (Exception e) {  
							                e.printStackTrace();  
							            }  
							        }  
									
								}
								
								
								return key;
								*//*INovelSpider spider = NovelSpiderFactory.getNovelSpider(value);
								Iterator<List<SpiderNovel>> iterator = spider.iterator(value, 10);
								while (iterator.hasNext()) {
									System.err.println("开始抓取[" + key + "] 的 URL:" + spider.next());
									List<SpiderNovel> novels = iterator.next();
									for (SpiderNovel novel : novels) {
										novel.setFirstLetter(key.charAt(0));	//设置小说的名字的首字母
									}
									
									session.insert("batchInsert", novels);
									session.commit();
									session.close();
									Thread.sleep(1_000);
								}
								return key;*//*
							}
							
						}));
					}
					service.shutdown();
					for (Future<String> future : futures) {
						try {
							System.out.println("抓取[" + future.get() + "]章节结束！");
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					
				}
		
	}*/
	
	
	
}

package com.novel.manage.storage.impl;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.novel.common.pojo.TbChapter;
import com.novel.manage.service.SearchService;
import com.novel.manage.service.TbChapterService;
import com.novel.spider.entitys.SpiderChapter;
import com.novel.spider.intf.IChapterSpider;
import com.novel.spider.util.ChapterSpiderFactory;
import com.novel.spider.util.CommonUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.novel.common.pojo.TbNovel;
import com.novel.manage.converter.ManageConvent;
import com.novel.manage.listener.ServiceLocator;
import com.novel.manage.service.TbNovelService;
import com.novel.manage.storage.NovelProcessor;
import com.novel.spider.entitys.SpiderNovel;
import com.novel.spider.intf.INovelSpider;
import com.novel.spider.util.NovelSpiderFactory;

public abstract class AbstractNovelStorage implements NovelProcessor {
	public static Logger logger = Logger.getLogger(KanShuZhongNovelStorageImpl.class);
	

	
	protected     Map<String,String> insertTasks = new HashMap<String,String>(); 
	protected     Map<String,String> updateTasks = new HashMap<String,String>(); 
	protected     int insertSkip = 10 ;
	protected     int updateSkip = 5 ;
	@Autowired
	private TbChapterService tbChapterService;
	@Autowired
	private TbNovelService tbNovelService;
	@Autowired
	private SearchService searchService;
	


	public AbstractNovelStorage() throws FileNotFoundException {
	
	}
		
	


	@Override
	public void processInsert(Long netId) {

		ExecutorService service = Executors.newFixedThreadPool(insertTasks.size());
		List<Future<String>> futures = new ArrayList<Future<String>>(insertTasks.size());
		for (Entry<String, String> entry : insertTasks.entrySet()) {
			final String key = entry.getKey();
			final String value = entry.getValue();
			futures.add(service.submit(new Callable<String> () {
				public String call() throws Exception {
					INovelSpider spider = NovelSpiderFactory.getNovelSpider(value);
					Iterator<List<SpiderNovel>> iterator = spider.iterator(value, 10);
					int k = 0;
					while (iterator.hasNext()) {
						k++;
						try {
							 
							System.err.println("现在开始抓取[" + key + "] 的 URL:" + spider.next());
							List<SpiderNovel> novels = iterator.next();
							List<TbNovel> tbNovels = ManageConvent.spiderToTbNovelList(novels);
							tbNovelService = (TbNovelService) ServiceLocator.getService("tbNovelService");
							 
							System.out.println(tbNovelService);
							tbNovelService.insertBatchTbNovel(tbNovels);
						} catch (Exception e) {
							e.printStackTrace();
						}
						if(k>=insertSkip){
							break;
						}
						
					}
					return key;
				}
				
			}));
		}
		service.shutdown();
		for (Future<String> future : futures) {
			try {
				System.out.println("抓取[" + future.get() + "]结束！");
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
	
	}
	@Override
	public void processUpdate(){

		ExecutorService service = Executors.newFixedThreadPool(updateTasks.size());
		List<Future<String>> futures = new ArrayList<Future<String>>(updateTasks.size());
		for (Entry<String, String> entry : updateTasks.entrySet()) {
			final String key = entry.getKey();
			final String value = entry.getValue();
			futures.add(service.submit(new Callable<String> () {
				public String call() throws Exception {
					INovelSpider spider = NovelSpiderFactory.getNovelSpider(value);
					Iterator<List<SpiderNovel>> iterator = spider.iterator(value, 10);
					int k = 0;
					while (iterator.hasNext()) {
						k++;
						try {
 							System.err.println("开始抓取[" + key + "] 的 URL:" + spider.next());
							List<SpiderNovel> novels = iterator.next();
							List<TbNovel> tbNovels = ManageConvent.spiderToTbNovelList(novels);
							tbNovelService = (TbNovelService) ServiceLocator.getService("tbNovelService");
							tbChapterService = (TbChapterService) ServiceLocator.getService("tbChapterService");
							for (TbNovel tbNovel : tbNovels) {
								try{
									// 获取数据库中存储的对应书籍信息若存在，表示已经有了，就进行更新，否则进行插入
									TbNovel oldNovel = tbNovelService.getNovelDescByID(tbNovel.getNetid(),tbNovel.getId());
									if(oldNovel!=null){
										if(oldNovel.getLatestchapterid()!=null && !oldNovel.getLatestchapterid().equals(tbNovel.getLatestchapterid()) ){
											//两者章节信息不同，说明存在章节信息更新
											//需要对数据进行更新操作
											System.out.println(oldNovel.getIshaschapter());
											// 值为null时 null ==1 会报空指针异常
											TbChapter newChapter = new TbChapter();
						                    newChapter.setId(tbNovel.getLatestchapterid());
						                    newChapter.setTitle(tbNovel.getLatestchaptername());
											if( oldNovel.getIshaschapter()!=null && oldNovel.getIshaschapter() == 1){
												//											进行章节列表的更新
												SpiderNovel spiderNovel = ManageConvent.tbNovelToSpiderNovel(oldNovel);
												IChapterSpider chapterSpider = ChapterSpiderFactory.getChapterSpider(spiderNovel.getNetUrl());
												Map<String, Object> map = chapterSpider.getsChapter(spiderNovel);
												// 得到书籍最新章节，追加章节列表
												
												if(map.size() > 0){
													logger.debug(Thread.currentThread().getName()+"小说--- 正在抓取章节列表" );
													if(map.get("novel")!=null ){
													/*SpiderNovel sNovel = (SpiderNovel) map.get("novel");
													spiderNovel.setUpdatetime(new Date());*/
														//要更新的小说书籍对象
													}
													SpiderChapter upChapter  = (SpiderChapter) map.get("updateChapter");
													if(upChapter != null){
														// 原最后一章节需要更新 update;
														TbChapter tc = ManageConvent.spiderToTbChapter(upChapter);
														tbChapterService.updateTbChapter(tc);
														//删除之后的章节列表
						                                tbChapterService.deleteChapterByGreaterId(tc);
													}
													List<SpiderChapter> piderChapters  = (List<SpiderChapter>) map.get("insertchapter");
													if(piderChapters != null&& piderChapters.size() > 0){
														Map<String, List<SpiderChapter>> subListMap  = CommonUtil.subChapterList(piderChapters, 50);
														for (Map.Entry<String, List<SpiderChapter>> entry : subListMap.entrySet()) {
															List<SpiderChapter> childChapters =   entry.getValue() ;
															//批量插入
															List<TbChapter> chapters = ManageConvent.spiderToTbChapterList(childChapters);
															try {
																tbChapterService.insertBatchTbChapter(chapters);
															}catch (Exception e){
																logger.error("小说"+oldNovel.getId() +"--"+oldNovel.getTitle() +"违反唯一约束");
																throw e;
															}
															newChapter = chapters.get(chapters.size()-1);
														}
														oldNovel.setIshaschapter((byte)1);
													}
												}
											}
											oldNovel.setLatestchapterid(newChapter.getId());
											oldNovel.setLatestchaptername(newChapter.getTitle());
											oldNovel.setStatus(tbNovel.getStatus());
											oldNovel.setUpdatetime(tbNovel.getUpdatetime());
											tbNovelService.updateTbNovel(oldNovel);
										}
									}else{
										tbNovelService.insertTbNovel(tbNovel);
									}
								}catch (Exception e){
									logger.error("小说"+tbNovel.getId() +"--"+tbNovel.getTitle() +"爬取失败");
									logger.error(e.getMessage());
									e.printStackTrace();
								}
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
						if(k>=updateSkip){
							break;
						}
						
					}
					return key;
				}

			}));
		}
		service.shutdown();
		for (Future<String> future : futures) {
			try {
				System.out.println("抓取[" + future.get() + "]结束！");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		searchService = (SearchService) ServiceLocator.getService("searchService");
		// 导入索引库
		searchService.importItems();
	}
	

	public void test( TbNovel tbNovel){

        try{
            tbNovelService = (TbNovelService) ServiceLocator.getService("tbNovelService");
            tbChapterService = (TbChapterService) ServiceLocator.getService("tbChapterService");
            // 获取数据库中存储的对应书籍信息若存在，表示已经有了，就进行更新，否则进行插入
            TbNovel oldNovel = tbNovelService.getNovelDescByID(tbNovel.getNetid(),tbNovel.getId());
            if(oldNovel!=null){
                if(oldNovel.getLatestchapterid()!=null && !oldNovel.getLatestchapterid().equals(tbNovel.getLatestchapterid()) ){
                    //两者章节信息不同，说明存在章节信息更新
                    //需要对数据进行更新操作
                    System.out.println(oldNovel.getIshaschapter());
                    
                    TbChapter newChapter = new TbChapter();
                    newChapter.setId(tbNovel.getLatestchapterid());
                    newChapter.setTitle(tbNovel.getLatestchaptername());
                    // 值为null时 null ==1 会报空指针异常
                    if( oldNovel.getIshaschapter()!=null && oldNovel.getIshaschapter() == 1){
                        //											进行章节列表的更新
                        SpiderNovel spiderNovel = ManageConvent.tbNovelToSpiderNovel(oldNovel);
                        IChapterSpider chapterSpider = ChapterSpiderFactory.getChapterSpider(spiderNovel.getNetUrl());
                        Map<String, Object> map = chapterSpider.getsChapter(spiderNovel);
                        // 得到书籍最新章节，追加章节列表
						 
                        if(map.size() > 0){
                            logger.debug(Thread.currentThread().getName()+"小说--- 正在抓取章节列表" );
                            if(map.get("novel")!=null ){
													/*SpiderNovel sNovel = (SpiderNovel) map.get("novel");
													spiderNovel.setUpdatetime(new Date());*/
                                //要更新的小说书籍对象
                            }
                            SpiderChapter upChapter  = (SpiderChapter) map.get("updateChapter");
                            if(upChapter != null){
                                // 原最后一章节需要更新 update;
                                TbChapter tc = ManageConvent.spiderToTbChapter(upChapter);
                                tbChapterService.updateTbChapter(tc);
                                //删除之后的章节列表
                                tbChapterService.deleteChapterByGreaterId(tc);
                            }
                            List<SpiderChapter> piderChapters  = (List<SpiderChapter>) map.get("insertchapter");
                            if(piderChapters != null&& piderChapters.size() > 0){
                                Map<String, List<SpiderChapter>> subListMap  = CommonUtil.subChapterList(piderChapters, 50);
                                newChapter.setId(piderChapters.get(piderChapters.size()-1).getId());
                                newChapter.setTitle(piderChapters.get(piderChapters.size()-1).getTitle());
                                for (Map.Entry<String, List<SpiderChapter>> entry : subListMap.entrySet()) {
                                    List<SpiderChapter> childChapters =   entry.getValue() ;
                                    //批量插入
                                    List<TbChapter> chapters = ManageConvent.spiderToTbChapterList(childChapters);
                                    try {
                                        tbChapterService.insertBatchTbChapter(chapters);
                                    }catch (Exception e){
                                        logger.error("小说"+oldNovel.getId() +"--"+oldNovel.getTitle() +"违反唯一约束");
                                        throw e;
                                        //shouxianshi1 ranhou shier 
                                    }
                                   
                                }
                                oldNovel.setIshaschapter((byte)1);
                            }
                        }
                    }
                    //最新章节的获取取章节列表的最后一个
                    oldNovel.setLatestchapterid(newChapter.getId());
                    oldNovel.setLatestchaptername(newChapter.getTitle());
                    oldNovel.setStatus(tbNovel.getStatus());
                    oldNovel.setUpdatetime(tbNovel.getUpdatetime());
                    tbNovelService.updateTbNovel(oldNovel);
                }
            }else{
                tbNovelService.insertTbNovel(tbNovel);
            }
        }catch (Exception e){
            logger.error("小说"+tbNovel.getId() +"--"+tbNovel.getTitle() +"爬取失败");
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }

}

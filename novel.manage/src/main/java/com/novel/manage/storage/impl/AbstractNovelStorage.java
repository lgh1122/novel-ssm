package com.novel.manage.storage.impl;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
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
	private TbNovelService tbNovelService;
	
	protected SqlSessionFactory sqlSessionFactory;
	protected Map<String, String> tasks = new TreeMap<String, String>();
	public AbstractNovelStorage() throws FileNotFoundException {
	
	}
		
	
	public void processUpdateold(){

		ExecutorService service = Executors.newFixedThreadPool(tasks.size());
		List<Future<String>> futures = new ArrayList<Future<String>>(tasks.size());
		for (Entry<String, String> entry : tasks.entrySet()) {
			final String key = entry.getKey();
			final String value = entry.getValue();
			futures.add(service.submit(new Callable<String> () {
				public String call() throws Exception {
					INovelSpider spider = NovelSpiderFactory.getNovelSpider(value);
					Iterator<List<SpiderNovel>> iterator = spider.iterator(value, 10);
					int j = 1;
					while (iterator.hasNext()) {
					SqlSession session =  null;
						try {
							
							System.err.println("开始抓取[" + key + "] 的 URL:" + spider.next());
							List<SpiderNovel> novels = iterator.next();
							for (SpiderNovel novel : novels) {
								//novel.setFirstLetter(key.charAt(0));	//设置小说的名字的首字母
								session = sqlSessionFactory.openSession();
								SpiderNovel oldnovel = session.selectOne("novel.spider.mapper.SpiderNovelMapper.selectByPrimaryKey", novel.getId());
								if(oldnovel!= null    ){
									if(novel.getLatestchapterid() != null && !novel.getLatestchapterid().equals(oldnovel.getLatestchapterid())){
										// do update
										session.update("updateLastChapterByPrimaryKey", novel);
									}
								}else{
									// do insert 
									session.insert("novel.spider.mapper.SpiderNovelMapper.insert",novel);
								}
								session.commit();
								session.close();
							}
						} catch (Exception e) {
							if(session != null){
								session.rollback();
								session.close();
							}
							e.printStackTrace();
						}
						j++;
						if(j > 5){
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
	public void process() {
		ExecutorService service = Executors.newFixedThreadPool(tasks.size());
		List<Future<String>> futures = new ArrayList<Future<String>>(tasks.size());
		for (Entry<String, String> entry : tasks.entrySet()) {
			final String key = entry.getKey();
			final String value = entry.getValue();
			futures.add(service.submit(new Callable<String> () {
				public String call() throws Exception {
					INovelSpider spider = NovelSpiderFactory.getNovelSpider(value);
					Iterator<List<SpiderNovel>> iterator = spider.iterator(value, 10);
					while (iterator.hasNext()) {
						SqlSession session =  null;
						try {
							System.err.println("开始抓取[" + key + "] 的 URL:" + spider.next());
							List<SpiderNovel> novels = iterator.next();
							for (SpiderNovel novel : novels) {
								novel.setFirstLetter(key.charAt(0));	//设置小说的名字的首字母
							}
							session = sqlSessionFactory.openSession();
							session.insert("novel.spider.mapper.SpiderNovelMapper.batchInsert", novels);
							session.commit();
							session.close();
							Thread.sleep(1_000);
						} catch (Exception e) {
							if(session != null){
								session.close();
							}
							e.printStackTrace();
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
							 
							System.err.println("开始抓取[" + key + "] 的 URL:" + spider.next());
							
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
							for (TbNovel tbNovel : tbNovels) {
								// do insert or update 
								tbNovelService.insertOrupdateTbNovel(tbNovel);	
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
	}
	
	
}

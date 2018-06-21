package com.novel.manage.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.novel.spider.NovelSiteEnum;
import com.novel.spider.configuration.Configuration;
import com.novel.spider.entitys.Chapter;
import com.novel.spider.entitys.SpiderChapter;
import com.novel.spider.entitys.SpiderChapterDetail;
import com.novel.spider.entitys.SpiderNovel;
import com.novel.spider.intf.IChapterDetailSpider;
import com.novel.spider.intf.IChapterSpider;
import com.novel.spider.intf.INovelDescSpider;
import com.novel.spider.intf.INovelDownload;
import com.novel.spider.intf.INovelSpider;
import com.novel.spider.intf.impl.chapter.BXWXChapterSpider;
import com.novel.spider.intf.impl.chapter.DefaultChapterDetailSpider;
import com.novel.spider.intf.impl.chapter.DefaultChapterSpider;
import com.novel.spider.intf.impl.download.NovelDownloadImpl;
import com.novel.spider.intf.impl.novel.KanShuZhongNovelDescSpider;
import com.novel.spider.util.ChapterDetailSpiderFactory;
import com.novel.spider.util.ChapterSpiderFactory;
import com.novel.spider.util.NovelSpiderFactory;
import com.novel.spider.util.NovelSpiderUtil;

public class Testcase {
	
	private static Logger logger = Logger.getLogger(Testcase.class);  
	@Test
	public void test1() throws Exception {
		IChapterSpider spider = new DefaultChapterSpider();
		String url1= "http://www.biquge.tw/0_5/";
		String url2=  "http://www.x23us.com/html/42/42377/";
		String url3 = "http://www.kanshuzhong.com/book/118665/";
		String url4 ="http://www.xbxwx.net/4/4665/";
		String url5 ="http://www.bxwx9.org/b/206/206771/";
		List<Chapter>  chapters  = spider.getsChapter(url3);
		for (Chapter chapter : chapters) {
			System.out.println(chapter);
		}
	}
	/**
	 * 测试笔下文学获取章节列表方法
	 * 笔下文学的章节列表的章节列表的无序，需特殊处理
	 */
	
	@Test
	public void testBXWX() throws Exception {
		IChapterSpider spider = new BXWXChapterSpider();
		
		String url5 ="http://www.bxwx9.org/b/206/206771/";
		List<Chapter>  chapters  = spider.getsChapter(url5);
		for (Chapter chapter : chapters) {
			System.out.println(chapter);
		}
	}
	
	@Test
	public void test2(){
		System.out.println(NovelSpiderUtil.getContext(NovelSiteEnum.getEnumByUrl("http://www.biquge.tw/0_5/")));
	}
	
	@Test
	public void testGetChapterDetail() {
		IChapterDetailSpider spider = new DefaultChapterDetailSpider();
		System.out.println(spider.getChapterDetail("http://www.x23us.com/html/42/42377/26408796.html"));
	}
	@Test
	public  void chapterDetail( ) {
		//
		String url = "http://www.kanshuzhong.com/book/952/233310.html";
		//"http://www.kanshuzhong.com/book/974/253393";
		IChapterDetailSpider spider = ChapterDetailSpiderFactory.getChapterDetailSpider(url);
         
		SpiderChapterDetail cd = spider.getChapterDetail(url);
       
		
		 
		System.out.println(cd);

	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testDownload() {
		INovelDownload download = new NovelDownloadImpl();
		Configuration config = new Configuration();
		config.setPath("D:/4");
		config.setSize(30);
		//download.downLoad("http://www.x23us.com/html/42/42377/", config);
		//download.download("http://www.kanshuzhong.com/book/115610/", config);
		//download.downLoad("http://www.kanshuzhong.com/book/113390/", config);
		
		List<Chapter> list  = new ArrayList<Chapter>();
		do{
			list =	download.downLoad("http://www.kanshuzhong.com/book/109842/", config,list);
			System.out.println(list.size()+"-----错误章节数-----");
		}while(list.size()>0);
		 
		 
				//download.download("http://www.23us.com/html/56/56189/", config);
		//download.downLoad("http://www.23us.com/html/56/56189/", config);
	}
	
	@Test
	public void testmultiFileMerge(){
		NovelSpiderUtil.multiFileMerge("D:\\4\\109842", "合并.txt", false);
	}
	
	@Test
	public void testGetBXWXNovel() {
		INovelSpider  spider = NovelSpiderFactory.getNovelSpider("https://www.bxwx9.org/modules/article/index.php");
		List<SpiderNovel> novels = spider.getsNovel("https://www.bxwx9.org/modules/article/index.php" ,3);
		for (SpiderNovel novel : novels) {
			System.out.println(novel);
		}
		
	}
	@Test
	public void testList() {
		 List<String> list = new ArrayList<String>();
		 List<String> list2 = new ArrayList<String>();
		 list.add("hello");
		 list2 = list;
		 list = new ArrayList<String>() ;;
		 System.out.println(list2.size());
		 System.out.println(list.size());
		 
		 
		
	}
	
	@Test
	public void testSort(){
		List<String> list = new ArrayList<>();
		list.add("0350002");
		list.add("0350001");
		Map map = new HashMap<>();
		map.put("key", "String");
		Collections.sort(list, new Comparator<String>(){

			@Override
			public int compare(String o1, String o2) {
				String bean1 = (String) o1;
				String bean2 = (String) o2;
				return bean1.compareTo(bean2) ;
					//return 1;
				 
				 
			}
	    	
	    });
		
		System.out.println(list.toString());
	}
	
	/**
	 * 得到当前页的小说列表
	 */
	@Test
	public void testGetKanshuzhongNovel() {
		String url = "http://www.kanshuzhong.com/toplist/lastupdate/16/";
		INovelSpider  spider = NovelSpiderFactory.getNovelSpider(url);
		List<SpiderNovel> novels = spider.getsNovel(url,3);
		for (SpiderNovel novel : novels) {
			System.out.println(novel);
		}
		
	}
	@Test
	public void testArr(){
		int[] a = new int[]{1,2,3,4};
		int i = 0;
		a[i++] = a[i++]*2;
		System.out.println(a[0]);

	}
	
	

	/**
	 * 单独获取网站简介和图片路径
	 */
	@Test
	public void testGetKanshuzhongNovelDescImg() {
		String url = "http://www.kanshuzhong.com/book/118665/";
		INovelDescSpider  spider = new KanShuZhongNovelDescSpider();
		
		try {
			SpiderNovel  novel = spider.getsNovelDescImg(url);
			System.out.println(novel);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	 
	}
	/**
	 * 得到当前小说列表
	 */
	@Test
	public void testGetKanshuzhongNextPageNovel() {
		String url = "http://www.kanshuzhong.com/map/A/1/";
		INovelSpider  spider = NovelSpiderFactory.getNovelSpider(url);
		Iterator<List<SpiderNovel>> iter = spider.iterator(url, 3);
		while(iter.hasNext()){
			List<SpiderNovel> novels = iter.next();
			System.out.println(novels.get(0));
			System.err.println("url:"+spider.next());
			//break;
		}
		
		
	}
	@Test
	public void testdownSpiderChapter(){
		IChapterSpider chapterSpider = ChapterSpiderFactory.getChapterSpider("http://www.kanshuzhong.com/book/118665/");
		SpiderNovel novel = new SpiderNovel();
		novel.setId(119319L);
		novel.setTitle("逆袭大清");
		novel.setNetUrl("http://www.kanshuzhong.com/book/119319/");
		Map<String, Object> map = chapterSpider.getsChapter(novel);
		novel = (SpiderNovel) map.get("novel");
		System.out.println(novel);
		List<SpiderChapter> spiderChapters  = (List<SpiderChapter>) map.get("insertchapter");
		
		for (SpiderChapter   chapter  : spiderChapters) {
			 System.out.println(chapter);
		}
	}
	@Test
	public void testLog4J(){

        // 记录debug级别的信息  
        logger.debug("This is debug message.");  
        // 记录info级别的信息  
        logger.info("This is info message.");  
        // 记录error级别的信息  
        logger.error("This is error message.");  
    }  
		
	
}

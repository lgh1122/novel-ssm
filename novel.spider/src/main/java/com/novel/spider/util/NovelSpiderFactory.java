package com.novel.spider.util;

import org.apache.log4j.Logger;

import com.novel.spider.NovelSiteEnum;
import com.novel.spider.intf.INovelDescSpider;
import com.novel.spider.intf.INovelSpider;
import com.novel.spider.intf.impl.novel.BXWXNovelSpider;
import com.novel.spider.intf.impl.novel.KanShuZhongNovelDescSpider;
import com.novel.spider.intf.impl.novel.KanShuZhongNovelSpider;

public class NovelSpiderFactory {
	private static Logger logger = Logger.getLogger(NovelSpiderFactory.class); 
	
private NovelSpiderFactory() {}
 
	public static INovelSpider getNovelSpider(String url){
		NovelSiteEnum novleEnum = NovelSiteEnum.getEnumByUrl(url);
		INovelSpider novelSpider = null;
		switch(novleEnum){
			case BXWX :	
				novelSpider = new BXWXNovelSpider(); break;
			case Kanshuzhong:
				novelSpider = new KanShuZhongNovelSpider(); break;
			default:
				 logger.error(url+"还未支持该网站获取小说列表");  
				throw new RuntimeException(url+"还未支持该网站获取小说列表");
			}
			return novelSpider;
		}
	
	
	public static INovelDescSpider getNovelDescSpider(String url){
		NovelSiteEnum novleEnum = NovelSiteEnum.getEnumByUrl(url);
		INovelDescSpider  spider = null;
		switch(novleEnum){
			 
			case Kanshuzhong:
				spider = new KanShuZhongNovelDescSpider(); break;
			default:
				 logger.error(url+"还未支持该网站获取小说简介");  
				throw new RuntimeException(url+"还未支持该网站获取小说简介");
			}
			return spider;
		}
	
}

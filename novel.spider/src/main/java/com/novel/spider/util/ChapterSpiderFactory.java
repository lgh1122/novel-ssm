package com.novel.spider.util;

import com.novel.spider.NovelSiteEnum;
import com.novel.spider.intf.IChapterSpider;
import com.novel.spider.intf.impl.chapter.BXWXChapterSpider;
import com.novel.spider.intf.impl.chapter.DefaultChapterSpider;
import com.novel.spider.intf.impl.chapter.KanShuZhongChapterSpider;

/**
 * 根据给定的URL返回一个实现了IChapterSpider接口的实现类
 * @author liuguanghui
 *
 */
public final class ChapterSpiderFactory {
	private ChapterSpiderFactory() {}
	
	public static IChapterSpider getChapterSpider(String url){
		NovelSiteEnum novleEnum = NovelSiteEnum.getEnumByUrl(url);
		IChapterSpider chapterSpider = null;
		switch(novleEnum){
			case BXWX :	
				chapterSpider = new BXWXChapterSpider(); break;
			case Kanshuzhong :
				chapterSpider = new KanShuZhongChapterSpider(); break;
			case DingDianXiaoShuo:
			case BiQuGe:
			case XBXWX :
			case SANHAO:
			chapterSpider = new DefaultChapterSpider(); break;
			}
			return chapterSpider;
		}
	

}

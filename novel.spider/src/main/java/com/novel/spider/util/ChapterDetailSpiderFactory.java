package com.novel.spider.util;

import com.novel.spider.NovelSiteEnum;
import com.novel.spider.intf.IChapterDetailSpider;
import com.novel.spider.intf.impl.chapter.DefaultChapterDetailSpider;

public final class ChapterDetailSpiderFactory {
	private ChapterDetailSpiderFactory() {}
	/**
	 * 通过给定的url拿到实现了IChapterDetailSpider的具体实现类
	 * @param url
	 * @return
	 */
	public static IChapterDetailSpider getChapterDetailSpider(String url) {
		IChapterDetailSpider spider = null;
		NovelSiteEnum novelSiteEnum = NovelSiteEnum.getEnumByUrl(url);
		switch (novelSiteEnum) {
		case DingDianXiaoShuo:
		case BiQuGe:
		case Kanshuzhong :
		case XBXWX :
		case BXWX :	
		case SANHAO:
			spider = new DefaultChapterDetailSpider();
			break;
		}
		return spider;
	}
}

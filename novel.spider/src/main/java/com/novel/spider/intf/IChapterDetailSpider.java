package com.novel.spider.intf;

import java.util.List;

import com.novel.spider.entitys.Chapter;
import com.novel.spider.entitys.SpiderChapterDetail;

public interface IChapterDetailSpider {
	/**
	 * 给我们一个完整的url，我们就给你返回对应的章节内容信息
	 * @param url
	 * @return
	 */
	public SpiderChapterDetail getChapterDetail(String url);
}

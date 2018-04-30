package com.novel.spider.intf;

import java.util.List;
import java.util.Map;

import com.novel.spider.entitys.Chapter;
import com.novel.spider.entitys.SpiderNovel;

public interface IChapterSpider {
	/**
	 * 给我们一个完整的url，我们就给你返回所有的章节列表
	 * @param url
	 * @return
	 */
	public List<Chapter> getsChapter(String url);
	
	public Map<String, Object> getsChapter(SpiderNovel novel);
}

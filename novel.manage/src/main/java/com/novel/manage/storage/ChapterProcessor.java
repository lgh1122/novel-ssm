package com.novel.manage.storage;

import java.util.List;

import com.novel.common.pojo.TbNovel;
import com.novel.spider.configuration.Configuration;
import com.novel.spider.entitys.SpiderNovel;

/**
 * 一个处理器接口
 * 抓取小说章节内容
 */
public interface ChapterProcessor {
	/**
	 * 一个处理方法
	 */
	public void process(Configuration config, List<SpiderNovel> list);
	
	public void downImage(Configuration config, List<SpiderNovel> list);
	
	public void processChapterInsert(TbNovel tbNovel);
	
	public TbNovel processNovelIntroductionAndImgPath(TbNovel tbNovel);
	
}

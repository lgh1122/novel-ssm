package com.novel.manage.storage;

import java.util.List;
import java.util.Map;

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
	/*public void process(Configuration config, List<SpiderNovel> list);
	
	*/

	/**
	 * 多线程下载图片到本地
	 * @param config
	 * @param list
	 */
	public void downImage(Configuration config, List<TbNovel> list);
	public void processChapterInsert(TbNovel tbNovel);
	
	public TbNovel processNovelIntroductionAndImgPath(TbNovel tbNovel);
	// 获取章节数据的更新和插入
	public Map spiderChapterUpdate(TbNovel tbNovel);
	
}

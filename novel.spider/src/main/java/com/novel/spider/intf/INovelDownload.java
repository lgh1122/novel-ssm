package com.novel.spider.intf;

import java.util.ArrayList;
import java.util.List;

import com.novel.spider.configuration.Configuration;
import com.novel.spider.entitys.Chapter;

public interface INovelDownload {
	 
	/**
	 * 
	 * @param url 某本小说章节列表页面
	 * @return 保存的地址
	 */
	public List<Chapter> downLoad(String url,Configuration config ,List<Chapter> chapterList);
	
	 

}

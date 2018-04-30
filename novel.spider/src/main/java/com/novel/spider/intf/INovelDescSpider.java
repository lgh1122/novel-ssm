package com.novel.spider.intf;

import com.novel.spider.entitys.SpiderNovel;

/**
 * 爬去某个网站的小说列表
 * @author liuguanghui
 *
 */

public interface INovelDescSpider {
	// 最大尝试次数
	public static final int MAX_TRY_TIMES = 3;
	
	/**
	 * 给我们一个完整的url，我们就给你返回小说的简介和小说图片 
	 * @param url
	 * @return
	 */
	public  SpiderNovel getsNovelDescImg(String url) throws Exception;
	public  SpiderNovel getsNovelDescImg(String url, Integer tryTimes) throws Exception;
}

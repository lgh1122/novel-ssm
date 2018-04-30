package com.novel.spider.intf;

import java.util.Iterator;
import java.util.List;

import com.novel.spider.entitys.SpiderNovel;

/**
 * 爬去某个网站的小说列表
 * @author liuguanghui
 *
 */

public interface INovelSpider {
	// 最大尝试次数
	public static final int MAX_TRY_TIMES = 3;
	
	/**
	 * 给我们一个完整的url，我们就给你返回一堆的小说实体
	 * @param url
	 * @return
	 */
	public List<SpiderNovel> getsNovel(String url,Integer tryTimes);
	/**
	 * 判断是否有下一页
	* @Title: hasNext   
	* @Description: TODO   
	* @param @return     
	* @return boolean     
	* @throws
	 */
	public boolean hasNext();
	
	public String next();
	
	public Iterator<List<SpiderNovel>> iterator(String firstPage, Integer maxTryTimes);
}

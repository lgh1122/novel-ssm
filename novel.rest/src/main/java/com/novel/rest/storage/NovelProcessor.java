package com.novel.rest.storage;

/**
 * 一个处理器接口
 * 处理获取对应网站的书籍列表的获取与更新
 * 
 */
public interface NovelProcessor {

	
	/**
	 * 方法进行每天的更新数据操作
	 */
	public void processUpdate();
	
	
	/**
	 * 一个处理方法 初始执行书籍列表获取 
	 */
	public void processInsert(Long netId);
	
}

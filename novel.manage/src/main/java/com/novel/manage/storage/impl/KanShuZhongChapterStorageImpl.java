package com.novel.manage.storage.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.novel.spider.configuration.Configuration;
import com.novel.spider.entitys.SpiderNovel;

public class KanShuZhongChapterStorageImpl extends AbstractChapterStorage {

	public KanShuZhongChapterStorageImpl()   {
		super();
		 
	}

	@Override
	public void process(Configuration config, List<SpiderNovel> list) {
		// 从数据库获取要插入章节的小说集合
		List<SpiderNovel> novelList = null;
		
		SqlSession session = sqlSessionFactory.openSession();
		Calendar calendar= Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.set(Calendar.HOUR_OF_DAY,0);
		calendar.set(Calendar.MINUTE,0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		 
		 System.out.println(); 
		 
		novelList = session.selectList("novel.spider.mapper.SpiderNovelMapper.selectList");
		session.close();
		System.out.println(novelList.size());
		super.process(config, novelList);

	}

	@Override
	public void downImage(Configuration config, List<SpiderNovel> list) {
		// 从数据库获取要插入章节的小说集合
		List<SpiderNovel> novelList = null;
		
		SqlSession session = sqlSessionFactory.openSession();
	    //novel.spider.mapper.SpiderNovelMapper
		novelList = session.selectList("selectList");
		session.close();
		
		super.downImage(config, novelList);
		
	}

	

}

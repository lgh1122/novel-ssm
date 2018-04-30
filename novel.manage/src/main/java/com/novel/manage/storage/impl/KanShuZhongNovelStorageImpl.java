package com.novel.manage.storage.impl;

import java.io.FileNotFoundException;

import com.novel.manage.common.InitTask;
import com.novel.manage.common.SystemConstants;


public class KanShuZhongNovelStorageImpl extends AbstractNovelStorage{
	
	
	 
	
	public KanShuZhongNovelStorageImpl() throws FileNotFoundException {
		insertTasks = InitTask.getInsertTask(SystemConstants.KANSHUZHONG);
		insertSkip = InitTask.getInsertSkip(SystemConstants.KANSHUZHONG);
		updateTasks =  InitTask.getUpdateTask(SystemConstants.KANSHUZHONG);
		updateSkip = InitTask.getUpdateSkip(SystemConstants.KANSHUZHONG);
	}
	
	public KanShuZhongNovelStorageImpl(boolean flag) throws FileNotFoundException{
		super();
		tasks.put("A", "http://www.kanshuzhong.com/toplist/lastupdate/1/");
		tasks.put("B", "http://www.kanshuzhong.com/toplist/lastupdate/6/");
		tasks.put("C", "http://www.kanshuzhong.com/toplist/lastupdate/11/");
		tasks.put("D", "http://www.kanshuzhong.com/toplist/lastupdate/16/");
		tasks.put("E", "http://www.kanshuzhong.com/toplist/lastupdate/21/");
		tasks.put("F", "http://www.kanshuzhong.com/toplist/lastupdate/26/");
		tasks.put("G", "http://www.kanshuzhong.com/toplist/lastupdate/31/");
		/*tasks.put("H", "http://www.kanshuzhong.com/toplist/lastupdate/8/");
		tasks.put("I", "http://www.kanshuzhong.com/toplist/lastupdate/9/");
		tasks.put("J", "http://www.kanshuzhong.com/toplist/lastupdate/10/");
		tasks.put("K", "http://www.kanshuzhong.com/toplist/lastupdate/11/");*/
		
	}

}

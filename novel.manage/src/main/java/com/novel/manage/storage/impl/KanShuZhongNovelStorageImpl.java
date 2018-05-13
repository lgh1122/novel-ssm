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
	

}

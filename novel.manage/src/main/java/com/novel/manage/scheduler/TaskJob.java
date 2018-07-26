package com.novel.manage.scheduler;

import java.io.FileNotFoundException;

import org.apache.log4j.Logger;

import com.novel.manage.storage.NovelProcessor;
import com.novel.manage.storage.impl.KanShuZhongNovelStorageImpl;

/**
 * Created by Admin on 2017/11/12.
 */
public class TaskJob {

	public static Logger logger = Logger.getLogger(TaskJob.class);

    public void insertKanShuZhongNovel(){

            NovelProcessor processor;
            try {			
        	    logger.info("执行初始化插入小说信息定时任务 开始" );
                processor = new KanShuZhongNovelStorageImpl();
                processor.processInsert(102L);
            	logger.info("执行初始化插入小说信息定时任务 结束" );
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

    }


    public void updateKanShuZhongNovel(){
        NovelProcessor processor;
        try {
			logger.info("执行更新小说信息定时任务 开始" );
            processor = new KanShuZhongNovelStorageImpl();
            processor.processUpdate();
			logger.info("执行更新小说信息定时任务完成" );
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

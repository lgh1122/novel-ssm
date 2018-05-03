package com.novel.manage.scheduler;

import com.novel.manage.storage.NovelProcessor;
import com.novel.manage.storage.impl.KanShuZhongNovelStorageImpl;

import java.io.FileNotFoundException;

/**
 * Created by Admin on 2017/11/12.
 */
public class TaskJob {


    public void insertKanShuZhongNovel(){

            NovelProcessor processor;
            try {
                    processor = new KanShuZhongNovelStorageImpl();
                    processor.processInsert(102L);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

    }


    public void updateKanShuZhongNovel(){
        NovelProcessor processor;
        try {
            processor = new KanShuZhongNovelStorageImpl();
            processor.processUpdate( );
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

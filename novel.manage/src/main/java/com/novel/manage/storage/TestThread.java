package com.novel.manage.storage;

import com.novel.common.pojo.TbChapter;
import com.novel.common.pojo.TbNovel;
import com.novel.manage.converter.ManageConvent;
import com.novel.manage.listener.ServiceLocator;
import com.novel.manage.service.TbChapterService;
import com.novel.manage.service.TbNovelService;
import com.novel.spider.entitys.SpiderChapter;
import com.novel.spider.entitys.SpiderNovel;
import com.novel.spider.intf.IChapterSpider;
import com.novel.spider.intf.INovelSpider;
import com.novel.spider.util.ChapterSpiderFactory;
import com.novel.spider.util.CommonUtil;
import com.novel.spider.util.NovelSpiderFactory;
import sun.applet.Main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * create by liuguanghui on 2018/5/20
 **/
public class TestThread {



    public static void main(String[] args) {
        processUpdate();
    }

    public static void processUpdate() {

        ExecutorService service = Executors.newFixedThreadPool(10);
        List<Future<Integer>> futures = new ArrayList<Future<Integer>>(10);
        for (int i = 0; i < 10; i++) {
            final int finalI = i;
            futures.add(service.submit(new Callable<Integer>() {


                @Override
                public Integer call() throws Exception {

                System.out.println("这是第" + finalI + "个线程在执行");

                    return Integer.valueOf(finalI);
                }
            }));
        }
        service.shutdown();
        for (Future<Integer> future : futures) {
            try {
                System.out.println("抓取[" + future.get() + "]结束！");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("我要做事剧情");


    }
}

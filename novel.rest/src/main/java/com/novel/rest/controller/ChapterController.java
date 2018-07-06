package com.novel.rest.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.novel.common.pojo.TbChapter;
import com.novel.common.util.JsonResult;
import com.novel.common.util.SearchResult;
import com.novel.rest.converter.ManageConvent;
import com.novel.rest.service.TbChapterService;
import com.novel.rest.util.COSClientUtil;
import com.novel.spider.entitys.SpiderChapter;
import com.novel.spider.entitys.SpiderChapterDetail;
import com.novel.spider.intf.IChapterDetailSpider;
import com.novel.spider.util.ChapterDetailSpiderFactory;

/**
 * create by liuguanghui on 2018/5/12
 * 为前端系统提供数据服务
 *
 *
 *
 **/
@Controller
@RequestMapping("/chapter")
public class ChapterController {

    public static Logger logger = Logger.getLogger(ChapterController.class);

  
     @Autowired
    private TbChapterService tbChapterService;

    
    @Value("${COS_URL}") 
    private String COS_URL;
  
   


    @RequestMapping("/chapterpagelist/{netId}/{novelId}")
    @ResponseBody
    public JsonResult getChapterListByNovelIdLimit(@PathVariable long netId, @PathVariable long novelId,@RequestParam(required=false) Long startChapterId,
                                              @RequestParam(defaultValue = "1") Integer page,
                                              @RequestParam(defaultValue = "50") Integer rows){

        @SuppressWarnings("rawtypes")
		SearchResult searchResult = null;
        try {
            searchResult = tbChapterService.getChapterListLimit(netId,novelId,startChapterId,page,rows);
        }catch (Exception e){
            e.printStackTrace();
        }

        if(searchResult!=null  ){
            return JsonResult.ok(searchResult);
        }else{
            return JsonResult.build(500,"获取章节列表失败，请联系管理员");
        }

    }

    @RequestMapping("/chapterlist/{netId}/{novelId}")
    @ResponseBody
    public JsonResult getChapterListByNovelId(@PathVariable long netId, @PathVariable long novelId){



        List<TbChapter> chapters = tbChapterService.getChapterList(netId,novelId);

        if(chapters!=null && chapters.size() > 0 ){
            return JsonResult.ok(chapters);
        }else{
            return JsonResult.build(500,"获取章节列表失败，请联系管理员");
        }

    }

    @RequestMapping("/content/{netId}/{novelId}/{chapterId}")
    @ResponseBody
    public JsonResult getChaptersDetailById(@PathVariable long netId,@PathVariable long novelId,@PathVariable long chapterId) {

        TbChapter tbChapter = tbChapterService.getTbChapter(netId,novelId,chapterId);
        SpiderChapter spiderChapter =  ManageConvent.tbChapterToSpiderChapter(tbChapter);
        String fileName = "/novel/"+tbChapter.getNetid()+"/"+tbChapter.getNovelId()+"/"+tbChapter.getId()+".txt";
        
        COSClientUtil clientUtil = new COSClientUtil();
        COS_URL = "https://novel01-1252454126.cos.ap-beijing.myqcloud.com";
        String content =  clientUtil.downCosFile(COS_URL+fileName);
        
        if(content!=null){
          //  String content = FileIoUtil.readFile(filePath, "UTF-8");
            spiderChapter.setContent(content);
            clientUtil.destory();
        }else{
            IChapterDetailSpider spider = ChapterDetailSpiderFactory.getChapterDetailSpider(spiderChapter.getChapterPath());
            SpiderChapterDetail cd  = spider.getChapterDetail(spiderChapter.getChapterPath());
            spiderChapter.setContent(cd.getContent());
          
            clientUtil.uploadFile2Cos(cd.getContent(), fileName);
            clientUtil.destory();
            //FileIoUtil.uploadFile(cd.getContent(),path,spiderChapter.getId()+".txt", "UTF-8");
        }

        return JsonResult.ok(spiderChapter);
    }

}

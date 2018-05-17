package com.novel.rest.controller;

import com.novel.common.pojo.TbChapter;
import com.novel.common.pojo.TbChapterKey;
import com.novel.common.pojo.TbNovel;
import com.novel.common.util.EUDataGridResult;
import com.novel.common.util.JsonResult;
import com.novel.rest.converter.ManageConvent;
import com.novel.rest.service.TbChapterService;
import com.novel.rest.service.TbNovelService;
import com.novel.rest.util.FileIoUtil;
import com.novel.spider.entitys.SpiderChapter;
import com.novel.spider.entitys.SpiderChapterDetail;
import com.novel.spider.entitys.SpiderNovel;
import com.novel.spider.intf.IChapterDetailSpider;
import com.novel.spider.intf.IChapterSpider;
import com.novel.spider.util.ChapterDetailSpiderFactory;
import com.novel.spider.util.ChapterSpiderFactory;
import com.novel.spider.util.CommonUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

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
    private TbNovelService tbNovelService;
    @Autowired
    private TbChapterService tbChapterService;

    /**
     NovelController
     ChapterList 章节信息，用户点击现在阅读时进入书籍章节目录界面
     ChapterContent 章节内容 ，返回章节的具体内容，可将内容缓存1天 redis
     */

   /* @RequestMapping(value = "/list")
    @ResponseBody
    public EUDataGridResult gettbNovelList(@RequestParam(value="page",defaultValue = "1") int page,
                                           @RequestParam(value="rows",defaultValue = "30") int rows, TbNovel novel , HttpServletRequest request) throws UnsupportedEncodingException {
        //TbNovel tbNovel = new TbNovel();
        //tbNovel.setTitle(novel.get);
        if("GET".equalsIgnoreCase( request.getMethod())){
            if(novel.getTitle()!=null){
               // novel.setTitle(new String(novel.getTitle().getBytes("ISO-8859-1"),"UTF-8"));
                String title = novel.getTitle();
                novel.setTitle(new String(title.getBytes("ISO-8859-1"),"UTF-8")   );
            }
        }
        EUDataGridResult result = tbNovelService.getTbNovelList(page, rows,novel);
        return result;
    }*/


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

        String path =  "D:/4/novel/"+spiderChapter.getNetid()+"/"+spiderChapter.getNovelId()+"/";
        String filePath =path +spiderChapter.getId()+".txt";
        File chapterFile = new File(filePath);
        if(chapterFile.exists()){
            String content = FileIoUtil.readFile(filePath, "UTF-8");
            spiderChapter.setContent(content);

        }else{
            IChapterDetailSpider spider = ChapterDetailSpiderFactory.getChapterDetailSpider(spiderChapter.getChapterPath());
            SpiderChapterDetail cd  = spider.getChapterDetail(spiderChapter.getChapterPath());
            spiderChapter.setContent(cd.getContent());
            FileIoUtil.uploadFile(cd.getContent(),path,spiderChapter.getId()+".txt", "UTF-8");
        }

        return JsonResult.ok(spiderChapter);
    }

   /* @RequestMapping("/desc/{netId}/{id}")
    @ResponseBody
    public JsonResult getNovelDescById(@PathVariable long netId,@PathVariable long id){
        TbNovel tbNovel = tbNovelService.getNovelDescByID(netId,id);
        if(tbNovel!=null && tbNovel.getIntroduction()!=null && !"".equals(tbNovel.getIntroduction())){
            return JsonResult.ok(tbNovel);
        }else{
            ChapterProcessor  spider = new KanShuZhongChapterStorageImpl();
            try {
                tbNovel = spider.processNovelIntroductionAndImgPath(tbNovel);
                return JsonResult.ok(tbNovel);
            } catch (Exception e) {

                e.printStackTrace();
            }
        }
        return JsonResult.ok("暂无简介");
    }*/

}

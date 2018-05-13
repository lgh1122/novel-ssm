package com.novel.rest.controller;

import com.novel.common.pojo.TbChapter;
import com.novel.common.pojo.TbNovel;
import com.novel.common.util.EUDataGridResult;
import com.novel.common.util.JsonResult;
import com.novel.rest.converter.ManageConvent;
import com.novel.rest.service.TbChapterService;
import com.novel.rest.service.TbNovelService;
import com.novel.spider.entitys.SpiderChapter;
import com.novel.spider.entitys.SpiderNovel;
import com.novel.spider.intf.IChapterSpider;
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
    /**
     *
     * @param page 当前页
     * @param rows 每页多少数据
     * @param novel 请求参数
     * @return
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


    @RequestMapping("/chapterlist/{netId}/{id}")
    @ResponseBody
    public JsonResult getChapterListByNovelId(@PathVariable long netId, @PathVariable long id){
        List<TbChapter> chapters = tbChapterService.getChapterList(netId,id);

        if(chapters!=null && chapters.size() > 0 ){
            return JsonResult.ok(chapters);
        }else{
            return JsonResult.build(500,"获取章节列表失败，请联系管理员");
        }

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

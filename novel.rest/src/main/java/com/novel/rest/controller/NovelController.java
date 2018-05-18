package com.novel.rest.controller;

import com.novel.common.pojo.TbChapter;
import com.novel.common.pojo.TbNovel;
import com.novel.common.util.EUDataGridResult;
import com.novel.common.util.JsonResult;
import com.novel.rest.converter.ManageConvent;
import com.novel.rest.service.TbChapterService;
import com.novel.rest.service.TbNovelService;
import com.novel.rest.storage.ChapterProcessor;
import com.novel.rest.storage.impl.KanShuZhongChapterStorageImpl;
import com.novel.rest.storage.impl.KanShuZhongNovelStorageImpl;
import com.novel.spider.entitys.SpiderChapter;
import com.novel.spider.entitys.SpiderNovel;
import com.novel.spider.intf.IChapterSpider;
import com.novel.spider.util.ChapterSpiderFactory;
import com.novel.spider.util.CommonUtil;
import org.apache.http.HttpRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
@RequestMapping("/novel")
public class NovelController {

    public static Logger logger = Logger.getLogger(NovelController.class);

    @Autowired
    private TbNovelService tbNovelService;
    @Autowired
    private TbChapterService tbChapterService;

    /**
     NovelController
     get接口
     novelList  支持分页 查询
     novelInfo  书籍信息，初次获取图片 描述 章节列表
     （将章节列表缓存到redis服务器 设置10分钟超时时间）
     数据返回前台，后台开线程执行章节列表和书籍详情的插入
     涉及到爬取数据
     update接口
     点击量阅读量
     */
    /**
     *
     * @param page 当前页
     * @param rows 每页多少数据
     * @param novel 请求参数
     * @return
     */
    @RequestMapping(value = "/list")
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
    }


    @RequestMapping("/info/{netId}/{id}")
    @ResponseBody
    public JsonResult getNovelInfoById(@PathVariable long netId, @PathVariable long id){
        TbNovel tbNovel = tbNovelService.getNovelDescByID(netId,id);
        //model.addAttribute("tbNovel", tbNovel);
		 if(tbNovel!=null && tbNovel.getIntroduction()!=null && !"".equals(tbNovel.getIntroduction())&& tbNovel.getIshaschapter() == 1){
			 SpiderNovel spiderNovel = ManageConvent.tbNovelToSpiderNovel(tbNovel);
			 return JsonResult.ok(spiderNovel);
		}else{
			try {
                SpiderNovel spiderNovel = ManageConvent.tbNovelToSpiderNovel(tbNovel);
                spiderNovel.setLatestchapterid(null);
                IChapterSpider chapterSpider = ChapterSpiderFactory.getChapterSpider(spiderNovel.getNetUrl());
                Map<String, Object> map = chapterSpider.getsChapter(spiderNovel);
                if(map.size() > 0){
                    //logger.debug(Thread.currentThread().getName()+"小说--- 正在抓取章节列表" );

                    SpiderChapter upChapter  = (SpiderChapter) map.get("updateChapter");
                    if(upChapter != null){
                        // 原最后一章节需要更新 update;
                        TbChapter tc = ManageConvent.spiderToTbChapter(upChapter);
                        tbChapterService.updateTbChapter(tc);
                    }
                    List<SpiderChapter> piderChapters  = (List<SpiderChapter>) map.get("insertchapter");
                    if(piderChapters != null&& piderChapters.size() > 0){
                        Map<String, List<SpiderChapter>> subListMap  = CommonUtil.subChapterList(piderChapters, 50);
                        for (Map.Entry<String, List<SpiderChapter>> entry : subListMap.entrySet()) {
                            List<SpiderChapter> childChapters =   entry.getValue() ;
                            //批量插入
                            List<TbChapter> chapters = ManageConvent.spiderToTbChapterList(childChapters);
                            try {
                                tbChapterService.insertBatchTbChapter(chapters);
                            }catch (Exception e){
                                logger.error("小说"+tbNovel.getId() +"--"+tbNovel.getTitle() +"违反唯一约束");
                                tbChapterService.deleteChapterByNovelId(tbNovel.getNetid(),tbNovel.getId());
                                throw e;
                            }
                        }
                        tbNovel.setIshaschapter((byte)1);
                    }
                    if(map.get("novel")!=null ){
                        SpiderNovel sNovel = (SpiderNovel) map.get("novel");
                        TbNovel conventNovel = ManageConvent.spiderToTbNovel(sNovel);
                        tbNovel.setLatestchapterid(conventNovel.getLatestchapterid());
                        tbNovel.setLatestchaptername(conventNovel.getLatestchaptername());
                        tbNovel.setStatus(conventNovel.getStatus());
                        tbNovel.setUpdatetime(conventNovel.getUpdatetime());
                        tbNovel.setImgpath(conventNovel.getImgpath());
                        tbNovel.setIntroduction(conventNovel.getIntroduction());
                        tbNovelService.updateTbNovel(tbNovel);
                        //要更新的小说书籍对象
                    }
                }
			} catch (Exception e) {
				e.printStackTrace();
				logger.error(e.getMessage());
                return JsonResult.build(500,"获取书籍详情失败，请重新请求");
			}
		}
		SpiderNovel spiderNovel = ManageConvent.tbNovelToSpiderNovel(tbNovel);
        return JsonResult.ok(spiderNovel);
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

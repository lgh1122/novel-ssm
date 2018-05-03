package com.novel.manage.controller;

import com.novel.common.pojo.TbNovel;
import com.novel.common.util.EUDataGridResult;
import com.novel.common.util.JsonResult;
import com.novel.manage.service.TbNovelService;
import com.novel.manage.service.TbQuartzService;
import com.novel.manage.storage.ChapterProcessor;
import com.novel.manage.storage.NovelProcessor;
import com.novel.manage.storage.impl.KanShuZhongChapterStorageImpl;
import com.novel.manage.storage.impl.KanShuZhongNovelStorageImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.FileNotFoundException;


@Controller
@RequestMapping("/task")
public class TaskInfoController {
	 
	@Autowired
	private TbQuartzService tbQuartzService;
	

	/*@RequestMapping(value = "/spider")
	@ResponseBody 
    public String doSpiderNovel(String id){
		NovelProcessor processor;
		try {
			if("3001".equals(id)){
				processor = new KanShuZhongNovelStorageImpl();
				processor.processInsert(102L);
				return "sucess insert";
			}else if("3002".equals(id)){
				processor = new KanShuZhongNovelStorageImpl();
				processor.processUpdate( );
				return "sucess update";
			}
			
		} catch (FileNotFoundException e) {
			 
			e.printStackTrace();
		}
		return "error";
    }*/
	 
	 
	@RequestMapping(value = "/list")
	@ResponseBody
	public EUDataGridResult gettbNovelList(@RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "30") Integer rows,TbNovel novel ) {
		EUDataGridResult result = tbQuartzService.getTbQuartzList(page, rows,novel);
		return result;
	}
	

}

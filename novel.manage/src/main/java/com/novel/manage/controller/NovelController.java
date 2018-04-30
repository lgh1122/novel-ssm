package com.novel.manage.controller;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.novel.common.pojo.TbNovel;
import com.novel.common.util.EUDataGridResult;
import com.novel.common.util.JsonResult;
import com.novel.manage.converter.ManageConvent;
import com.novel.manage.service.TbNovelService;
import com.novel.manage.storage.ChapterProcessor;
import com.novel.manage.storage.NovelProcessor;
import com.novel.manage.storage.impl.KanShuZhongChapterStorageImpl;
import com.novel.manage.storage.impl.KanShuZhongNovelStorageImpl;
import com.novel.spider.entitys.SpiderNovel;
 


@Controller
@RequestMapping("/novel")
public class NovelController {
	 
	@Autowired
	private TbNovelService tbNovelService;
	
	
	
	@RequestMapping("/desc/{netId}/{id}")
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
	}
	@RequestMapping("/info/{netId}/{id}")
	public String getNovelInfoById(@PathVariable long netId,@PathVariable long id,Model model){

		TbNovel tbNovel = tbNovelService.getNovelDescByID(netId,id);
		model.addAttribute("tbNovel", tbNovel);
		/*if(tbNovel!=null && tbNovel.getIntroduction()!=null && !"".equals(tbNovel.getIntroduction())){
			return JsonResult.ok(tbNovel);
		}else{
			ChapterProcessor  spider = new KanShuZhongChapterStorageImpl();
			try {
				tbNovel = spider.processNovelIntroductionAndImgPath(tbNovel);
				return JsonResult.ok(tbNovel);
			} catch (Exception e) {
				
				e.printStackTrace();
			}	
		}*/
		return "novel-info1";
	}
		
	@RequestMapping(value = "/spider")
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
    }
	 
	 
	@RequestMapping(value = "/list")
	@ResponseBody
	public EUDataGridResult gettbNovelList(@RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "30") Integer rows,TbNovel novel ) {
		//TbNovel tbNovel = new TbNovel();
		//tbNovel.setTittle(novel.get);
		EUDataGridResult result = tbNovelService.getTbNovelList(page, rows,novel);
		return result;
	}
	
	/*@RequestMapping(value = "/bookList")
	@ResponseBody  
	public JsonResult getTbBookList(@RequestParam(required = false ,defaultValue = "0" ) int paramTid,
			@RequestParam(required = false, defaultValue = "1") int pageNo,
			@RequestParam(required = false,defaultValue = "" ) String paramName) {
		
		TbNovel serchNovel = new TbNovel();
		if(paramName !=null && !"".equals(paramName)){
			serchNovel.setName(paramName);
		}
		if(paramTid  < 0){
			paramTid = 0;
		} 
		//serchBook.setTid((long)paramTid);
		if(pageNo == 0){
			pageNo= 1;
		}
		JsonResult result = novelService.getNovelList(pageNo,serchNovel);
		return result;
	} 
	 
	 
	 
 	@RequestMapping(value="/info/{bookId}")
	public String getBookByKey(@PathVariable Long bookId, Model model){
	    //根据书籍ID查看书籍信息
		TbNovel novel = novelService.selectNovelInfoByKey(bookId); 
		model.addAttribute("novel", novel);
		return "bookInfo";
	} 
 	@RequestMapping(value="/chapter/{bookId}")
 	public String getNovelChapterByNovelId(@PathVariable Long bookId, Model model){
 		//根据书籍ID查看书籍信息
 		 
 		long start = System.currentTimeMillis();
 		List<TbChapter> chapters = chapterService.getChaptersByNovelId(bookId);
 		long middle = System.currentTimeMillis();
 		TbNovel novel = novelService.selectNovelInfoByKey(bookId); 
 		long end = System.currentTimeMillis();
 		
 		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy年-MM月dd日-HH时mm分ss秒");

 		Date startdate = new Date(start);
 		Date middledate = new Date(middle);
 		Date enddate = new Date(end);

 		System.out.println(start+"start --- "+formatter.format(startdate));
 		System.out.println(middle+"middle --- "+formatter.format(middledate));
 		System.out.println(end+"end --- "+formatter.format(enddate));
 		System.out.println("-----------******------------");
 		model.addAttribute("novel", novel);
 		model.addAttribute("chapters", chapters);
 		model.addAttribute("count", chapters.size());
 		return "bookdire";
 	} 
	
 	@RequestMapping(value="/chapter/{bookId}/{chapterId}")
 	public String getChapterDatilByNovelId(@PathVariable Long bookId,@PathVariable Long chapterId, Model model){
 		//编号获取章节内容
 		TbChapter chapter = chapterService.getChaptersById(bookId, chapterId); 
		ChapterDetail cd = chapterService.getChaptersDetailById(bookId,chapterId);
 		String content = cd.getContent();
 		content = content.replace("  " ,"&nbsp;&nbsp;").replace("\n" ,"<br />");
		cd.setContent(content);
		 
 		model.addAttribute("cd", cd);
 		model.addAttribute("chapter", chapter);
 		 
 		return "bookread";
 	} */
	
}

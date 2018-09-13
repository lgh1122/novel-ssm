package com.novel.rest.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.novel.common.mapper.TbNovelMapper;
import com.novel.common.pojo.TbNovelExample;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.novel.common.pojo.TbChapter;
import com.novel.common.pojo.TbNovel;
import com.novel.common.util.ExceptionUtil;
import com.novel.common.util.JsonResult;
import com.novel.common.util.SearchResult;
import com.novel.rest.converter.ManageConvent;
import com.novel.rest.service.SearchService;
import com.novel.rest.service.TbChapterService;
import com.novel.rest.service.TbNovelService;
import com.novel.spider.entitys.SpiderChapter;
import com.novel.spider.entitys.SpiderNovel;
import com.novel.spider.intf.IChapterSpider;
import com.novel.spider.util.ChapterSpiderFactory;
import com.novel.spider.util.CommonUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * create by liuguanghui on 2018/5/12 为前端系统提供数据服务
 *
 *
 *
 **/
@Controller
@RequestMapping("/novel")
@Api(tags = "小说信息获取api", description = "简单的API")
public class NovelController {

	public static Logger logger = Logger.getLogger(NovelController.class);

	@Autowired
	private TbNovelService tbNovelService;

	@Autowired
	private TbNovelMapper novelMapper;

	@Autowired
	private TbChapterService tbChapterService;

	@Autowired
	private SearchService searchService;

	@ResponseBody
	@RequestMapping("findUpdate")
	public List<TbNovel> findUpdateNovleInfo(List<Long> list){
		/*List<Long> list = new ArrayList<>();
		list.add(123909L);
		list.add(77550L);
		list.add(58919L);
		list.add(82546L);*/
		/*TbNovelExample example = new TbNovelExample();
		TbNovelExample.Criteria criteria = example.createCriteria();
		criteria.andIdIn(list);*/
		return  novelMapper.selectBookShelfUpdateInfo(list);
	}
	
	/**
	 *
	 * @param page
	 *            当前页
	 * @param rows
	 *            每页多少数据
	 * @param novel
	 *            请求参数
	 * @return
	 */
	@RequestMapping(value = "/list")
	@ApiOperation(httpMethod = "POST", value = "查询小说列表", notes = "根据小说名称或作者名关键字查询小说")

	@ApiResponses({ @ApiResponse(code = 404, message = "连接异常"), @ApiResponse(code = 500, message = "接口异常"), })
	@ResponseBody
	public JsonResult gettbNovelList(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "rows", defaultValue = "30") int rows, TbNovel novel, HttpServletRequest request)
			throws UnsupportedEncodingException {
		// TbNovel tbNovel = new TbNovel();
		// tbNovel.setTitle(novel.get);
		/*
		 * if("GET".equalsIgnoreCase( request.getMethod())){ if(novel.getTitle()!=null){
		 * // novel.setTitle(new
		 * String(novel.getTitle().getBytes("ISO-8859-1"),"UTF-8")); String title =
		 * novel.getTitle();
		 * logger.info("novelcontroller search() 未转码时查询参数 queryString="+title);
		 * novel.setTitle(new String(title.getBytes("ISO-8859-1"),"UTF-8") );
		 * logger.info("novelcontroller search() 转码后查询参数 queryString="+novel.getTitle())
		 * ; } }
		 */

		logger.info("未转码时查询参数 queryString=" + novel.getTitle());
		SearchResult searchResult = tbNovelService.getTbNovelList(page, rows, novel);
		// 计算总页数
		long recordCount = searchResult.getRecordCount();
		long pageCount = recordCount / rows;
		if (recordCount % rows > 0) {
			pageCount++;
		}
		searchResult.setPageCount(pageCount);
		searchResult.setCurPage(page);
		return JsonResult.ok(searchResult);
	}

	@RequestMapping(value = "/query", method = RequestMethod.POST)
	@ApiOperation(httpMethod = "POST", value = "查询小说列表", notes = "根据小说名称或作者名关键字查询小说")
	// @ApiOperation(httpMethod = "GET", value = "查询小说列表", notes =
	// "根据小说名称或作者名关键字查询小说")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "q", value = "查询参数小说名和作者名关键字", dataType = "String", paramType = "form"),
			@ApiImplicitParam(name = "page", value = "第几页", defaultValue = "1", dataType = "java.lang.Long", required = false),
			@ApiImplicitParam(name = "rows", value = "每页行数", defaultValue = "50", dataType = "java.lang.Long", required = false) })
	@ApiResponses({ @ApiResponse(code = 404, message = "连接异常"), @ApiResponse(code = 500, message = "接口异常"), })
	@ResponseBody
	public JsonResult search(@RequestParam("q") String queryString,
			@RequestParam(defaultValue = "novel_keywords") String df, @RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "20") Integer rows, HttpServletRequest request) {
		// 查询条件不能为空
		logger.info("novelcontroller search() 未转码时查询参数 queryString=" + queryString);
		if (StringUtils.isBlank(queryString)) {
			return JsonResult.build(400, "查询条件不能为空");
		}
		SearchResult searchResult = null;
		try {
			/*
			 * if("GET".equalsIgnoreCase( request.getMethod())){ if(queryString!=null){
			 * queryString = new String(queryString.getBytes("ISO-8859-1"),"UTF-8"); } }
			 */

			searchResult = searchService.searchNovels(queryString, df, page, rows);
			logger.info("novelcontroller search() 查询参数 queryString=" + queryString + "  查询结果总记录数："
					+ searchResult.getRecordCount());
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.build(500, ExceptionUtil.getStackTrace(e));
		}

		return JsonResult.ok(searchResult);
	}

	/**
	 * 导入书籍数据到索引库
	 * 
	 * @return
	 */
	@ApiOperation(httpMethod = "GET", value = "导入书籍数据到索引库", notes = "将书籍数据导入solr索引库")
	@RequestMapping("/importNovel")
	@ResponseBody
	public JsonResult importAllItems() {
		// searchService.importItems()
		return JsonResult.ok();
	}

	@ApiOperation(httpMethod = "GET", value = "查询小说信息", notes = "根据小说章节id获取小说信息")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "netId", value = "所属网站id", dataType = "java.lang.Long", paramType = "path", required = true),
			@ApiImplicitParam(name = "id", value = "小说id", dataType = "java.lang.Long", paramType = "path", required = true) })
	@ApiResponses({ @ApiResponse(code = 404, message = "连接异常"), @ApiResponse(code = 500, message = "接口异常"), })
	@RequestMapping("/info/{netId}/{id}")
	@ResponseBody
	public JsonResult getNovelInfoById(@PathVariable long netId, @PathVariable long id) {
		TbNovel tbNovel = tbNovelService.getNovelDescByID(netId, id);
		// model.addAttribute("tbNovel", tbNovel);
		if (tbNovel != null && tbNovel.getIntroduction() != null && !"".equals(tbNovel.getIntroduction())
				&& tbNovel.getIshaschapter() != null && tbNovel.getIshaschapter() == 1) {
			SpiderNovel spiderNovel = ManageConvent.tbNovelToSpiderNovel(tbNovel);
			return JsonResult.ok(spiderNovel);
		} else {
			try {
				SpiderNovel spiderNovel = ManageConvent.tbNovelToSpiderNovel(tbNovel);
				spiderNovel.setLatestchapterid(null);
				IChapterSpider chapterSpider = ChapterSpiderFactory.getChapterSpider(spiderNovel.getNetUrl());
				Map<String, Object> map = chapterSpider.getsChapter(spiderNovel);
				if (map.size() > 0) {
					// logger.debug(Thread.currentThread().getName()+"小说--- 正在抓取章节列表" );

					SpiderChapter upChapter = (SpiderChapter) map.get("updateChapter");
					if (upChapter != null) {
						// 原最后一章节需要更新 update;
						TbChapter tc = ManageConvent.spiderToTbChapter(upChapter);
						tbChapterService.updateTbChapter(tc);
					}
					List<SpiderChapter> piderChapters = (List<SpiderChapter>) map.get("insertchapter");
					if (piderChapters != null && piderChapters.size() > 0) {
						Map<String, List<SpiderChapter>> subListMap = CommonUtil.subChapterList(piderChapters, 50);
						for (Map.Entry<String, List<SpiderChapter>> entry : subListMap.entrySet()) {
							List<SpiderChapter> childChapters = entry.getValue();
							// 批量插入
							List<TbChapter> chapters = ManageConvent.spiderToTbChapterList(childChapters);
							try {
								tbChapterService.insertBatchTbChapter(chapters);
							} catch (Exception e) {
								logger.error("小说" + tbNovel.getId() + "--" + tbNovel.getTitle() + "违反唯一约束");
								tbChapterService.deleteChapterByNovelId(tbNovel.getNetid(), tbNovel.getId());
								throw e;
							}
						}
						tbNovel.setIshaschapter((byte) 1);
					}
					if (map.get("novel") != null) {
						SpiderNovel sNovel = (SpiderNovel) map.get("novel");
						TbNovel conventNovel = ManageConvent.spiderToTbNovel(sNovel);
						tbNovel.setLatestchapterid(conventNovel.getLatestchapterid());
						tbNovel.setLatestchaptername(conventNovel.getLatestchaptername());
						tbNovel.setStatus(conventNovel.getStatus());
						tbNovel.setUpdatetime(conventNovel.getUpdatetime());
						tbNovel.setImgpath(conventNovel.getImgpath());
						tbNovel.setIntroduction(conventNovel.getIntroduction());
						if (conventNovel.getIntroduction() == null || "".equals(conventNovel.getIntroduction())) {
							tbNovel.setIntroduction("暂无简介");
						}
						// 测试
						tbNovelService.updateTbNovel(tbNovel);
						// 要更新的小说书籍对象
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				logger.error(e.getMessage());
				return JsonResult.build(500, "获取书籍详情失败，请重新请求");
			}
			SpiderNovel spiderNovel = ManageConvent.tbNovelToSpiderNovel(tbNovel);
			// 更新完小说后，更新solr索引库
			searchService.addSolrDoc(spiderNovel);
			return JsonResult.ok(spiderNovel);
		}

	}

	/*
	 * @RequestMapping("/desc/{netId}/{id}")
	 * 
	 * @ResponseBody public JsonResult getNovelDescById(@PathVariable long
	 * netId,@PathVariable long id){ TbNovel tbNovel =
	 * tbNovelService.getNovelDescByID(netId,id); if(tbNovel!=null &&
	 * tbNovel.getIntroduction()!=null && !"".equals(tbNovel.getIntroduction())){
	 * return JsonResult.ok(tbNovel); }else{ ChapterProcessor spider = new
	 * KanShuZhongChapterStorageImpl(); try { tbNovel =
	 * spider.processNovelIntroductionAndImgPath(tbNovel); return
	 * JsonResult.ok(tbNovel); } catch (Exception e) {
	 * 
	 * e.printStackTrace(); } } return JsonResult.ok("暂无简介"); }
	 */

}

package com.novel.manage.service.impl;

import com.novel.common.mapper.TbNovelMapper;
import com.novel.common.pojo.TbNovel;
import com.novel.common.util.ExceptionUtil;
import com.novel.common.util.JsonResult;
import com.novel.manage.converter.ManageConvent;
import com.novel.manage.service.SearchService;
import com.novel.spider.entitys.SpiderNovel;
import org.apache.log4j.Logger;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("searchService")
public class SearchServiceImpl implements SearchService {

	public static Logger logger = Logger.getLogger(SearchServiceImpl.class);

	@Autowired
	private SolrServer solrServer;

	@Autowired
	private TbNovelMapper novelMapper;

	@Override
	public JsonResult importItems() {
		try {
			// 查询书籍列表
			List<TbNovel> list = novelMapper.selectByUpdateTime();
			// 把商品写入索引库
			for(TbNovel tbNovel : list){
				SpiderNovel item  = ManageConvent.tbNovelToSpiderNovel(tbNovel);
				// 创建一个SolrInputDocument对象
				SolrInputDocument document = new SolrInputDocument();
				document.addField("id", item.getId());
				document.addField("novel_title", item.getTitle());
				document.addField("novel_netid", item.getNetid());
				document.addField("novel_type", item.getTname());
				document.addField("novel_chapter_id", item.getLatestchapterid());
				document.addField("novel_chapter_name", item.getLatestchaptername());
				document.addField("novel_image", item.getImgpath());
				document.addField("novel_author",item.getAuthor());
				document.addField("novel_desc", item.getIntroduction());
				document.addField("novel_status", item.getStatus());
				// 写入索引库
				solrServer.add(document);
			}
			solrServer.commit();

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(ExceptionUtil.getStackTrace(e));
			return JsonResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		return JsonResult.ok();
	}


}

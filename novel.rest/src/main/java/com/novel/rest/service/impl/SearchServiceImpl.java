package com.novel.rest.service.impl;

import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.novel.common.mapper.TbNovelMapper;
import com.novel.common.pojo.TbNovel;
import com.novel.common.pojo.TbNovelExample;
import com.novel.common.util.ExceptionUtil;
import com.novel.common.util.JsonResult;
import com.novel.common.util.SearchResult;
import com.novel.rest.converter.ManageConvent;
import com.novel.rest.dao.SearchDao;
import com.novel.rest.service.SearchService;
import com.novel.spider.entitys.SpiderNovel;

@Service()
public class SearchServiceImpl implements SearchService {

	@Autowired
	private SolrServer solrServer;
	@Autowired
	private SearchDao searchDao;
	@Autowired
	private TbNovelMapper novelMapper;





	@Override
	public SearchResult searchNovels(String queryString, Integer page, Integer rows) throws Exception {
		//创建查询对象
		SolrQuery solrQuery = new SolrQuery();
		// 放置查询条件
		solrQuery.setQuery(queryString);
		// 设置分页
		solrQuery.setStart((page - 1)*rows);
		solrQuery.setRows(rows);
		// 设置默认搜索域
		solrQuery.set("df", "novel_keywords");
		//设置高亮显示
		solrQuery.setHighlight(true);
		solrQuery.addHighlightField("novel_title");
		solrQuery.setHighlightSimplePre("<em style=\"color:red\">");
		solrQuery.setHighlightSimplePost("</em>");
		// 执行查询
		//执行查询
		SearchResult searchResult =	searchDao.search(solrQuery);
		// 计算总页数
		long recordCount = searchResult.getRecordCount();
		long pageCount = recordCount / rows;
		if (recordCount % rows > 0) {
			pageCount++;
		}
		searchResult.setPageCount(pageCount);
		searchResult.setCurPage(page);
		return searchResult;
	}

	@Override
	public JsonResult importItems() {
		try {
			// 查询商品列表
			TbNovelExample example = new TbNovelExample();
			// 分页处理
			//PageHelper.startPage(1, 100);
			//Criteria criteria = example.createCriteria();
			//criteria.andtitleLike("%道%");
			// 查询书籍列表
			List<TbNovel> list = novelMapper.selectByExample(example);
			//List<TbNovel> list = novelMapper.selectByUpdateTime();
			//List<SpiderNovel> spiderNovels = ManageConvent.tbNovelToSpiderNovelList(list);
			// 把商品写入索引库
			for(TbNovel tbNovel : list){
				SpiderNovel item  = ManageConvent.tbNovelToSpiderNovel(tbNovel);
				// 创建一个SolrInputDocument对象
				SolrInputDocument document = new SolrInputDocument();
				document.addField("id", item.getId());
				document.addField("novel_netid", item.getNetid());
				document.addField("novel_title", item.getTitle());
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
			return JsonResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		return JsonResult.ok();
	}

    @Override
    public void addSolrDoc(SpiderNovel item) {
        try {
            // 创建一个SolrInputDocument对象
            SolrInputDocument document = new SolrInputDocument();
            document.addField("id", item.getId());
            document.addField("novel_netid", item.getNetid());
            document.addField("novel_title", item.getTitle());
            document.addField("novel_type", item.getTname());
            document.addField("novel_chapter_id", item.getLatestchapterid());
            document.addField("novel_chapter_name", item.getLatestchaptername());
            document.addField("novel_image", item.getImgpath());
            document.addField("novel_author",item.getAuthor());
            document.addField("novel_desc", item.getIntroduction());
            document.addField("novel_status", item.getStatus());
            // 写入索引库
            solrServer.add(document);
            solrServer.commit();

        } catch (Exception e) {
            e.printStackTrace();

        }
    }


}

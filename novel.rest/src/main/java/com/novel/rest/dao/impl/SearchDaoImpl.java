package com.novel.rest.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.novel.common.util.SearchResult;
import com.novel.rest.dao.SearchDao;
import com.novel.spider.entitys.SpiderNovel;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class SearchDaoImpl implements SearchDao {

	@Autowired
	private SolrServer solrServer;
	@Override
	public SearchResult search(SolrQuery solrQuery) throws SolrServerException {
		
		//返回值对象
	    SearchResult<SpiderNovel> result  = new SearchResult<SpiderNovel>();
		//根据查询条件查询索引库
	    QueryResponse response =	solrServer.query(solrQuery);
		//取查询结果
	    SolrDocumentList documentList =   response.getResults();
		//取查询结果总数量
	    result.setRecordCount(documentList.getNumFound());
		//商品列表
	    List<SpiderNovel> list = new ArrayList<>();
		//取高亮显示
	    Map<String, Map<String, List<String>>> highlighting =  response.getHighlighting();
		//取商品列表
	    for (SolrDocument solrDocument : documentList) {
			SpiderNovel item = new SpiderNovel();
			item.setId(Long.parseLong((String) solrDocument.get("id")));
		/*	List<String> lightList = (highlighting.get(item.getId())).get("novel_title");
			String title = "";
			if (lightList != null && lightList.size()>0) {
				title = lightList.get(0);
			} else {*/
			String	title = (String) solrDocument.get("novel_title");
			//}
			item.setTitle(title);
			item.setTname((String) solrDocument.get("novel_type"));
			item.setLatestchapterid((Long) solrDocument.get("novel_chapter_id"));
			item.setLatestchaptername((String) solrDocument.get("novel_chapter_name"));
			item.setImgpath((String) solrDocument.get("novel_image"));
			item.setAuthor((String)solrDocument.get("novel_author"));
			item.setIntroduction((String) solrDocument.get("novel_desc"));
			item.setNetid((Long) solrDocument.get("novel_netid"));
			int status = (int) solrDocument.get("novel_status");
			item.setStatus((byte) status);
			list.add(item);
			}
	    result.setItemList(list);
		return result;
	}


}

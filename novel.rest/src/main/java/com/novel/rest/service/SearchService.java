package com.novel.rest.service;

import com.novel.common.util.JsonResult;
import com.novel.common.util.SearchResult;
import com.novel.spider.entitys.SpiderNovel;

public interface SearchService {
	

	SearchResult searchNovels(String queryString, String df, Integer page, Integer rows) throws Exception;

	JsonResult importItems();

	void addSolrDoc(SpiderNovel spiderNovel);
}

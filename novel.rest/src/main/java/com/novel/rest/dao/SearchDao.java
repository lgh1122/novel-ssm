package com.novel.rest.dao;

import com.novel.common.util.SearchResult;
import org.apache.solr.client.solrj.SolrQuery;

public interface SearchDao {

	SearchResult search(SolrQuery solrQuery) throws Exception;



}

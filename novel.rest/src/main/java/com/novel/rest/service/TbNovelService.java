package com.novel.rest.service;

import com.novel.common.pojo.TbNovel;
import com.novel.common.util.EUDataGridResult;
import com.novel.common.util.SearchResult;

import java.util.List;

public interface TbNovelService {
	
	public void insertBatchTbNovel(List<TbNovel> list) ;


	public SearchResult getTbNovelList(Integer page, Integer rows, TbNovel tbNovel);

	public TbNovel getNovelDescByID(long netId, long id);

	public void updateTbNovel(TbNovel tbNovel);

	public int insertTbNovel(TbNovel tbNovel);
}

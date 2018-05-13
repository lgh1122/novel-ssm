package com.novel.rest.service;

import com.novel.common.pojo.TbNovel;
import com.novel.common.util.EUDataGridResult;

import java.util.List;

public interface TbNovelService {
	
	public void insertBatchTbNovel(List<TbNovel> list) ;


	public EUDataGridResult getTbNovelList(Integer page, Integer rows, TbNovel tbNovel);

	public TbNovel getNovelDescByID(long netId, long id);

	public void updateTbNovel(TbNovel tbNovel);

	public int insertTbNovel(TbNovel tbNovel);
}

package com.novel.manage.service;

import java.util.List;

import com.novel.common.pojo.TbNovel;
import com.novel.common.util.EUDataGridResult;

public interface TbNovelService {
	
	public void insertBatchTbNovel(List<TbNovel> list) ;

	public int insertOrupdateTbNovel(TbNovel tbNovel);

	public EUDataGridResult getTbNovelList(Integer page, Integer rows, TbNovel tbNovel);

	public TbNovel getNovelDescByID(long netId, long id);

	public void updateTbNovel(TbNovel tbNovel);

}

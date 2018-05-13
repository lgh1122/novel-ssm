package com.novel.manage.service;

import com.novel.common.pojo.TbChapter;
import com.novel.common.pojo.TbNovel;
import com.novel.common.util.EUDataGridResult;

import java.util.List;

public interface TbChapterService {
	
	public void insertBatchTbChapter(List<TbChapter> list) ;

	public int insertTbChapter(TbChapter tbChapter);

	public List<TbChapter> getTbChapterList(long netId, long novelId , long chapterId);

	public TbChapter getTbChapter(long netId, long novelId , long chapterId);

	public void updateTbChapter(TbChapter tbChapter);

}

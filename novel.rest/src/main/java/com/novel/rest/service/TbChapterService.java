package com.novel.rest.service;

import com.novel.common.pojo.TbChapter;

import java.util.List;

public interface TbChapterService {
	
	public void insertBatchTbChapter(List<TbChapter> list) ;

	public int insertTbChapter(TbChapter tbChapter);

	public List<TbChapter> getTbChapterList(long netId, long novelId, long chapterId);

	public TbChapter getTbChapter(long netId, long novelId, long chapterId);

	public void updateTbChapter(TbChapter tbChapter);

	public void deleteChapterByNovelId(long netId , long novelId);

	public List<TbChapter> getChapterList(long netId, long id);
}

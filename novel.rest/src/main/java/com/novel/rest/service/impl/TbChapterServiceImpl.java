package com.novel.rest.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.novel.common.mapper.TbChapterMapper;
import com.novel.common.pojo.*;
import com.novel.common.util.EUDataGridResult;
import com.novel.common.util.SearchResult;
import com.novel.rest.converter.ManageConvent;
import com.novel.rest.service.TbChapterService;
import com.novel.spider.entitys.SpiderNovel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("tbChapterService")
public class TbChapterServiceImpl implements TbChapterService {

	@Autowired
	private TbChapterMapper chapterMapper;


	@Override
	public void insertBatchTbChapter(List<TbChapter> list) {
		chapterMapper.batchInsert(list);
	}

	@Override
	public int insertTbChapter(TbChapter tbChapter) {
		return chapterMapper.insert(tbChapter);
	}

	@Override
	public List<TbChapter> getTbChapterList(long netId, long novelId, long chapterId) {
		TbChapterExample example = new TbChapterExample();
		// 分页处理

		TbChapterExample.Criteria criteria = example.createCriteria();

		criteria.andIdEqualTo(chapterId);
		criteria.andNovelIdEqualTo(novelId);
		criteria.andNetidEqualTo(netId);
		return chapterMapper.selectByExample(example);
	}

	@Override
	public TbChapter getTbChapter(long netId, long novelId, long chapterId) {
		TbChapterKey key = new TbChapterKey();
		key.setId(chapterId);
		key.setNetid(netId);
		key.setNovelId(novelId);
		return chapterMapper.selectByPrimaryKey(key);

	}

	@Override
	public void updateTbChapter(TbChapter tbChapter) {
        chapterMapper.updateByPrimaryKey(tbChapter);
	}

	@Override
	public void deleteChapterByNovelId(long netId, long novelId) {
		TbChapterExample example = new TbChapterExample();
		TbChapterExample.Criteria criteria = example.createCriteria();
		criteria.andNovelIdEqualTo(novelId);
		criteria.andNetidEqualTo(netId);
		chapterMapper.deleteByExample(example);
	}

	@Override
	public List<TbChapter> getChapterList(long netId, long novelId) {
		TbChapterExample example = new TbChapterExample();
		TbChapterExample.Criteria criteria = example.createCriteria();
		criteria.andNovelIdEqualTo(novelId);
		criteria.andNetidEqualTo(netId);
		return chapterMapper.selectByExample(example);
	}

	@Override
	public SearchResult getChapterListLimit(long netId, long novelId, Long startChapterId, Integer page, Integer rows) {
		SearchResult<TbChapter> searchResult= new SearchResult<TbChapter>();
		// 分页处理
		PageHelper.startPage(page, rows);

		TbChapterExample example = new TbChapterExample();
		TbChapterExample.Criteria criteria = example.createCriteria();
		criteria.andNovelIdEqualTo(novelId);
		criteria.andNetidEqualTo(netId);
		if(startChapterId !=null){
			criteria.andIdGreaterThanOrEqualTo(startChapterId);
		}

		List<TbChapter> tbChapters =	chapterMapper.selectByExample(example);
		// 取记录总条数
		PageInfo<TbChapter> pageInfo = new PageInfo<TbChapter>(tbChapters);
		searchResult.setItemList(tbChapters);
		searchResult.setRecordCount(pageInfo.getTotal());
		searchResult.setCurPage(page);
		// 计算总页数
		long recordCount = searchResult.getRecordCount();
		long pageCount = recordCount / rows;
		if (recordCount % rows > 0) {
			pageCount++;
		}
		searchResult.setPageCount(pageCount);

		return searchResult;
	}
}

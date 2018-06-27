package com.novel.manage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.novel.common.mapper.TbChapterMapper;
import com.novel.common.mapper.TbNovelMapper;
import com.novel.common.pojo.*;

import com.novel.common.util.EUDataGridResult;
import com.novel.manage.service.TbChapterService;
import com.novel.manage.service.TbNovelService;
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
		return null;
	}

	@Override
	public void updateTbChapter(TbChapter tbChapter) {
        chapterMapper.updateByPrimaryKey(tbChapter);
	}

	@Override
	public void deleteChapterByGreaterId(TbChapter tc) {
		TbChapterExample example = new TbChapterExample();
		// 分页处理

		TbChapterExample.Criteria criteria = example.createCriteria();

		criteria.andIdGreaterThan(tc.getId());
		criteria.andNovelIdEqualTo(tc.getNovelId());
		criteria.andNetidEqualTo(tc.getNetid());
		
		chapterMapper.deleteByExample(example);
		
	}
}

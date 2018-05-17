package com.novel.rest.service.impl;

import com.novel.common.mapper.TbChapterMapper;
import com.novel.common.pojo.TbChapter;
import com.novel.common.pojo.TbChapterExample;
import com.novel.common.pojo.TbChapterKey;
import com.novel.rest.service.TbChapterService;
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
}

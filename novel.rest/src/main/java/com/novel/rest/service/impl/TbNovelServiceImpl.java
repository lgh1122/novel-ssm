package com.novel.rest.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.novel.common.mapper.TbNovelMapper;
import com.novel.common.pojo.TbNovel;
import com.novel.common.pojo.TbNovelExample;
import com.novel.common.pojo.TbNovelExample.Criteria;
import com.novel.common.pojo.TbNovelKey;
import com.novel.common.util.EUDataGridResult;
import com.novel.common.util.SearchResult;
import com.novel.rest.converter.ManageConvent;
import com.novel.rest.service.TbNovelService;
import com.novel.spider.entitys.SpiderNovel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("tbNovelService")
public class TbNovelServiceImpl implements TbNovelService {

	@Autowired
	private TbNovelMapper novelMapper;

	@Override
	public void insertBatchTbNovel(List<TbNovel> list) {
		System.out.println("hello");
		novelMapper.batchInsert(list);

	}





	// 书籍列表实现
	@Override
	public SearchResult getTbNovelList(Integer page, Integer rows,TbNovel tbNovel) {
		SearchResult<SpiderNovel> searchResult= new SearchResult<>();
		TbNovelExample example = new TbNovelExample();
		// 分页处理
		PageHelper.startPage(page, rows);
		Criteria criteria = example.createCriteria();
		if(tbNovel.getTitle() !=null && !"".equals(tbNovel.getTitle())){
			criteria.andtitleLike("%"+tbNovel.getTitle()+"%");
		}
		
		if(tbNovel.getAuthor() !=null && !"".equals(tbNovel.getAuthor())){
			criteria.andAuthorLike("%"+tbNovel.getAuthor()+"%");
		}
		// 查询书籍列表
		List<TbNovel> list = novelMapper.selectByExample(example);
		List<SpiderNovel> spiderNovels = ManageConvent.tbNovelToSpiderNovelList(list);
 		// 取记录总条数
		PageInfo<TbNovel> pageInfo = new PageInfo<>(list);
		searchResult.setItemList(spiderNovels); 
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

	@Override
	public TbNovel getNovelDescByID(long netId, long id) {
		TbNovelKey key = new TbNovelKey();
		key.setId(id);
		key.setNetid(netId);
		return novelMapper.selectByPrimaryKey(key);
	}

	@Override
	public void updateTbNovel(TbNovel tbNovel) {
		novelMapper.updateByPrimaryKeySelective(tbNovel);
	}

    @Override
    public int insertTbNovel(TbNovel tbNovel) {
	    return novelMapper.insert(tbNovel);

    }
}

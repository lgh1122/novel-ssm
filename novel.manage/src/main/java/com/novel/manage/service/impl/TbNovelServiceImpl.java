package com.novel.manage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.novel.common.mapper.TbNovelMapper;
import com.novel.common.pojo.TbNovel;
import com.novel.common.pojo.TbNovelExample;
import com.novel.common.pojo.TbNovelExample.Criteria;
import com.novel.common.pojo.TbNovelKey;
import com.novel.common.util.EUDataGridResult;
import com.novel.manage.service.TbNovelService;

@Service("tbNovelService")
public class TbNovelServiceImpl implements TbNovelService {

	@Autowired
	private TbNovelMapper novelMapper;

	@Override
	public void insertBatchTbNovel(List<TbNovel> list) {
		System.out.println("hello");
		novelMapper.batchInsert(list);

	}



	@Override
	public int insertOrupdateTbNovel(TbNovel tbNovel) {
		TbNovel oldNovel = novelMapper.selectByPrimaryKey(tbNovel);
		if (oldNovel != null) {
			oldNovel.setLatestchapterid(tbNovel.getLatestchapterid());
			oldNovel.setLatestchaptername(tbNovel.getLatestchaptername());
			oldNovel.setStatus(tbNovel.getStatus());
			oldNovel.setUpdatetime(tbNovel.getUpdatetime());
			return novelMapper.updateByPrimaryKey(oldNovel);
		} else {
			return novelMapper.insert(tbNovel);
		}

	}

	// 书籍列表实现
	@Override
	public EUDataGridResult getTbNovelList(Integer page, Integer rows,TbNovel tbNovel) {
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
		
		if(tbNovel.getTname() !=null && !"".equals(tbNovel.getTname())){
			criteria.andTnameLike("%"+tbNovel.getTname()+"%");
		}
		
		// 查询书籍列表
		List<TbNovel> list = novelMapper.selectByExample(example);
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		// 取记录总条数
		PageInfo<TbNovel> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
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

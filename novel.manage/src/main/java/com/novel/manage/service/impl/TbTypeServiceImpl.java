package com.novel.manage.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.novel.common.mapper.TbTypeMapper;
import com.novel.common.pojo.TbType;
import com.novel.common.pojo.TbTypeExample;
import com.novel.common.pojo.TbTypeExample.Criteria;
import com.novel.common.util.EUTreeNode;
import com.novel.manage.service.TbTypeService;

@Service
public class TbTypeServiceImpl implements TbTypeService{

	@Autowired
	private TbTypeMapper typeMapper;

	@Override
	public List<EUTreeNode> getTbTypeList() {
		    TbTypeExample example = new TbTypeExample();
		    Criteria criteria =    example.createCriteria();
		    criteria.andNetidEqualTo(3L);
			List<TbType> list = typeMapper.selectByExample(example);
			// 把列表转换为TreeNodeList
			List<EUTreeNode> resultList = new ArrayList<EUTreeNode>();
			for(TbType item : list){
				EUTreeNode node = new EUTreeNode();
				node.setId(item.getId());
				node.setText(item.getTypename());
				node.setState(false?"closed":"open");
				resultList.add(node);
			}
		return resultList;
	}
	
	 

 

}

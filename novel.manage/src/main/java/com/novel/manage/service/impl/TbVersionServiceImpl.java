package com.novel.manage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.novel.common.mapper.TbVersionMapper;
import com.novel.common.pojo.*;
import com.novel.common.util.EUDataGridResult;
import com.novel.manage.service.TbVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * create by liuguanghui on 2018/5/3
 **/
@Service
public class TbVersionServiceImpl implements TbVersionService {

    @Autowired
    private TbVersionMapper tbVersionMapper;

    @Override
    public EUDataGridResult getTbVersionList(Integer page, Integer rows) {
        TbVersionExample example = new TbVersionExample();
        PageHelper.startPage(page, rows);
        // 查询书籍列表
        List<TbVersion> list = tbVersionMapper.selectByExample(example);
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        // 取记录总条数
        PageInfo<TbVersion> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }
}

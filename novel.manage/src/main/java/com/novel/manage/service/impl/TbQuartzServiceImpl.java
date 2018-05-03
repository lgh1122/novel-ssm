package com.novel.manage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.novel.common.mapper.TbQuartzConfigMapper;
import com.novel.common.pojo.TbNovel;
import com.novel.common.pojo.TbQuartzConfig;
import com.novel.common.pojo.TbQuartzConfigExample;
import com.novel.common.util.EUDataGridResult;
import com.novel.manage.service.TbQuartzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * create by liuguanghui on 2018/5/3
 **/
@Service
public class TbQuartzServiceImpl implements TbQuartzService {

    @Autowired
    private TbQuartzConfigMapper tbQuartzConfigMapper;

    @Override
    public EUDataGridResult getTbQuartzList(Integer page, Integer rows, TbNovel novel) {
        TbQuartzConfigExample example = new TbQuartzConfigExample();
        PageHelper.startPage(page, rows);
        TbQuartzConfigExample.Criteria  criteria =  example.createCriteria();
        // 查询书籍列表
        List<TbQuartzConfig> list = tbQuartzConfigMapper.selectByExample(example);
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        // 取记录总条数
        PageInfo<TbQuartzConfig> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }
}

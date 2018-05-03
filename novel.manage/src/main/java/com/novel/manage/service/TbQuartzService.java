package com.novel.manage.service;

import com.novel.common.pojo.TbNovel;
import com.novel.common.util.EUDataGridResult;

/**
 * create by liuguanghui on 2018/5/3
 **/
public interface TbQuartzService {
    EUDataGridResult getTbQuartzList(Integer page, Integer rows, TbNovel novel);
}

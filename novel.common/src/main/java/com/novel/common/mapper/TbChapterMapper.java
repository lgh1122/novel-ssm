package com.novel.common.mapper;

import java.util.List;

import com.novel.common.pojo.TbNovel;
import org.apache.ibatis.annotations.Param;

import com.novel.common.pojo.TbChapter;
import com.novel.common.pojo.TbChapterExample;
import com.novel.common.pojo.TbChapterKey;

public interface TbChapterMapper {
    int countByExample(TbChapterExample example);

    int deleteByExample(TbChapterExample example);

    int deleteByPrimaryKey(TbChapterKey key);

    int insert(TbChapter record);

    int insertSelective(TbChapter record);

    List<TbChapter> selectByExample(TbChapterExample example);

    TbChapter selectByPrimaryKey(TbChapterKey key);

    int updateByExampleSelective(@Param("record") TbChapter record, @Param("example") TbChapterExample example);

    int updateByExample(@Param("record") TbChapter record, @Param("example") TbChapterExample example);

    int updateByPrimaryKeySelective(TbChapter record);

    int updateByPrimaryKey(TbChapter record);

    void batchInsert(List<TbChapter> list);
}
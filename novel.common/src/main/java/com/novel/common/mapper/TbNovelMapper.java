package com.novel.common.mapper;

import com.novel.common.pojo.TbNovel;
import com.novel.common.pojo.TbNovelExample;
import com.novel.common.pojo.TbNovelKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbNovelMapper {
    int countByExample(TbNovelExample example);

    int deleteByExample(TbNovelExample example);

    int deleteByPrimaryKey(TbNovelKey key);

    int insert(TbNovel record);

    int insertSelective(TbNovel record);

    List<TbNovel> selectByExample(TbNovelExample example);

    List<TbNovel> selectByUpdateTime( );

    List<TbNovel> selectBookShelfUpdateInfo(List<Long> list);

    TbNovel selectByPrimaryKey(TbNovelKey key);

    int updateByExampleSelective(@Param("record") TbNovel record, @Param("example") TbNovelExample example);

    int updateByExample(@Param("record") TbNovel record, @Param("example") TbNovelExample example);

    int updateByPrimaryKeySelective(TbNovel record);

    int updateByPrimaryKey(TbNovel record);
    
    void batchInsert(List<TbNovel> list);
}
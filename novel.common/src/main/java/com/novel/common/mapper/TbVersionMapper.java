package com.novel.common.mapper;

import com.novel.common.pojo.TbVersion;
import com.novel.common.pojo.TbVersionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbVersionMapper {
    int countByExample(TbVersionExample example);

    int deleteByExample(TbVersionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbVersion record);

    int insertSelective(TbVersion record);

    List<TbVersion> selectByExample(TbVersionExample example);

    TbVersion selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbVersion record, @Param("example") TbVersionExample example);

    int updateByExample(@Param("record") TbVersion record, @Param("example") TbVersionExample example);

    int updateByPrimaryKeySelective(TbVersion record);

    int updateByPrimaryKey(TbVersion record);
}
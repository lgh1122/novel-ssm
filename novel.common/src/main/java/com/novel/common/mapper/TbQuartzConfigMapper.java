package com.novel.common.mapper;

import com.novel.common.pojo.TbQuartzConfig;
import com.novel.common.pojo.TbQuartzConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbQuartzConfigMapper {
    int countByExample(TbQuartzConfigExample example);

    int deleteByExample(TbQuartzConfigExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbQuartzConfig record);

    int insertSelective(TbQuartzConfig record);

    List<TbQuartzConfig> selectByExample(TbQuartzConfigExample example);

    TbQuartzConfig selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbQuartzConfig record, @Param("example") TbQuartzConfigExample example);

    int updateByExample(@Param("record") TbQuartzConfig record, @Param("example") TbQuartzConfigExample example);

    int updateByPrimaryKeySelective(TbQuartzConfig record);

    int updateByPrimaryKey(TbQuartzConfig record);
}
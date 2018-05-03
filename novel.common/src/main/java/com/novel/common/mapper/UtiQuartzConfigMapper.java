package com.novel.common.mapper;

import com.novel.common.pojo.UtiQuartzConfig;
import com.novel.common.pojo.UtiQuartzConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UtiQuartzConfigMapper {
    int countByExample(UtiQuartzConfigExample example);

    int deleteByExample(UtiQuartzConfigExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UtiQuartzConfig record);

    int insertSelective(UtiQuartzConfig record);

    List<UtiQuartzConfig> selectByExample(UtiQuartzConfigExample example);

    UtiQuartzConfig selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UtiQuartzConfig record, @Param("example") UtiQuartzConfigExample example);

    int updateByExample(@Param("record") UtiQuartzConfig record, @Param("example") UtiQuartzConfigExample example);

    int updateByPrimaryKeySelective(UtiQuartzConfig record);

    int updateByPrimaryKey(UtiQuartzConfig record);
}
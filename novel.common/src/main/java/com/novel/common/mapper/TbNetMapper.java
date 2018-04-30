package com.novel.common.mapper;

import com.novel.common.pojo.TbNet;
import com.novel.common.pojo.TbNetExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbNetMapper {
    int countByExample(TbNetExample example);

    int deleteByExample(TbNetExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbNet record);

    int insertSelective(TbNet record);

    List<TbNet> selectByExampleWithBLOBs(TbNetExample example);

    List<TbNet> selectByExample(TbNetExample example);
    
    List<TbNet> selectList();

    TbNet selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbNet record, @Param("example") TbNetExample example);

    int updateByExampleWithBLOBs(@Param("record") TbNet record, @Param("example") TbNetExample example);

    int updateByExample(@Param("record") TbNet record, @Param("example") TbNetExample example);

    int updateByPrimaryKeySelective(TbNet record);

    int updateByPrimaryKeyWithBLOBs(TbNet record);

    int updateByPrimaryKey(TbNet record);
}
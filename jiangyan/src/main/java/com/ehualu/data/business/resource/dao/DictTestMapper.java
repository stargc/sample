package com.ehualu.data.business.resource.dao;

import com.ehualu.data.business.resource.model.DictTest;
import com.ehualu.data.business.resource.model.DictTestExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DictTestMapper {
    int countByExample(DictTestExample example);

    int deleteByExample(DictTestExample example);

    int insert(DictTest record);

    int insertSelective(DictTest record);

    List<DictTest> selectByExampleWithBLOBs(DictTestExample example);

    List<DictTest> selectByExample(DictTestExample example);

    int updateByExampleSelective(@Param("record") DictTest record, @Param("example") DictTestExample example);

    int updateByExampleWithBLOBs(@Param("record") DictTest record, @Param("example") DictTestExample example);

    int updateByExample(@Param("record") DictTest record, @Param("example") DictTestExample example);
}
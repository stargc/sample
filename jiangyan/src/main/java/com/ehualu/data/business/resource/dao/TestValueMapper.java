package com.ehualu.data.business.resource.dao;

import com.ehualu.data.business.resource.model.TestValue;
import com.ehualu.data.business.resource.model.TestValueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TestValueMapper {
    int countByExample(TestValueExample example);

    int deleteByExample(TestValueExample example);

    int insert(TestValue record);

    int insertSelective(TestValue record);

    List<TestValue> selectByExample(TestValueExample example);

    int updateByExampleSelective(@Param("record") TestValue record, @Param("example") TestValueExample example);

    int updateByExample(@Param("record") TestValue record, @Param("example") TestValueExample example);
}
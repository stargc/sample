package com.ehualu.data.business.resource.dao;

import com.ehualu.data.business.resource.model.Table;
import com.ehualu.data.business.resource.model.TableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TableMapper {
    int countByExample(TableExample example);

    int deleteByExample(TableExample example);

    int insert(Table record);

    int insertSelective(Table record);

    List<Table> selectByExample(TableExample example);

    int updateByExampleSelective(@Param("record") Table record, @Param("example") TableExample example);

    int updateByExample(@Param("record") Table record, @Param("example") TableExample example);
}
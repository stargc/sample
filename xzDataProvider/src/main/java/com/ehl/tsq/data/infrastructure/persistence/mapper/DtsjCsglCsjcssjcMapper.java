package com.ehl.tsq.data.infrastructure.persistence.mapper;

import com.ehl.tsq.data.infrastructure.persistence.po.DtsjCsglCsjcssjc;
import com.ehl.tsq.data.infrastructure.persistence.po.DtsjCsglCsjcssjcExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DtsjCsglCsjcssjcMapper {
    int countByExample(DtsjCsglCsjcssjcExample example);

    int deleteByExample(DtsjCsglCsjcssjcExample example);

    int insert(DtsjCsglCsjcssjc record);

    int insertSelective(DtsjCsglCsjcssjc record);

    List<DtsjCsglCsjcssjc> selectByExample(DtsjCsglCsjcssjcExample example);

    int updateByExampleSelective(@Param("record") DtsjCsglCsjcssjc record, @Param("example") DtsjCsglCsjcssjcExample example);

    int updateByExample(@Param("record") DtsjCsglCsjcssjc record, @Param("example") DtsjCsglCsjcssjcExample example);
}
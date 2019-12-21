package com.ehl.tsq.data.infrastructure.persistence.mapper;

import com.ehl.tsq.data.infrastructure.persistence.po.BaseStatistics;
import com.ehl.tsq.data.infrastructure.persistence.po.BaseStatisticsExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface BaseStatisticsMapper {
    int countByExample(BaseStatisticsExample example);

    int deleteByExample(BaseStatisticsExample example);

    int insert(BaseStatistics record);

    int insertSelective(BaseStatistics record);

    List<BaseStatistics> selectByExample(BaseStatisticsExample example);

    int updateByExampleSelective(@Param("record") BaseStatistics record, @Param("example") BaseStatisticsExample example);

    int updateByExample(@Param("record") BaseStatistics record, @Param("example") BaseStatisticsExample example);
}
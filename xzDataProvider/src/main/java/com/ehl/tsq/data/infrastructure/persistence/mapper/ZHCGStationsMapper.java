package com.ehl.tsq.data.infrastructure.persistence.mapper;

import com.ehl.tsq.data.infrastructure.persistence.po.ZHCGStations;
import com.ehl.tsq.data.infrastructure.persistence.po.ZHCGStationsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZHCGStationsMapper {
    int countByExample(ZHCGStationsExample example);

    int deleteByExample(ZHCGStationsExample example);

    int insert(ZHCGStations record);

    int insertSelective(ZHCGStations record);

    List<ZHCGStations> selectByExample(ZHCGStationsExample example);

    int updateByExampleSelective(@Param("record") ZHCGStations record, @Param("example") ZHCGStationsExample example);

    int updateByExample(@Param("record") ZHCGStations record, @Param("example") ZHCGStationsExample example);
}
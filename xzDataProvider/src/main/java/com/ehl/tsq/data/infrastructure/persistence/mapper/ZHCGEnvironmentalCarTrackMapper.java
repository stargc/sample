package com.ehl.tsq.data.infrastructure.persistence.mapper;

import com.ehl.tsq.data.infrastructure.persistence.po.ZHCGEnvironmentalCarTrack;
import com.ehl.tsq.data.infrastructure.persistence.po.ZHCGEnvironmentalCarTrackExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZHCGEnvironmentalCarTrackMapper {
    int countByExample(ZHCGEnvironmentalCarTrackExample example);

    int deleteByExample(ZHCGEnvironmentalCarTrackExample example);

    int insert(ZHCGEnvironmentalCarTrack record);

    int insertSelective(ZHCGEnvironmentalCarTrack record);

    List<ZHCGEnvironmentalCarTrack> selectByExample(ZHCGEnvironmentalCarTrackExample example);

    int updateByExampleSelective(@Param("record") ZHCGEnvironmentalCarTrack record, @Param("example") ZHCGEnvironmentalCarTrackExample example);

    int updateByExample(@Param("record") ZHCGEnvironmentalCarTrack record, @Param("example") ZHCGEnvironmentalCarTrackExample example);
}
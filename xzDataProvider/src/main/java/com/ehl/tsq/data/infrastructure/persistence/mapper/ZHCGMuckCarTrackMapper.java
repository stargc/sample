package com.ehl.tsq.data.infrastructure.persistence.mapper;

import com.ehl.tsq.data.infrastructure.persistence.po.ZHCGMuckCarTrack;
import com.ehl.tsq.data.infrastructure.persistence.po.ZHCGMuckCarTrackExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZHCGMuckCarTrackMapper {
    int countByExample(ZHCGMuckCarTrackExample example);

    int deleteByExample(ZHCGMuckCarTrackExample example);

    int insert(ZHCGMuckCarTrack record);

    int insertSelective(ZHCGMuckCarTrack record);

    List<ZHCGMuckCarTrack> selectByExample(ZHCGMuckCarTrackExample example);

    int updateByExampleSelective(@Param("record") ZHCGMuckCarTrack record, @Param("example") ZHCGMuckCarTrackExample example);

    int updateByExample(@Param("record") ZHCGMuckCarTrack record, @Param("example") ZHCGMuckCarTrackExample example);
}
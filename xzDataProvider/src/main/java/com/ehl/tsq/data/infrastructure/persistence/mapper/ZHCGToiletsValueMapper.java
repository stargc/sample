package com.ehl.tsq.data.infrastructure.persistence.mapper;

import com.ehl.tsq.data.infrastructure.persistence.po.ZHCGToiletsValue;
import com.ehl.tsq.data.infrastructure.persistence.po.ZHCGToiletsValueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZHCGToiletsValueMapper {
    int countByExample(ZHCGToiletsValueExample example);

    int deleteByExample(ZHCGToiletsValueExample example);

    int insert(ZHCGToiletsValue record);

    int insertSelective(ZHCGToiletsValue record);

    List<ZHCGToiletsValue> selectByExample(ZHCGToiletsValueExample example);

    int updateByExampleSelective(@Param("record") ZHCGToiletsValue record, @Param("example") ZHCGToiletsValueExample example);

    int updateByExample(@Param("record") ZHCGToiletsValue record, @Param("example") ZHCGToiletsValueExample example);
}
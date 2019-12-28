package com.ehl.tsq.data.infrastructure.persistence.mapper;

import com.ehl.tsq.data.infrastructure.persistence.po.ZHCGToilets;
import com.ehl.tsq.data.infrastructure.persistence.po.ZHCGToiletsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZHCGToiletsMapper {
    int countByExample(ZHCGToiletsExample example);

    int deleteByExample(ZHCGToiletsExample example);

    int insert(ZHCGToilets record);

    int insertSelective(ZHCGToilets record);

    List<ZHCGToilets> selectByExample(ZHCGToiletsExample example);

    int updateByExampleSelective(@Param("record") ZHCGToilets record, @Param("example") ZHCGToiletsExample example);

    int updateByExample(@Param("record") ZHCGToilets record, @Param("example") ZHCGToiletsExample example);
}
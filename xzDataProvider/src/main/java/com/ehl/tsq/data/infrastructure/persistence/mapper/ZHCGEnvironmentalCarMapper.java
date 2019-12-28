package com.ehl.tsq.data.infrastructure.persistence.mapper;

import com.ehl.tsq.data.infrastructure.persistence.po.ZHCGEnvironmentalCar;
import com.ehl.tsq.data.infrastructure.persistence.po.ZHCGEnvironmentalCarExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZHCGEnvironmentalCarMapper {
    int countByExample(ZHCGEnvironmentalCarExample example);

    int deleteByExample(ZHCGEnvironmentalCarExample example);

    int insert(ZHCGEnvironmentalCar record);

    int insertSelective(ZHCGEnvironmentalCar record);

    List<ZHCGEnvironmentalCar> selectByExample(ZHCGEnvironmentalCarExample example);

    int updateByExampleSelective(@Param("record") ZHCGEnvironmentalCar record, @Param("example") ZHCGEnvironmentalCarExample example);

    int updateByExample(@Param("record") ZHCGEnvironmentalCar record, @Param("example") ZHCGEnvironmentalCarExample example);
}
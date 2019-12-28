package com.ehl.tsq.data.infrastructure.persistence.mapper;

import com.ehl.tsq.data.infrastructure.persistence.po.ZHCGMuckCar;
import com.ehl.tsq.data.infrastructure.persistence.po.ZHCGMuckCarExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZHCGMuckCarMapper {
    int countByExample(ZHCGMuckCarExample example);

    int deleteByExample(ZHCGMuckCarExample example);

    int insert(ZHCGMuckCar record);

    int insertSelective(ZHCGMuckCar record);

    List<ZHCGMuckCar> selectByExample(ZHCGMuckCarExample example);

    int updateByExampleSelective(@Param("record") ZHCGMuckCar record, @Param("example") ZHCGMuckCarExample example);

    int updateByExample(@Param("record") ZHCGMuckCar record, @Param("example") ZHCGMuckCarExample example);
}
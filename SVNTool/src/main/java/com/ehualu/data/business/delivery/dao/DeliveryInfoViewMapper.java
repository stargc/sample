package com.ehualu.data.business.delivery.dao;

import com.ehualu.data.business.delivery.model.DeliveryInfoView;
import com.ehualu.data.business.delivery.model.DeliveryInfoViewExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeliveryInfoViewMapper {
    int countByExample(DeliveryInfoViewExample example);

    int deleteByExample(DeliveryInfoViewExample example);

    int insert(DeliveryInfoView record);

    int insertSelective(DeliveryInfoView record);

    List<DeliveryInfoView> selectByExample(DeliveryInfoViewExample example);

    int updateByExampleSelective(@Param("record") DeliveryInfoView record, @Param("example") DeliveryInfoViewExample example);

    int updateByExample(@Param("record") DeliveryInfoView record, @Param("example") DeliveryInfoViewExample example);
}
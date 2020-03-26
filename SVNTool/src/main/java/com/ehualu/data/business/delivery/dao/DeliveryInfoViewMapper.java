package com.ehualu.data.business.delivery.dao;

import com.ehualu.data.business.delivery.model.DeliveryInfoView;
import com.ehualu.data.business.delivery.model.DeliveryInfoViewExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeliveryInfoViewMapper {
    int countByExample(DeliveryInfoViewExample example);

    List<DeliveryInfoView> selectByExample(DeliveryInfoViewExample example);

}
package com.ehualu.data.business.delivery.dao;

import com.ehualu.data.business.delivery.model.ProductDeliveryRel;
import com.ehualu.data.business.delivery.model.ProductDeliveryRelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductDeliveryRelMapper {
    int countByExample(ProductDeliveryRelExample example);

    int deleteByExample(ProductDeliveryRelExample example);

    int insert(ProductDeliveryRel record);

    int insertSelective(ProductDeliveryRel record);

    List<ProductDeliveryRel> selectByExample(ProductDeliveryRelExample example);

    int updateByExampleSelective(@Param("record") ProductDeliveryRel record, @Param("example") ProductDeliveryRelExample example);

    int updateByExample(@Param("record") ProductDeliveryRel record, @Param("example") ProductDeliveryRelExample example);
}
package com.ehualu.data.business.delivery.model;

import lombok.Data;

import java.util.List;

/**
 * @author created by guanchen on 2020/3/20 9:51
 */
@Data
public class SearchResp {
    private List<DeliveryInfoView> views;
    private long count;
}

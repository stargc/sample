package com.ehualu.data.business.delivery.model;

import lombok.Data;

/**
 * @author created by guanchen on 2020/3/20 9:30
 */
@Data
public class SearchReq {

    public int userId;
    public int productId;
    public String projectCode;

    public int index;
    public int num;
}

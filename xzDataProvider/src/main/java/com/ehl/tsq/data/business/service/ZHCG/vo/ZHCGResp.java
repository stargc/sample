package com.ehl.tsq.data.business.service.ZHCG.vo;

import lombok.Data;

/**
 * @author created by guanchen on 2019/12/28 11:14
 */
@Data
public class ZHCGResp<T> {
    private String totalCount;
    private T data;
    private String success;
    private String message;
    private String code;
}

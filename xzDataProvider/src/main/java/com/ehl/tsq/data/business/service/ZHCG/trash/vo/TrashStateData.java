package com.ehl.tsq.data.business.service.ZHCG.trash.vo;

import lombok.Data;

/**
 * @author created by guanchen on 2019/12/29 13:33
 */
@Data
public class TrashStateData {
    private int sequence;//排序值
    private int rssi;
    private int distance;
    private int passTime;
    private int battary;
    private int temperature;
    private int full;//满溢值
}

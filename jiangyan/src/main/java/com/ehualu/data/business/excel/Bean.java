package com.ehualu.data.business.excel;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author created by guanchen on 2020/5/19 11:13
 */
@Data
public class Bean {
    private String code;
    private long time;
    private boolean success;
    private List<Map<String,String>> data;
}

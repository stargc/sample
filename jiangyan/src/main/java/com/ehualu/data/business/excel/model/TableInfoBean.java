package com.ehualu.data.business.excel.model;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author created by guanchen on 2020/5/21 11:23
 */
@Data
public class TableInfoBean {
    private String resourceTableCode;
    private String resourceCode;
    private String resourceTableName;
    private String tablePhysicalName;
    private String resourceName;
    private long curCount;
    private List<ColumnBean> itemList;

    private List<Map<String,String>> sampleData;

}

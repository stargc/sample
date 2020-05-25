package com.ehualu.data.business.excel.model;

import lombok.Data;

/**
 * @author created by guanchen on 2020/5/21 11:16
 */
@Data
public class ColumnBean {

    private String columnRemark;
    private String remark;
    private String resourceItemName;
    private String dataItemType;
    private int length;
    private String dataMetaName;
    private String dataMetaFlagCode;

    private String dictTableName;

}

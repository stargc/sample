package com.ehualu.data.business.excel.test;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author created by guanchen on 2020/5/21 17:09
 */
@Data
@ToString
public class TestParam {
    private String tableCode;
    private String num;
    private List<Entity> list;
}

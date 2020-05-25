package com.ehualu.data.business.excel.test;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.Data;

import java.beans.ConstructorProperties;

/**
 * @author created by guanchen on 2020/5/22 12:50
 */
@Data
public class bean {
    public bean(String name) {
        this.name = name;
    }
    private String name;
}

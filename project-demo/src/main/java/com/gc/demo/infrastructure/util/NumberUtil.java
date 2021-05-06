package com.gc.demo.infrastructure.util;

import java.util.Random;

/**
 * @author created by guanchen on 2021/5/6 15:36
 */
public class NumberUtil {

    /***
     * 随机生成 N 位数字
     * @return
     */
    public static String getRandomNickname(int length) {
        String val = "";
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            val += String.valueOf(random.nextInt(10));
        }
        return val;
    }
}

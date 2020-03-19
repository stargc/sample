package com.ehualu.data.common.filter;

/**
 * @author created by guanchen on 2020/3/18 16:46
 */
public class RequestHolder {
    private final static ThreadLocal<Integer> userIdHolder = new ThreadLocal<>();

    public static void setUserId(Integer userName) {
        userIdHolder.set(userName);
    }

    public static Integer getUserId() {
        return userIdHolder.get();
    }

    public static void remove() {
        userIdHolder.remove();
    }
}

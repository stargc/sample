package com.gc.demo.infrastructure.exception;

/**
 * @author created by guanchen on 2020/5/6 11:20
 *
 * 用于手动校验接口入参，当入参错误时抛出该异常
 */
public class LogicErrorException extends RuntimeException {
    public LogicErrorException(String msg) {
        super(msg);
    }
}

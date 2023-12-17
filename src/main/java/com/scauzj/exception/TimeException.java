package com.scauzj.exception;

/**
 * 时间类异常处理
 */
public class TimeException extends RuntimeException {
    public TimeException() { }

    public TimeException(String msg) {
        super(msg);
    }
}

package com.scauzj.exception;

/**
 * 处理图书相关异常
 * 包括：图书不存在、图书已存在
 */
public class BookException extends BaseException {
    public BookException() {
    }

    public BookException(String msg) {
        super(msg);
    }
}

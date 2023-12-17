package com.scauzj.exception;

/**
 * 处理借阅相关的异常
 * 包括：借阅数量超过限制、借阅的图书不存在、未归还
 */
public class BorrowException extends BaseException {
    public BorrowException() {
    }

    public BorrowException(String msg) {
        super(msg);
    }
}

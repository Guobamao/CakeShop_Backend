package com.scauzj.exception;

/**
 * 处理账号相关的异常
 * 包括：账号不存在、账号已存在、账号或密码错误
 */
public class AccountException extends BaseException {
    public AccountException() { }

    public AccountException(String msg) {
        super(msg);
    }
}

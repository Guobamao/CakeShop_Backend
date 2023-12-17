package com.scauzj.exception;

/**
 * 处理权限相关异常
 */
public class PermissionException extends BaseException {
    public PermissionException() { }

    public PermissionException(String msg) {
        super(msg);
    }
}

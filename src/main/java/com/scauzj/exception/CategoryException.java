package com.scauzj.exception;

/**
 * 处理图书分类相关异常
 */
public class CategoryException extends RuntimeException {
    public CategoryException() { }

    public CategoryException(String msg) {
        super(msg);
    }
}

package com.scauzj.exception;

/**
 * 借书卡异常处理
 */
public class CardException extends RuntimeException {
    public CardException() { }

    public CardException(String msg) {
        super(msg);
    }
}

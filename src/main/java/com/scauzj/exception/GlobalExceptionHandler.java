package com.scauzj.exception;

import com.scauzj.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 */

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    // 处理所有异常
    @ExceptionHandler(Exception.class)
    public Result exceptionHandler(Exception ex) {
        log.info("异常信息：{}", ex.getMessage());
        return Result.error(ex.getMessage());
    }
}

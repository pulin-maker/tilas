package com.nanjiabawa.utils;

import com.nanjiabawa.pojo.Result;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public Result handleException(Exception e) {
        e.printStackTrace();
        return Result.error("对不起！系统错误，请联系管理员~");
    }
}

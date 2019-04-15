package com.tensquare.base.controller;

import entity.Result;
import entity.StatusCode;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * ClassName: BaseExceptionHandler
 *
 * @Author: Light
 * @Date: 2019/4/15 14:59
 * Description:
 */
@RestControllerAdvice
public class BaseExceptionHandler {
    @ExceptionHandler(value = Exception.class)

    public Result error(Exception e){
        e.printStackTrace();
        return   new Result(false, StatusCode.ERROR,e.getMessage());
    }
}
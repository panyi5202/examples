package com.roy.springboot.demo1.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Roy
 */
@ControllerAdvice // 拦截所有@RequestMapping
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Object deaultExceptionHandler(HttpServletRequest req, HttpServletResponse resp, Exception e) {
        return "process Excepiton" + e.getMessage();
    }
}

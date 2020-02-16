package com.example.mq.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author panyi on 2019/8/16.
 */
@RestController
@Slf4j
public class DemoCtl {
    @Resource
    private Processor processor;
    @GetMapping(value = {"/", "/index"})
    public String index(HttpServletRequest request) throws InterruptedException {
        log.info("DemoCtl");
        String s = processor.procReq(request);
        return s;
    }
}

package com.example.mq.controller;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author panyi on 2019/8/16.
 */
@Component
public class Processor {
    private LinkedBlockingQueue queue = new LinkedBlockingQueue();

    public String procReq(HttpServletRequest request) {
        return "123";
    }
}

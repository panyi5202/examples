package com.roy.springboot.demo1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Roy
 */
@RestController
public class Demo1Controller {
    @RequestMapping("info")
    public String info(){
        return "1234444566";
    }
}

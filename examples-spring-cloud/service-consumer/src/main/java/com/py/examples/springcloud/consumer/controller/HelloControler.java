package com.py.examples.springcloud.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author panyi on 18-4-23.
 */
@RestController
public class HelloControler {
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/hello")
    public String hi(@RequestParam String name) {
        return restTemplate.getForObject("http://SERVICE-PROVIDER/hi?name=" + name, String.class);
    }
}

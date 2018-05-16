package com.py.examples.springcloud.consumer.controller;

import com.py.examples.springcloud.consumer.feign.ServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author panyi on 18-4-23.
 */
@RestController
public class HelloControler {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    ServiceHi serviceHi;

    @RequestMapping(value = "/hello")
    public String hi(@RequestParam String name) {
        return restTemplate.getForObject("http://SERVICE-PROVIDER/hi?name=" + name, String.class);
    }

    @RequestMapping(value = "/hello2")
    public String hi2(@RequestParam String name) {
        List<String> list = new ArrayList<>();
        list.stream().forEach(l -> System.out.println(l));
        return serviceHi.hiFromClient(name);
    }
}

package com.py.provider.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Random;

/**
 * @author Roy
 */
@RestController
@RequestMapping("product")
public class ProductController {
    @Resource
    private DiscoveryClient client; // 进行Eureka的发现服务

    @RequestMapping("detail/{str}")
    @HystrixCommand(fallbackMethod = "detailFallback")
    public String detail(@PathVariable String str) {
        int i = new Random().nextInt(100);
        System.out.println("=================> " + i);
        if (i > 5) {
            throw new RuntimeException("product exception");
        }
        return "product:" + str;
    }

    public String detailFallback(@PathVariable String str) {
        return "product fallback:" + str;
    }

    @RequestMapping("/discover")
    public Object discover() { // 直接返回发现服务信息
        return this.client;
    }

}

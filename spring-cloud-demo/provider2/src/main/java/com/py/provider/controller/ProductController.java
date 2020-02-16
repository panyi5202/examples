package com.py.provider.controller;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Roy
 */
@RestController
@RequestMapping("product")
public class ProductController {
    @Resource
    private DiscoveryClient client ; // 进行Eureka的发现服务

    @RequestMapping("detail/{str}")
    public String detail(@PathVariable String str){
        return "product2:"+str;
    }

    @RequestMapping("/discover")
    public Object discover() { // 直接返回发现服务信息
        return this.client ;
    }

}

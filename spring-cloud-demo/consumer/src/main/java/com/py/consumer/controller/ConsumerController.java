package com.py.consumer.controller;

import com.py.consumer.rpc.service.FeignProviderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Roy
 */
@RestController
@RequestMapping("consumer")
public class ConsumerController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private FeignProviderClient feignProviderClient;

    @RequestMapping("prod/detail/{str}")
    public String consume(@PathVariable String str) {
        String resut = restTemplate.getForObject("http://PROVIDER/product/detail/" + str, String.class);
        return resut;
    }
    @RequestMapping("prod/detail2/{str}")
    public String consume2(@PathVariable String str) {
        String resut = feignProviderClient.detail(str);
        return resut;
    }
}

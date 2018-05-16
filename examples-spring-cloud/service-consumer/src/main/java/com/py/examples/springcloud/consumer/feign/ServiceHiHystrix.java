package com.py.examples.springcloud.consumer.feign;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author panyi on 18-4-24.
 */
@Component
public class ServiceHiHystrix implements ServiceHi{
    @Override
    public String hiFromClient(@RequestParam(value = "name") String name) {
        return "hystrix断路器返回";
    }
}

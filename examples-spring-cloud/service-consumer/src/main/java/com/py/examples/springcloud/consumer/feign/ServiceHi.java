package com.py.examples.springcloud.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author panyi on 18-4-23.
 */
@FeignClient(value = "service-provider")
public interface ServiceHi {
    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    String hiFromClient(@RequestParam(value = "name") String name);
}

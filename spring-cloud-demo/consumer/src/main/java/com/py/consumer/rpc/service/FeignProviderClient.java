package com.py.consumer.rpc.service;

import com.py.consumer.rpc.service.fallback.FeignProviderClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Roy
 */
@FeignClient(name = "provider",fallbackFactory = FeignProviderClientFallbackFactory.class)
public interface FeignProviderClient {
    @RequestMapping("product/detail/{str}")
    public String detail(@PathVariable String str);
}

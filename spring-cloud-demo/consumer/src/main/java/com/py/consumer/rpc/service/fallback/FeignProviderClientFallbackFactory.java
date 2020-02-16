package com.py.consumer.rpc.service.fallback;

import com.py.consumer.rpc.service.FeignProviderClient;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author Roy
 */
@Component
public class FeignProviderClientFallbackFactory implements FallbackFactory<FeignProviderClient> {
    @Override
    public FeignProviderClient create(Throwable throwable) {
        return new FeignProviderClient() {
            @Override
            public String detail(String str) {
                return "consumer fallback:" + str;
            }
        };
    }
}

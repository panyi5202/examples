package com.py.consumer.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Roy
 */
@Configuration
public class FeignClientConfig {
    @Bean
    public Logger.Level getFeignLoggerLevel() {
        return feign.Logger.Level.FULL ;
    }

}

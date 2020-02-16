package com.py.zuul.config;

import com.py.zuul.filter.LogFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Roy
 */
@Configuration
public class ZuulConfig {
    @Bean
    public LogFilter getLogFilter(){
        return new LogFilter();
    }
}

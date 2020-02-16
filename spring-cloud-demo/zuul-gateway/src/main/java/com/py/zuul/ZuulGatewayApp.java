package com.py.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author Roy
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulGatewayApp {
    public static void main(String[] args) {
        SpringApplication.run(ZuulGatewayApp.class, args);
    }
}

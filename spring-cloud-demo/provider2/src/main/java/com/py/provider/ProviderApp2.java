package com.py.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Roy
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class ProviderApp2 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderApp2.class,args);
    }
}

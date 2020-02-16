package com.py.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.client.ConfigClientAutoConfiguration;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author Roy
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigApp {
    public static void main(String[] args) {
        SpringApplication.run(ConfigApp.class, args);
    }
}

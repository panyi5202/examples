package com.py.sleuth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin2.server.internal.EnableZipkinServer;


/**
 * @author Roy
 */
@SpringBootApplication
@EnableZipkinServer
public class SleuthApp {
    public static void main(String[] args) {
        SpringApplication.run(SleuthApp.class, args);
    }
}

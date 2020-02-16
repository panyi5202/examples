package com.example.mq;

/**
 * @author ypan
 * @date 2019.3.22
 *
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = "com.example.mq")
@EnableScheduling
@EnableConfigurationProperties
public class MqApplication {

	public static void main(String[] args) {
		SpringApplication.run(MqApplication.class, args);
	}

}

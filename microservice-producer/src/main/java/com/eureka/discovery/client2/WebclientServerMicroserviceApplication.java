package com.eureka.discovery.client2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
public class WebclientServerMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebclientServerMicroserviceApplication.class, args);
	}
	
}

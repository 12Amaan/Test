package com.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringbootKeycloakApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootKeycloakApplication.class, args);
	}

}

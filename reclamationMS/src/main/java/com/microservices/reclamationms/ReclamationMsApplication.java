package com.microservices.reclamationms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ReclamationMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReclamationMsApplication.class, args);
	}

}

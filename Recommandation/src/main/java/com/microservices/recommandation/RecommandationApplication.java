package com.microservices.recommandation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class RecommandationApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecommandationApplication.class, args);
    }

}

package com.brayden.beetleserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BeetleServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeetleServerApplication.class, args);
    }

}

package com.demo.gateway.service;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: wch
 * @Description:
 * @Date: 2020/6/6 11:52 PM
 */

@SpringBootApplication(scanBasePackages = "com.demo.gateway")
@EnableEurekaClient
public class GateWayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GateWayApplication.class, args);
    }

}

package com.example.customerprovider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = "com.example.customerprovider.Mapper")
public class CustomerProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerProviderApplication.class, args);
    }

}

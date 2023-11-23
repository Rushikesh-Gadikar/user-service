package com.project.study.userService;

import feign.Retryer;
import org.apache.tomcat.util.log.SystemLogHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class UserServiceApplication {

    @Bean
    @LoadBalanced
    public RestTemplate createRestTemplateBean(){
        return new RestTemplate();
    }

    @Bean
    public Retryer feignRetryer() {
        return new Retryer.Default(100, 1000, 4); // Example configuration with 4 retries
    }

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

}

package com.chm.toodles.substitution;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;


/**
 * 服务提供者
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
@EnableFeignClients(basePackages = {"com.chm.toodles.api.client"})
@ComponentScan(basePackages = "com.chm.toodles")
public class SubstitutionServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(SubstitutionServiceApplication.class, args);
  }

}

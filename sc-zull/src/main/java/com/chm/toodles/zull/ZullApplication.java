package com.chm.toodles.zull;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


/**
 * API gateway
 */

@SpringBootApplication
@EnableZuulProxy
public class ZullApplication {

  public static void main(String[] args) {
    SpringApplication.run(ZullApplication.class, args);
  }

}

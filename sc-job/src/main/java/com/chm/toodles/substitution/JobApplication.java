package com.chm.toodles.substitution;

import java.util.concurrent.CountDownLatch;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ImportResource;


/**
 * 服务提供者
 */
@SpringBootApplication
@ImportResource(locations = {"classpath:spring/applicationContext.xml"})
public class JobApplication {

  public static void main(String[] args) {
    new SpringApplicationBuilder().sources(JobApplication.class).web(WebApplicationType.NONE)
        .run(args);
    try {
      new CountDownLatch(1).await();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

package com.chm.toodles.api.client.config;

import feign.Logger;
import feign.Logger.Level;
import feign.Request;
import feign.Request.Options;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfiguration {

  //设置feign的日志级别
  @Bean
  Logger.Level feignLoggerLevel() {
    return Level.FULL;
  }

  //设置Basic认证方式
  @Bean
  public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
    return new BasicAuthRequestInterceptor("user", "password");
  }

  //超时时间配置
  @Bean
  public Request.Options options() {
    return new Options(5 * 1000, 10 * 1000);
  }
}

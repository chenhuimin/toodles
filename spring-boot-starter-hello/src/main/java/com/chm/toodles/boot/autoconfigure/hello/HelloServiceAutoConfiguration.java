package com.chm.toodles.boot.autoconfigure.hello;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(HelloServiceProperties.class)
@ConditionalOnClass(HelloService.class)
@ConditionalOnProperty(prefix = "hello", value = "enabled", matchIfMissing = true)
public class HelloServiceAutoConfiguration {

  private final HelloServiceProperties properties;

  public HelloServiceAutoConfiguration(HelloServiceProperties properties) {
    this.properties = properties;
  }


  @Bean
  @ConditionalOnMissingBean
  public HelloService helloService() {
    HelloService helloService = new HelloService();
    helloService.setMsg(this.properties.getMsg());
    return helloService;
  }

}

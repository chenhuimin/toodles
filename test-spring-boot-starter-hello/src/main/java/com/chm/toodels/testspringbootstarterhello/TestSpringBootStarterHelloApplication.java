package com.chm.toodels.testspringbootstarterhello;

import com.chm.toodles.boot.autoconfigure.hello.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class TestSpringBootStarterHelloApplication {

  @Autowired
  private HelloService helloService;

  @GetMapping("/hello")
  public String hello() {
    return helloService.sayHello();
  }

  public static void main(String[] args) {
    SpringApplication.run(TestSpringBootStarterHelloApplication.class, args);
  }
}

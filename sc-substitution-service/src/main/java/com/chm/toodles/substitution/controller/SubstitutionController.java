package com.chm.toodles.substitution.controller;

import com.chm.toodles.api.client.provider.HouseRemoteClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@RequestMapping("/substitution")
public class SubstitutionController {

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private HouseRemoteClient houseRemoteClient;

  @Autowired
  private LoadBalancerClient loadBalancerClient;

  @GetMapping("/choose")
  public Object chooseUrl() {
    ServiceInstance instance = loadBalancerClient.choose("sc-provider");
    return instance;
  }

  @GetMapping("/callHello")
//  @HystrixCommand(fallbackMethod = "defaultCallHello", commandProperties = {
//      @HystrixProperty(name = "execution.isolation.thread.interruptOnTimeout", value = "false")})
  public String callHello() throws InterruptedException {
    log.info("invoke callHello...");
    //String result = restTemplate.getForObject("http://sc-provider/house/hello", String.class);
    String result = houseRemoteClient.hello();
    log.info("调用结果={}", result);
    return result;
  }

  public String defaultCallHello() {
    return "fail";
  }

}

package com.chm.toodles.provider.controller;

import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/house")
public class HouseController {

  @Autowired
  private HttpServletRequest request;

  @GetMapping("/hello")
  public String hello() throws InterruptedException {
    int serverPort = request.getServerPort();
    String serverName = request.getServerName();
    log.info("host={},port={}", serverName, serverPort);
    return serverName + ":" + serverPort + ":" + "Hello";
  }

}

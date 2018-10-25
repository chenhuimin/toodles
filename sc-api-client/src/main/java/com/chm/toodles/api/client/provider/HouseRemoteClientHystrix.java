package com.chm.toodles.api.client.provider;

import org.springframework.stereotype.Component;

@Component
public class HouseRemoteClientHystrix implements HouseRemoteClient {

  @Override
  public String hello() {
    return null;
  }
}

package com.chm.toodles.api.client.provider;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class HouseRemoteClientFallbackFactory implements FallbackFactory<HouseRemoteClient> {

  @Override
  public HouseRemoteClient create(Throwable throwable) {
    return new HouseRemoteClient() {
      @Override
      public String hello() {
        return throwable.getMessage();
      }
    };
  }
}

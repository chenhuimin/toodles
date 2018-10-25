package com.chm.toodles.api.client.provider;


import com.chm.toodles.api.client.config.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 房生活房产服务API调用客户端
 *
 * @author yinjihuan
 * @create 2017-10-27 13:55
 **/

@FeignClient(value = "sc-provider", path = "/house", configuration = FeignConfiguration.class, fallbackFactory = HouseRemoteClientFallbackFactory.class)
public interface HouseRemoteClient {

  @GetMapping("/hello")
  String hello();

}

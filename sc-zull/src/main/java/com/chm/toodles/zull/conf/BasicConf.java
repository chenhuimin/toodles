package com.chm.toodles.zull.conf;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class BasicConf {

  @Value("192.168.199.214")
  private String ipStr = "default";

}

package com.chm.toodles.lab.groovy.client;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderSpecFilteredDTO implements Serializable {

  private static final long serialVersionUID = -2213378317220036463L;
  private List<OrderSpec> targetOrderSpecs;
  private Map<String, Object> extraAttributes;

}

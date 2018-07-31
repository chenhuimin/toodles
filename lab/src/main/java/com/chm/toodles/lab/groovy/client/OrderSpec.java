package com.chm.toodles.lab.groovy.client;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderSpec implements Comparable<OrderSpec>, Serializable {

  private static final long serialVersionUID = 7625355352299458816L;

  private String specCode;
  private String specName;
  private String specValue;
  private Integer order;


  @Override
  public int compareTo(OrderSpec o) {
    return this.order - o.order;
  }
}

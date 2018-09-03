package com.chm.toodles.effectivejava.builder.hierarchical;

import java.util.Objects;

public class NyPizza extends Pizza {

  public enum Size {
    SMALL, MDDIUM, LARGE;
  }

  private final Size size;

  public static class Builder extends Pizza.AbstractBuilder<Builder> {

    private final Size size;

    public Builder(Size size) {
      this.size = Objects.requireNonNull(size);
    }

    @Override
    Builder self() {
      return this;
    }

    @Override
    public NyPizza build() {
      return new NyPizza(this);
    }
  }

  private NyPizza(Builder builder) {
    super(builder);
    size = builder.size;
  }

  @Override
  public String toString() {
    return "NyPizza{" +
        "size=" + size +
        ", toppings=" + toppings +
        '}';
  }
}

package com.chm.toodles.effectivejava.builder.hierarchical;

public class Calzone extends Pizza {

  private final boolean sauceInside;

  public static class Builder extends Pizza.AbstractBuilder<Builder> {

    private boolean sauceInside = false;

    public Builder sauceInside() {
      sauceInside = true;
      return this;
    }

    @Override
    Builder self() {
      return this;
    }

    @Override
    protected Calzone build() {
      return new Calzone(this);
    }
  }

  private Calzone(Builder builder) {
    super(builder);
    sauceInside = builder.sauceInside;
  }

  @Override
  public String toString() {
    return "Calzone{" +
        "sauceInside=" + sauceInside +
        ", toppings=" + toppings +
        '}';
  }
}

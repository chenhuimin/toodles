package com.chm.toodles.effectivejava.builder.hierarchical;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public abstract class Pizza {

  public enum Topping {
    HAM, MUSHROOM, ONION, PEPPER, SAUSAGE
  }

  protected final Set<Topping> toppings;

  abstract static class AbstractBuilder<T extends AbstractBuilder<T>> {

    EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

    public T addTopping(Topping topping) {
      toppings.add(Objects.requireNonNull(topping));
      return self();
    }

    abstract T self();

    protected abstract Pizza build();
  }

  Pizza(AbstractBuilder<?> builder) {
    toppings = builder.toppings.clone();
  }

}

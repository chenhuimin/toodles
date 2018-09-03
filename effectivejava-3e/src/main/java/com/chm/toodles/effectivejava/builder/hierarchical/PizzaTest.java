package com.chm.toodles.effectivejava.builder.hierarchical;

import com.chm.toodles.effectivejava.builder.hierarchical.NyPizza.Size;
import com.chm.toodles.effectivejava.builder.hierarchical.Pizza.Topping;

public class PizzaTest {

  public static void main(String[] args) {

    NyPizza nyPizza = new NyPizza.Builder(Size.SMALL).addTopping(Topping.SAUSAGE)
        .addTopping(Topping.ONION).build();
    Calzone calzone = new Calzone.Builder().sauceInside().addTopping(Topping.HAM).build();
    System.out.println(nyPizza);
    System.out.println(calzone);
  }


}

package com.chm.toodles.effectivejava.noninstantiability;

public class UtilityClass {

  private UtilityClass() {
    throw new AssertionError("No UtilityClass instances for you!");
  }

  public static void main(String[] args) {
    UtilityClass utilityClass = new UtilityClass();

  }

}

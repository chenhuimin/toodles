package com.chm.toodles.effectivejava.builder.manual;

public class NutritionFacts {

  private int servingSize;
  private int servings;
  private int calories;
  private int fat;
  private int sodium;
  private int carbohydrate;

  public static class Builder {

    private int servingSize;
    private int servings;
    private int calories;
    private int fat;
    private int sodium;
    private int carbohydrate;

    public Builder(int servingSize, int servings) {
      this.servingSize = servingSize;
      this.servings = servings;
    }

    public Builder calories(int calories) {
      this.calories = calories;
      return this;
    }

    public Builder fat(int fat) {
      this.fat = fat;
      return this;
    }

    public Builder sodium(int sodium) {
      this.sodium = sodium;
      return this;
    }

    public Builder carbohydrate(int carbohydrate) {
      this.carbohydrate = carbohydrate;
      return this;
    }

    public NutritionFacts build() {
      return new NutritionFacts(this);
    }

  }

  private NutritionFacts(Builder builder) {
    this.servingSize = builder.servingSize;
    this.servings = builder.servings;
    this.calories = builder.calories;
    this.fat = builder.fat;
    this.sodium = builder.sodium;
    this.carbohydrate = builder.carbohydrate;
  }

}

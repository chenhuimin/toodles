package com.chm.toodles.effectivejava.builder.lombok;

import lombok.Builder;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Builder(toBuilder = true)
@ToString
public class NutritionFacts {

  private int servingSize;
  private int servings;
  private int calories;
  private int fat;
  private int sodium;
  private int carbohydrate;

  public static void main(String[] args) {
    NutritionFacts nutritionFacts = NutritionFacts.builder()
        .servingSize(240).servings(8).calories(100).sodium(35).carbohydrate(28).build();
    log.info("nutritionFacts={}", nutritionFacts, nutritionFacts);
    NutritionFacts nutritionFacts2 = nutritionFacts.toBuilder().calories(50).fat(50).build();
    log.info("nutritionFacts2={}", nutritionFacts2);
    log.info("nutritionFacts==nutritionFacts2 is {}", nutritionFacts == nutritionFacts2);
  }

}


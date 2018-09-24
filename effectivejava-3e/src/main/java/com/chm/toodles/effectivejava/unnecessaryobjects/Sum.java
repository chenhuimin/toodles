package com.chm.toodles.effectivejava.unnecessaryobjects;

import java.util.HashSet;
import java.util.Set;

public class Sum {

  private static long sum() {
    Long sum = 0L;
    for (long i = 0; i <= Integer.MAX_VALUE; i++) {
      sum += i;
    }
    return sum;
  }

  static int numElementsInCommon(Set<?> s1, Set<?> s2) {
    int result = 0;
    for (Object o1 : s1) {
      if (s2.contains(o1)) {
        result++;
      }
    }
    return result;
  }

  public static void main(String[] args) {
//    int numSets = 1000;
//    long x = 0;
//    for (int i = 0; i < numSets; i++) {
//      long start = System.nanoTime();
//      x += sum();
//      long end = System.nanoTime();
//      System.out.println((end - start) / 1_000_000. + " ms.");
//    }
//    if (x == 42) {
//      System.out.println();
//    }
    Set<String> s1 = new HashSet<>();
    s1.add("test");
    s1.add("test1");
    Set<Integer> s2 = new HashSet<>();
    s2.add(1);
    s2.add(2);
    System.out.println(Sum.numElementsInCommon(s1, s2));
  }

}

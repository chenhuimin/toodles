package com.chm.toodles.effectivejava.comparable;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.ThreadLocalRandom;

public class PhoneNumber implements Cloneable, Comparable<PhoneNumber> {

  private final int areaCode, prefix, lineNum;

  public PhoneNumber(int areaCode, int prefix, int lineNum) {
    this.areaCode = areaCode;
    this.prefix = prefix;
    this.lineNum = lineNum;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PhoneNumber that = (PhoneNumber) o;
    return areaCode == that.areaCode &&
        prefix == that.prefix &&
        lineNum == that.lineNum;
  }

  @Override
  public int hashCode() {
    return Objects.hash(areaCode, prefix, lineNum);
  }

  @Override
  public String toString() {
    return "PhoneNumber{" +
        "areaCode=" + areaCode +
        ", prefix=" + prefix +
        ", lineNum=" + lineNum +
        '}';
  }

  @Override
  public PhoneNumber clone() {
    try {
      return (PhoneNumber) super.clone();
    } catch (CloneNotSupportedException e) {
      throw new AssertionError();
    }
  }

  private static final Comparator<PhoneNumber> COMPARATOR = Comparator
      .comparingInt((PhoneNumber pn) -> pn.areaCode).thenComparingLong(pn -> pn.prefix)
      .thenComparingInt(pn -> pn.lineNum);

  @Override
  public int compareTo(PhoneNumber pn) {
    return COMPARATOR.compare(this, pn);
  }

  private static PhoneNumber randomPhoneNumber() {
    Random rnd = ThreadLocalRandom.current();
    return new PhoneNumber(rnd.nextInt(1000),
        rnd.nextInt(1000),
        rnd.nextInt(10000));

  }


  public static void main(String[] args) {
    NavigableSet<PhoneNumber> s = new TreeSet<>();
    for (int i = 0; i < 10; i++) {
      s.add(randomPhoneNumber());
    }
    System.out.println(s);
  }

}

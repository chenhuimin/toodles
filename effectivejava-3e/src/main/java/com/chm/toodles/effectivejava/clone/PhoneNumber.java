package com.chm.toodles.effectivejava.clone;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PhoneNumber implements Cloneable {

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

  public static void main(String[] args) {
    PhoneNumber pn = new PhoneNumber(707, 867, 5309);
    Map<PhoneNumber, String> m = new HashMap<>();
    m.put(pn, "Jerry");
    System.out.println(pn.clone());
  }
}

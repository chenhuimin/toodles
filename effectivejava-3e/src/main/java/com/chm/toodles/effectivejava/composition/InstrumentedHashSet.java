package com.chm.toodles.effectivejava.composition;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class InstrumentedHashSet<E> extends HashSet<E> {

  private int addCount;

  public InstrumentedHashSet() {

  }

  public InstrumentedHashSet(int initCap, float loadFactor) {
    super(initCap, loadFactor);
  }

  @Override
  public boolean add(E e) {
    addCount++;
    return super.add(e);
  }

  @Override
  public boolean addAll(Collection<? extends E> c) {
    addCount += c.size();
    return super.addAll(c);
  }

  public int getAddCount() {
    return addCount;
  }

  public static void main(String[] args) {
    InstrumentedHashSet<String> s = new InstrumentedHashSet<>();
    s.addAll(Arrays.asList("Snap", "Crackle", "Pop"));
    System.out.println(s.getAddCount());
  }
}

package com.chm.toodles.effectivejava.singleton.enumtype;

public enum Elvis {
  /**
   * 单例
   */
  INSTANCE;

  public void leaveTheBuilding() {
    System.out.println("Whoa baby! I'm outta here");
  }

  public static void main(String[] args) {
    Elvis elvis = Elvis.INSTANCE;
    elvis.leaveTheBuilding();
  }
}

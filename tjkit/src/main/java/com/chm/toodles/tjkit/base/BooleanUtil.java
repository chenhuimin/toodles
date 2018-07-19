package com.chm.toodles.tjkit.base;

public class BooleanUtil {

  /**
   *使用标准JDK，将字符串参数解析为布尔值。如果字符串参数不是{@code null} 并且忽略大小写等于字符串值{@code "true"}
   * @param s
   * @return
   */
  public static boolean toBoolean(String s) {
    return Boolean.parseBoolean(s);
  }

}

package com.chm.toodles.lab.groovy.common;

import groovy.lang.GroovyClassLoader;

/**
 * GroovyClassLoader单例对象，通过枚举方式实现
 *
 * @author chenhuimin66@gmail.com
 */

public enum GroovyClassLoaderEnum {
  /**
   * GroovyClassLoader实例对象
   */
  INSTANCE;

  private final GroovyClassLoader groovyClassLoader;

  GroovyClassLoaderEnum() {
    groovyClassLoader = new GroovyClassLoader();
  }

  public GroovyClassLoader getGroovyClassLoader() {
    return groovyClassLoader;
  }
}

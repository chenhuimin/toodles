package com.chm.toodles.lab.groovy.common;

import java.util.Map;
import org.codehaus.groovy.runtime.memoize.ConcurrentCommonCache;

public class GroovyUtils {
  Map<String, Class> sourceCache = new ConcurrentCommonCache<String, Class>();

}

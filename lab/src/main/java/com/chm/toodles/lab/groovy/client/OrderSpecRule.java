package com.chm.toodles.lab.groovy.client;

import com.chm.toodles.lab.groovy.common.GroovyClassLoaderEnum;
import groovy.lang.Binding;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import groovy.lang.Script;
import groovy.util.GroovyScriptEngine;
import groovy.util.ResourceException;
import groovy.util.ScriptException;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import org.apache.commons.codec.digest.DigestUtils;
import org.codehaus.groovy.runtime.memoize.ConcurrentCommonCache;

public class OrderSpecRule {

  private static volatile Map<String, Class> classCache = new ConcurrentCommonCache<String, Class>();


  public void runGroovyScriptByFile(String[] filepath, String filename, String funname,
      Object[] params) {

    if (filepath == null || filepath.length == 0) {
      filepath = new String[]{"grovvy\\"};// 定义Groovy脚本引擎的根路径
    }
    try {
      // String[]{".\\src\\main\\java\\com\\senyint\\util\\"}
      GroovyScriptEngine engine = new GroovyScriptEngine(filepath);
      Script script = engine.createScript(filename, new Binding());
      while (true) {
        System.out.println(script.invokeMethod(funname, params));
      }
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();

    }
  }

  public static Class genClass(String scriptText) {
    String scriptTextMd5 = DigestUtils.md5Hex(scriptText);
    Class clazz = classCache.get(scriptTextMd5);
    if (clazz != null) {
      return clazz;
    }
    synchronized (OrderSpecRule.class) {
      clazz = classCache.get(scriptTextMd5);
      if (clazz == null) {
        GroovyClassLoader loader = GroovyClassLoaderEnum.INSTANCE.getGroovyClassLoader();
        clazz = loader.parseClass(scriptText);
        if (clazz != null) {
          classCache.put(scriptTextMd5, clazz);
        }
      }
    }
    return clazz;
  }

  public static void main(String[] args)
      throws IOException, ResourceException, ScriptException, IllegalAccessException, InstantiationException {

    String scriptText = "class OrderSpecHandler { void doIt() { println \"ok\" } }";
    File file = new File("script/OrderSpecHandler.groovy");
    while (true) {
      Class clazz = genClass(scriptText);
      if (clazz != null) {
        GroovyObject groovyObject = (GroovyObject) clazz.newInstance();
        groovyObject.invokeMethod("doIt", null);
      }
    }
//    ReferenceQueue<String> queue = new ReferenceQueue<String>();
//    PhantomReference<String> pr = new PhantomReference<String>(new String("hello"), queue);
//    System.out.println(pr.get());

//    GroovyClassLoader loader = new GroovyClassLoader();
//    System.out.println(loader.getClass().getName());
//    System.out.println(loader.getParent().getClass().getName());
//    ClassLoader cl = ClassLoader.getSystemClassLoader();
//    System.out.println(cl.getClass().getName());
//    OrderSpecRule groovy = new OrderSpecRule();
//
//    String filename = "hello.groovy";
//    String[] roots = new String[]{"script"};
//
//    groovy
//        .runGroovyScriptByFile(roots, filename, "hello", new String[]{"param3", "param4"});

  }

}

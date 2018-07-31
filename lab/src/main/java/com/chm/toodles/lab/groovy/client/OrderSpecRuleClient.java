package com.chm.toodles.lab.groovy.client;

import com.chm.toodles.lab.groovy.common.GroovyClassLoaderEnum;
import com.google.common.io.Resources;
import groovy.lang.Binding;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import groovy.lang.Script;
import groovy.util.GroovyScriptEngine;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.codehaus.groovy.runtime.memoize.ConcurrentCommonCache;

@Slf4j
public class OrderSpecRuleClient {

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

  /**
   * 处理以字符串输入脚本
   */
  public static Class genClassByString(String scriptText) {
    String scriptTextMd5 = DigestUtils.md5Hex(scriptText);
    Class clazz = classCache.get(scriptTextMd5);
    if (clazz != null) {
      return clazz;
    }
    synchronized (OrderSpecRuleClient.class) {
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

  public static Class genClassByFile(String resourceName) {
    URL fileURL = Resources.getResource(resourceName);
    try {
      File file = new File(fileURL.toURI());
      GroovyClassLoader loader = GroovyClassLoaderEnum.INSTANCE.getGroovyClassLoader();
      return loader.parseClass(file);
    } catch (URISyntaxException e) {
      e.printStackTrace();
      return null;
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }

  public static void main(String[] args) throws IllegalAccessException, InstantiationException {
    String resourceName = "script/OrderSpecHandler.groovy";
    Class clazz = genClassByFile(resourceName);
    String businessCatId = "1501";
    String businessStatus = "5";

    List<OrderSpec> orderSpecs = Arrays
        .asList(new OrderSpec(null, "入口时间", "2018.08.01 00:13", null),
            new OrderSpec(null, "出口时间", "2018.08.01 00:14", null),
            new OrderSpec(null, "车道交易流水", "201808010015", null),
            new OrderSpec(null, "虚拟鲁通卡号", "123456", null));
    Object[] params = {businessCatId, businessStatus, orderSpecs};
    if (clazz != null) {
      while (true) {
        GroovyObject groovyObject = (GroovyObject) clazz.newInstance();
        OrderSpecFilteredDTO filteredDTO = (OrderSpecFilteredDTO) groovyObject
            .invokeMethod("applyRule", params);
        log.info("targetOrderSpecs={},extraAttributes={}", filteredDTO.getTargetOrderSpecs(),
            filteredDTO.getExtraAttributes());
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
//    OrderSpecRuleClient groovy = new OrderSpecRuleClient();
//
//    String filename = "hello.groovy";
//    String[] roots = new String[]{"script"};
//
//    groovy
//        .runGroovyScriptByFile(roots, filename, "hello", new String[]{"param3", "param4"});

  }

}

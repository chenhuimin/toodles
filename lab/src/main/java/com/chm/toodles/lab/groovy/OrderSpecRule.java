package com.chm.toodles.lab.groovy;

import groovy.lang.Binding;
import groovy.lang.Script;
import groovy.util.GroovyScriptEngine;
import groovy.util.ResourceException;
import groovy.util.ScriptException;
import java.io.IOException;

public class OrderSpecRule {


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

  public static void main(String[] args) throws IOException, ResourceException, ScriptException {
    OrderSpecRule groovy = new OrderSpecRule();

    String filename = "hello.groovy";
    String[] roots = new String[]{"script"};

    groovy
        .runGroovyScriptByFile(roots, filename, "hello", new String[]{"param3", "param4"});


  }

}

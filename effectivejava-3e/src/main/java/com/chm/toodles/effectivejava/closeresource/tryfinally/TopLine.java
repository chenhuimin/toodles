package com.chm.toodles.effectivejava.closeresource.tryfinally;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TopLine {

  static String firstLineOfFile(String path) throws IOException {
    BufferedReader bf = new BufferedReader(new FileReader(path));
    try {
      return bf.readLine();
    } finally {
      bf.close();
    }
  }

  public static void main(String[] args) throws IOException {
    String paht = args[0];
    String s = firstLineOfFile(paht);
    System.out.println(s);
  }
}

package com.chm.toodles.effectivejava.closeresource.trywithresources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Copy {

  private static final int BUFFER_SIZE = 8 * 1024;

  static void copy(String src, String dst) throws IOException {
    try (InputStream in = new FileInputStream(src); OutputStream out = new FileOutputStream(dst)) {
      byte[] buffer = new byte[BUFFER_SIZE];
      int n;
      while ((n = in.read(buffer)) >= 0) {
        out.write(buffer, 0, n);
      }
    }
  }

  public static void main(String[] args) throws IOException {
    String src = args[0];
    String dst = args[1];
    copy(src, dst);
  }

}
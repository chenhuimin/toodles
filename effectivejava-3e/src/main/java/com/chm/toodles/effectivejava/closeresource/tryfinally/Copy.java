package com.chm.toodles.effectivejava.closeresource.tryfinally;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Copy {

  private static final int BUFFER_SIZE = 8 * 1024;

  public static void copy(String src, String dst) throws IOException {
    InputStream in = new FileInputStream(src);
    try {
      OutputStream out = new FileOutputStream(dst);
      try {
        byte[] buf = new byte[BUFFER_SIZE];
        int n;
        while ((n = in.read(buf)) >= 0) {
          out.write(buf, 0, n);
        }

      } finally {
        out.close();
      }

    } finally {
      in.close();
    }
  }

  public static void main(String[] args) throws IOException {
    String src = args[0];
    String dst = args[1];
    copy(src, dst);
  }

}

package com.chm.toodles.common.base;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResponseData<T> {

  private int code = 200;
  private String message = "";
  private T data;

  public static <T> ResponseData ok(T data) {
    return new ResponseData<>(data);
  }

  public static ResponseData fail() {
    return new ResponseData(null);
  }

  public static ResponseData fail(String message) {
    return new ResponseData(message);
  }

  public static ResponseData fail(String message, int code) {
    return new ResponseData(message, code);
  }

  public static ResponseData failByParam(String message) {
    return new ResponseData(message, ResponseCode.PARAM_ERROR_CODE.getCode());
  }

  public ResponseData(T data) {
    this.data = data;
  }

  public ResponseData(String message) {
    this.message = message;
  }

  public ResponseData(String message, int code) {
    this.message = message;
    this.code = code;
  }

}

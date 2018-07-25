package com.chm.toodles.bootshowcase.constant;

/**
 * 错误枚举
 */
public enum ErrorEnum {
  /**
   * 参数不合法错误
   */
  PARAMETER_INVALID(1, "%s无效"),

  /**
   * 参数格式错误
   */
  FORMAT_INVALID(2, "%s格式错误"),

  /**
   * 数据不存在错误
   */
  DATA_NOT_FOUND(3, "%s不存在"),

  /**
   * 数据已经存在错误
   */
  DATA_EXISTED(4, "%s已存在"),

  /**
   * 用户未登陆错误
   */
  LOGIN_REQUIRED(5, "未登陆"),

  /**
   * 用户无操作权限错误
   */
  PERMISSION_DENIED(6, "无权限"),

  /**
   * 服务端处理错误
   */
  SERVER_ERROR(7, "服务端异常"),

  /**
   * 未知异常
   */
  UNKNOW_ERROR(999, "未知异常");

  /**
   * 业务错误码
   */
  private final int code;

  /**
   * 错误提示
   */
  private final String message;

  ErrorEnum(int code, String message) {
    this.code = code;
    this.message = message;
  }

  public int getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }
}

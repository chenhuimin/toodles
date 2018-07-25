package com.chm.toodles.bootshowcase.common;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 通用错误响应处理类
 *
 * @author chenhuimin66@gmail.com
 */
@Data
@AllArgsConstructor
public class ErrorResponse implements Serializable {

  private static final long serialVersionUID = 8537847856357161154L;
  /**
   * 状态码
   */
  private int status;

  /**
   * 错误体
   */
  private ErrorBody error;
}

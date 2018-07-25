package com.chm.toodles.bootshowcase.entity;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "student")
@Table(name = "showcase_student")
public class Student implements Serializable {

  private static final long serialVersionUID = -884399542063628659L;


  private Long id;

  /**
   * 学生姓名
   */
  @ApiModelProperty(value = "学生姓名")
  private String name;

  /**
   * 学生年龄
   */
  @ApiModelProperty(value = "学生年龄")
  private Integer age;


}

package com.chm.toodles.bootshowcase.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 学生实体类
 *
 * @author chenhuimin66@gmail.com
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "student")
@Table(name = "showcase_student")
public class Student implements Serializable {

  private static final long serialVersionUID = -884399542063628659L;


  /**
   * 姓名
   */
  @Column(length = 5, nullable = false)
  private String name;

  /**
   * 年龄
   */
  private Integer age;

  public static void main(String[] args) {
    Student stu = new Student("test", 10);

  }

}

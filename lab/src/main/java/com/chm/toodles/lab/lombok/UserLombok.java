package com.chm.toodles.lab.lombok;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@NoArgsConstructor
public class UserLombok implements Serializable {

  private static final long serialVersionUID = 2965666332523912946L;
  private String name;
  private int age;
  private double score;
  private List<String> tags;

  public static void main(String[] args) {
    UserLombok userLombok = new UserLombok();

    userLombok.setAge(18);
    List<String> tags = Arrays.asList("apple", "juice");
    userLombok.setTags(tags);
    userLombok.setScore(99.99);
    System.out.println(userLombok);

  }
}
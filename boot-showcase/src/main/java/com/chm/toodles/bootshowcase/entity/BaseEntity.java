package com.chm.toodles.bootshowcase.entity;

import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @ApiModelProperty(value = "id")
  protected Long id;

  protected Date gmtCreate;

  protected Date gmtModified;

  protected Integer version;

  protected Integer isDeleted;

}

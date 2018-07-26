package com.chm.toodles.bootshowcase.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;


/**
 * Base Entity类，被所有实体类继承，包含公共字段信息。
 *
 * @author chenhuimin66@gmail.com
 */
@MappedSuperclass
public abstract class BaseEntity {

  /**
   * id
   */
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(columnDefinition = "unsigned bigint")
  protected Long id;

  /**
   * 创建时间
   */
  @Column(name = "gmt_create", columnDefinition = "datetime not null default current_timestamp ")
  protected Date gmtCreate;

  /**
   * 上次更新时间
   */
  @Column(name = "gmt_modified", columnDefinition = "datetime not null default current_timestamp on update current_timestamp ")
  protected Date gmtModified;

  /**
   * 版本号
   */
  @Version
  protected Integer version;

  /**
   * 逻辑删除，1：删除，0：未删除
   */
  @Column(name = "is_deleted", columnDefinition = "unsigned tinyint not null default 0")
  protected Integer isDeleted;

}

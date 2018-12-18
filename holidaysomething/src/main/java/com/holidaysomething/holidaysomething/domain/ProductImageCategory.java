package com.holidaysomething.holidaysomething.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PRODUCT_IMAGE_CATEGORY")
@Getter
@Setter
public class ProductImageCategory {

  @Id
  private Long id;

  @Column(nullable = false)
  private String name;
}

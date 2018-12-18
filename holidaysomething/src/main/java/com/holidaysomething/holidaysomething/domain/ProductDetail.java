package com.holidaysomething.holidaysomething.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PRODUCT_DETAIL")
@Getter
@Setter
public class ProductDetail {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Lob
  private String description;


  public ProductDetail(String description) {
    this.description = description;
  }

  public ProductDetail() {
  }
}
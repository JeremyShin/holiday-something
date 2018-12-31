package com.holidaysomething.holidaysomething.domain;

import lombok.Data;

@Data
public class ProductCategoryDto {

  private Long id;
  private String name;
  private Long parentId;
  private int orders;
}

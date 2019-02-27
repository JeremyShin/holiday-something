package com.holidaysomething.holidaysomething.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author choijaeyong on 25/01/2019.
 * @project holidaysomething User 페이지에서 카테고리를 검색 조건으로 해서 해당 카테고리의 상품 리스트를 불러올 때 필요한 DTO.
 */
@Getter
@Setter
public class ProductListImageDto {

  private Long productId;
  private String productName;
  private Integer sellingPrice;
  private Integer originalPrice;
  private String optionalPriceText;
  private String imagePath;
  private String imageName;
  private long categoryId;

  public ProductListImageDto(Long productId, String productName, Integer sellingPrice,
      Integer originalPrice, String optionalPriceText, String imagePath, String imageName,
      long categoryId) {
    this.productId = productId;
    this.productName = productName;
    this.sellingPrice = sellingPrice;
    this.originalPrice = originalPrice;
    this.optionalPriceText = optionalPriceText;
    this.imagePath = imagePath;
    this.imageName = imageName;
    this.categoryId = categoryId;
  }
}

package com.holidaysomething.holidaysomething.dto;

import com.holidaysomething.holidaysomething.domain.Product;
import lombok.Getter;
import lombok.Setter;

/**
 * @author choijaeyong on 25/01/2019.
 * @project holidaysomething
 * @description
 * User 페이지에서
 * 카테고리를 검색 조건으로 해서 해당 카테고리의 상품 리스트를 불러올 때 필요한 DTO.
 */
@Getter
@Setter
public class ProductListImageDto {

  //private Product product;
  private String productName;
  private Integer sellingPrice;
  private Integer originalPrice;
  private Integer quantity;
  private Integer safeQuantity;
  private String optionalPriceText;
  private String imagePath;
  private String imageName;
  private long categoryId;

  public ProductListImageDto(String productName, Integer sellingPrice,
      Integer originalPrice, Integer quantity, Integer safeQuantity,
      String optionalPriceText, String imagePath, String imageName, long categoryId) {
    this.productName = productName;
    this.sellingPrice = sellingPrice;
    this.originalPrice = originalPrice;
    this.quantity = quantity;
    this.safeQuantity = safeQuantity;
    this.optionalPriceText = optionalPriceText;
    this.imagePath = imagePath;
    this.imageName = imageName;
    this.categoryId = categoryId;
  }
}

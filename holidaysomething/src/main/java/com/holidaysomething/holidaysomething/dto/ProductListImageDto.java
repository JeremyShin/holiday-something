package com.holidaysomething.holidaysomething.dto;

import com.holidaysomething.holidaysomething.domain.Product;
import lombok.Getter;
import lombok.Setter;

/**
 * @author choijaeyong on 25/01/2019.
 * @project holidaysomething
 * @description
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

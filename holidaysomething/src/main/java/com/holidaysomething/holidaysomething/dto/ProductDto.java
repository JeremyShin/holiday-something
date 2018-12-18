package com.holidaysomething.holidaysomething.dto;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class ProductDto {

  private Long id;
  private String name;
  private int originalPrice;
  private int sellingPrice;

  private int manufacturingPrice;

  private String code;
  private String manufacturer;

  private int shippingPrice;

  private int quantity;

  private int sellingQuantity;

  private int safeQuantity;

  private int mileage;

  private Boolean display;
  private String optionalPriceText;
  private LocalDateTime regDate;


  private LocalDateTime manufactureDate;

//  @DateTimeFormat(pattern = "yyyy-MM-dd")
//  private LocalDateTime releaseDate;

  private LocalDateTime releaseDate;


  private Long productCategoryId;
  private String productDescription;

  //private Set<ProductImage> productImages;
  //private Set<ProductOption> productOptions;
}
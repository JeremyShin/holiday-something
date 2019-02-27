package com.holidaysomething.holidaysomething.dto;

import java.time.LocalDateTime;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductAddDto {

  @NotEmpty(message = "name must be not null")
  private String name;

  @NotNull(message = "originalPrice must be not null")
  @Min(value = 0, message = "originalPrice higher than 0")
  private Integer originalPrice;

  @NotNull(message = "sellingPrice must be not null")
  @Min(value = 0, message = "sellingPrice higher than 0")
  private Integer sellingPrice;

  @NotNull(message = "manufacturingPrice must be not null")
  @Min(value = 0, message = "manufacturingPrice higher than 0")
  private Integer manufacturingPrice;

  @NotEmpty(message = "code must be not null")
  private String code;

  @NotEmpty(message = "manufacturer must be not null")
  private String manufacturer;

  @NotNull(message = "shippingPrice must be not null")
  @Min(value = 0, message = "shippingPrice higher than 0")
  private Integer shippingPrice;

  private Integer sellingQuantity;

  private Integer mileage;

  private Boolean display;

  private String optionalPriceText;

  private LocalDateTime regDate;

  @NotEmpty(message = "manufactureDate must be not null")
  private String manufactureDate;

  @NotEmpty(message = "releaseDate must be not null")
  private String releaseDate;

  @NotNull(message = "productCategory must be not null")
  private Long productCategoryId;

  @NotNull(message = "description must be not null")
  private String description;

  @NotNull(message = "quantity must be not null")
  private Integer quantity;

}
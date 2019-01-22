package com.holidaysomething.holidaysomething.dto;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductOrderInfoDto {
  @NotNull
  private Long productId;

  @NotNull
  private String productName;

  @NotNull
  private String manufacturer;

  @NotNull
  private String shippingPrice;

  @NotNull
  private Integer mileage;

  @NotNull
  private Integer sellingPrice;

  @NotNull
  private Long optionId;

  @NotNull
  private String optionName;

  @NotNull
  private Integer optionPrice;

  //사용자가 제품 몇 개를 선택했는지에 대한 정보
  @NotNull
  private Integer orderQuantity;

}

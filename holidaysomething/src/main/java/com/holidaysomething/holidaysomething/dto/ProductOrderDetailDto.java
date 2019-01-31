package com.holidaysomething.holidaysomething.dto;

import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class ProductOrderDetailDto {
  @NotNull
  private String manufacturer;

  @NotNull
  private String productName;

  @NotNull
  private String productImage;

  @NotNull
  private Integer originalPrice;

  @NotNull
  private Integer sellingPrice;

  private Integer mileage;

  private Integer shippingPrice;

  private String img;

  private List<String> optionName;

  private List<Integer> optionPrice;

  public ProductOrderDetailDto() {
    this.optionName = new ArrayList<>();
    this.optionPrice = new ArrayList<>();
  }
}

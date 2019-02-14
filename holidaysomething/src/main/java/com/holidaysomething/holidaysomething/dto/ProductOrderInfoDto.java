package com.holidaysomething.holidaysomething.dto;

import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class ProductOrderInfoDto {
  @NotNull
  private Long productId;

  private Long optionId;

  @NotNull
  private Integer quantity;
}

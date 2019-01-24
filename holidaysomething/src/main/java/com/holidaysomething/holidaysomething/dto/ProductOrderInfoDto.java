package com.holidaysomething.holidaysomething.dto;

import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductOrderInfoDto {
  @NotNull
  private Long productId;

  @NotNull
  private Long optionId;

  //사용자가 제품 몇 개를 선택했는지에 대한 정보
  @NotNull
  private Integer orderQuantity;
}

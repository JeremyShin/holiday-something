package com.holidaysomething.holidaysomething.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class ProductOrderInfoDto {
  @NotNull
  private Long productId;

  @NotNull
  private Long optionId;

  @NotNull
  private Integer quantity;

////  //옵션아이디, 옵션의 개수를 담는 map
//  @NotNull
//  private
// List<Map<Long, Integer>> optionInfo;
//
//  public ProductOrderInfoDto() {
//    this.optionInfo = new HashMap<>();
//  }
  //
//  @NotNull
//  private List<Long> optionIds;
//
//  //사용자가 제품 옵션 몇 개를 선택했는지에 대한 정보
//  @NotNull
//  private List<Integer> orderQuantities;
}

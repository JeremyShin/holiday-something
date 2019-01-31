package com.holidaysomething.holidaysomething.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductOrderInfoDto {
  @NotNull
  private Long productId;

  //옵션아이디, 옵션의 개수를 담는 map
  @NotNull
  private Map<Long, Integer> optionInfo = new HashMap<>();

//  @NotNull
//  private List<Long> optionIds;
//
//  //사용자가 제품 옵션 몇 개를 선택했는지에 대한 정보
//  @NotNull
//  private List<Integer> orderQuantities;
}

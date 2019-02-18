package com.holidaysomething.holidaysomething.dto;

import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class ProductOrderCompleteDto {
  // 주문번호   / 가격 / 진행상태 / 마일리지 사용
  private String orderNumber;
  private String status;
  private Integer orderTotalUseMileage;

  @NotNull
  private Integer orderTotalPayment;

  private Long memberId;

}

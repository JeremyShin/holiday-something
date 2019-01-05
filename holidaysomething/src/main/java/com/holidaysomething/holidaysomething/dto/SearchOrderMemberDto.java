package com.holidaysomething.holidaysomething.dto;


import java.time.LocalDateTime;
import lombok.Data;


/**
 * member/order.html 에서 입력한 폼 데이터를 전송하기 위해 설계된 클래스.
 */

@Data
public class SearchOrderMemberDto {

  private String loginId;
  private String name;
  private String orderNumber;
  private String productName;
  private LocalDateTime orderStartDate;
  private LocalDateTime orderEndDate;
}

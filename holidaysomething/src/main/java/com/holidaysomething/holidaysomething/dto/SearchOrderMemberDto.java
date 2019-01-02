package com.holidaysomething.holidaysomething.dto;


import java.time.LocalDateTime;
import lombok.Data;

@Data
public class SearchOrderMemberDto {

  private String loginId;
  private String name;
  private String orderNumber;
  private String productName;
  private LocalDateTime orderStartDate;
  private LocalDateTime orderEndDate;


}

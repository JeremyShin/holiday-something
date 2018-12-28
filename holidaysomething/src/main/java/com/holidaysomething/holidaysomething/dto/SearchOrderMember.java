package com.holidaysomething.holidaysomething.dto;


import java.time.LocalDateTime;
import lombok.Data;

@Data
public class SearchOrderMember {

  private String loginId;
  private String name;
  private String productCode;
  private String productName;
  private LocalDateTime orderStartDate;
  private LocalDateTime orderEndDate;


}

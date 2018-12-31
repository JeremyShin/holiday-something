package com.holidaysomething.holidaysomething.dto;

import lombok.Data;

@Data
public class MemberMileageDto {

  private String loginId;
  private String plusOrMinus;
  private int mileage;
}

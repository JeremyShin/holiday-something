package com.holidaysomething.holidaysomething.dto;

import lombok.Data;

@Data
public class MemberMileageForm {

  private String loginId;
  private String plusOrMinus;
  private int mileage;
}

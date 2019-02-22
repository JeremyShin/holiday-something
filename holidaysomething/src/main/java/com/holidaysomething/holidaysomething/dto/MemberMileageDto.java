package com.holidaysomething.holidaysomething.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class MemberMileageDto {

  @NotEmpty(message = "loginId must be not empty")
  private String loginId;

  @NotNull(message = "mileage must be not null")
  @Min(value = 0, message = "mileage higher than 0")
  private int mileage;

  private String plusOrMinus;

  @NotNull(message = "addMileage must be not null")
  @Min(value = 1, message = "addMileage higher than 1")
  private int addMileage;

  // true면 입력할 수 있다는 뜻! Controller에서는 !를 붙여서 사용하고 있음.
  public boolean isPossible(){
    if(plusOrMinus.equals("-") && (getMileage() == 0 || mileage - addMileage < 0)){
      return false;
    }
    return true;
  }
}

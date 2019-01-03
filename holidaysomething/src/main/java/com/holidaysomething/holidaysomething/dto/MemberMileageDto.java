package com.holidaysomething.holidaysomething.dto;

import lombok.Data;

@Data
public class MemberMileageDto {

  private String loginId;
  private int mileage;
  private String plusOrMinus;
  private int addMileage;

  // 적립금이 (-)가 되지 않게 막자
  // 애당초 마일리지가 0원인 사람은 음수 값을 입력할 수 없게 막아야 되겠지?
  // true면 입력할 수 있다는 뜻! Controller에서는 !를 붙여서 사용하고 있음.
  public boolean isPossible(){
    return (mileage - addMileage) >= 0 || ((getMileage() == 0) && plusOrMinus.equals("+"));
  }
}

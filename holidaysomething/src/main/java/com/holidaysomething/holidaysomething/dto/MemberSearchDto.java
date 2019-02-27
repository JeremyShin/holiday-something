package com.holidaysomething.holidaysomething.dto;

import java.util.List;
import lombok.Data;

@Data
public class MemberSearchDto {

  public String memberSearchClassificationValue;
  public String memberSearchClassificationInput;
  public String memberBirthdayStart;
  public String memberBirthdayEnd;
  public String memberRegDateStart;
  public String memberRegDateEnd;
  public String memberOrderDateStart;
  public String memberOrderDateEnd;
  public List<String> memberSexCheck;

  public boolean hasValue() {
    return memberSearchClassificationValue != null || memberSearchClassificationInput != null ||
        memberBirthdayStart != null || memberBirthdayEnd != null ||
        memberRegDateStart != null || memberRegDateEnd != null ||
        memberOrderDateStart != null || memberOrderDateEnd != null;
  }
}

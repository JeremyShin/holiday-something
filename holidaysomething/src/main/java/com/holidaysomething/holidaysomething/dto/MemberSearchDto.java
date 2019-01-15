package com.holidaysomething.holidaysomething.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

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
}

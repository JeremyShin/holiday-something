package com.holidaysomething.holidaysomething.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class MemberSearchDto {
  private String searchClassificationValue;
  private String searchClassificationInput;
  private String birthdayStart;
  private String birthdayEnd;
  private String regDateStart;
  private String regDateEnd;
  private String orderDateStart;
  private String orderDateEnd;
  private List<String> sexCheck = new ArrayList<>();
}

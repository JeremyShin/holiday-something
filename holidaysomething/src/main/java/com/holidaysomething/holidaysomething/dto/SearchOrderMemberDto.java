package com.holidaysomething.holidaysomething.dto;


import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;


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

  //@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
  //@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private LocalDateTime orderEndDate;


  public boolean isEmpty() {
    if (loginId == null && name == null && orderNumber == null && productName == null
        && orderStartDate == null && orderEndDate == null) {
      return true;
    }
    return false;
  }
}
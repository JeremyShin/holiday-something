package com.holidaysomething.holidaysomething.dto;


import com.holidaysomething.holidaysomething.domain.Member;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * member/order.html 에 검색 결과를 출력하기 위한 Dto.
 */
@Data
public class OrderMemberDto {

  private Member member;
  private String orderNumber;
  private LocalDateTime date;

  public OrderMemberDto(Member member, LocalDateTime date, String orderNumber) {
    this.member = member;
    this.orderNumber = orderNumber;
    this.date = date;
  }

  public boolean isEmpty() {
    if (member == null && orderNumber == null && date == null) {
      return true;
    }
    return false;
  }
}

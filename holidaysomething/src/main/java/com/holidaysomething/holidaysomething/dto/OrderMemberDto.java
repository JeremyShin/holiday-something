package com.holidaysomething.holidaysomething.dto;


import com.holidaysomething.holidaysomething.domain.Member;
import java.time.LocalDateTime;
import lombok.Data;

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
}

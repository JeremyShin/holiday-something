package com.holidaysomething.holidaysomething.dto;


import com.holidaysomething.holidaysomething.domain.Member;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class OrderMemberDto {

  private Member member;
  private Long countOrder;

  public OrderMemberDto(Member member, Long countOrder) {
    this.member = member;
    this.countOrder = countOrder;
  }

}

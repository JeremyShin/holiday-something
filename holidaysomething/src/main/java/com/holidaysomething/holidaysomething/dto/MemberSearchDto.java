package com.holidaysomething.holidaysomething.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class MemberSearchDto {
  private final String loginId;
  private final String name;
  private final String email;
  private final String phone;
  private final String nickname;
  private final String add;
  private final Integer age;
  private final String sex;

  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm" )
  private final String orderDate;
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
  private final String regDate;
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
  private final String lastLogin;
}

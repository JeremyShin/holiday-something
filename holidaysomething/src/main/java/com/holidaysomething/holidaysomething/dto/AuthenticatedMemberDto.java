package com.holidaysomething.holidaysomething.dto;

import com.holidaysomething.holidaysomething.domain.Member;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticatedMemberDto {

  private Member member;
}

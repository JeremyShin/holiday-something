package com.holidaysomething.holidaysomething.service.member;

import com.holidaysomething.holidaysomething.domain.Member;
import com.holidaysomething.holidaysomething.dto.MemberAddDto;

public interface MemberAddService {

    // 회원가입할때 DTO를 도메인 객체로 만들어주자!
    // 회원가입하기!
    Member memberRegister(MemberAddDto memberAddDto);

}

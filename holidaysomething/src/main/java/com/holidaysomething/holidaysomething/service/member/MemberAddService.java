package com.holidaysomething.holidaysomething.service.member;

import com.holidaysomething.holidaysomething.domain.Member;
import com.holidaysomething.holidaysomething.domain.Role;
import com.holidaysomething.holidaysomething.dto.MemberAddDto;

public interface MemberAddService {

    // 회원가입하기!
    Member memberRegister(MemberAddDto memberAddDto);

    // USER 권한 불러오기
    Role memberRegisterLoadUserRole(long id);
}

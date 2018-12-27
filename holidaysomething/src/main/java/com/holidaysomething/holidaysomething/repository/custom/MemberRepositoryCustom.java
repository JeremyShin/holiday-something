package com.holidaysomething.holidaysomething.repository.custom;

import com.holidaysomething.holidaysomething.domain.Member;

public interface MemberRepositoryCustom {

  Member getMemberByDsl(Long id);

}

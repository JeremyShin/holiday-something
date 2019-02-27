package com.holidaysomething.holidaysomething.repository.custom;

import com.holidaysomething.holidaysomething.domain.Member;
import com.holidaysomething.holidaysomething.dto.MemberSearchDto;
import com.holidaysomething.holidaysomething.dto.SearchOrderMemberDto;
import com.querydsl.core.Tuple;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MemberRepositoryCustom {

  Page<Tuple> getMembersByDsl(SearchOrderMemberDto searchOrderMemberDto, Pageable pageable);

  Page<Member> searchMembers(MemberSearchDto memberSearchDto, Pageable pageable);
}

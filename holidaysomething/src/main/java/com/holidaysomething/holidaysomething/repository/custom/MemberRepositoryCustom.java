package com.holidaysomething.holidaysomething.repository.custom;

import com.holidaysomething.holidaysomething.domain.Member;
import com.holidaysomething.holidaysomething.dto.SearchOrderMemberDto;
import java.util.List;

import com.holidaysomething.holidaysomething.dto.SearchSexMemberDto;
import org.springframework.data.domain.Pageable;

public interface MemberRepositoryCustom {

  // test
  Member getMemberByDsl(Long id);

  List<Member> getMembersByDsl(SearchOrderMemberDto searchOrderMemberDto, Pageable pageable);

  List<Member> findMembersByLoginIdInOrdersByDsl(String loginId);

  List<Member> findMemberBySexInSearchByDsl(SearchSexMemberDto searchSexMemberDto, Pageable pageable);

}

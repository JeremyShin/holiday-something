package com.holidaysomething.holidaysomething.service.member;

import com.holidaysomething.holidaysomething.domain.Member;
import com.holidaysomething.holidaysomething.dto.MemberMileageDto;
import com.holidaysomething.holidaysomething.dto.MemberSearchDto;
import com.holidaysomething.holidaysomething.dto.SearchDto;
import java.util.List;
import com.holidaysomething.holidaysomething.dto.OrderMemberDto;
import com.holidaysomething.holidaysomething.dto.SearchDto;
import com.holidaysomething.holidaysomething.dto.SearchOrderMemberDto;
import com.querydsl.core.Tuple;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MemberService {

  Member findMemberByLoginId(String loginId);

  Member getCurrentMemberInfo(Long userId);

  void updateMember(MemberMileageDto memberMileageDto);

  Page<Member> findAllOrSearch(SearchDto searchDto, Pageable pageable);

  Page<Member> searchMembers(MemberSearchDto memberSearchDto, Pageable pageable);
  
  Page<OrderMemberDto> findMembersBySearchingInQuerydsl(
      SearchOrderMemberDto searchOrderMemberDto, Pageable pageable);
}

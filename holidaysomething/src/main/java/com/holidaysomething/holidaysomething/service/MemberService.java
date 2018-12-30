package com.holidaysomething.holidaysomething.service;

import com.holidaysomething.holidaysomething.domain.Member;
import com.holidaysomething.holidaysomething.dto.MemberMileageForm;
import com.holidaysomething.holidaysomething.dto.Search;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MemberService {
  Member findMemberByLoginId(String loginId);
  void updateMember(MemberMileageForm memberMileageForm);
  Page<Member> findAllOrSearch(Search search, Pageable pageable);
}

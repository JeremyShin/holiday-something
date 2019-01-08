package com.holidaysomething.holidaysomething.service.member;

import com.holidaysomething.holidaysomething.domain.Member;
import com.holidaysomething.holidaysomething.dto.MemberMileageDto;
import com.holidaysomething.holidaysomething.dto.SearchDto;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MemberService {

  Member findMemberByLoginId(String loginId);

  void updateMember(MemberMileageDto memberMileageDto);

  Page<Member> findAllOrSearch(SearchDto searchDto, Pageable pageable);

  Page<Member> searchMembers(String searchClassificationValue, String searchClassificationInput, String birthdayStart, String birthdayEnd, String regDateStart, String regDateEnd, String orderDateStart, String orderDateEnd, List<String> sexCheck, Pageable pageable);
}

package com.holidaysomething.holidaysomething.repository.custom;

import com.holidaysomething.holidaysomething.domain.Member;
import com.holidaysomething.holidaysomething.domain.Product;
import com.holidaysomething.holidaysomething.dto.MemberSearchDto;
import com.holidaysomething.holidaysomething.dto.SearchOrderMemberDto;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MemberRepositoryCustom {

  // test
  Member getMemberByDsl(Long id);

  List<Member> getMembersByDsl(SearchOrderMemberDto searchOrderMemberDto, Pageable pageable);

  List<Member> findMembersByLoginIdInOrdersByDsl(String loginId);

  Page<Member> searchMembers(String searchClassificationValue, String searchClassificationInput, String birthdayStart, String birthdayEnd, String regDateStart, String regDateEnd, String orderDateStart, String orderDateEnd, Pageable pageable);
}

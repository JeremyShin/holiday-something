package com.holidaysomething.holidaysomething.repository.custom;

import com.holidaysomething.holidaysomething.domain.Member;
import com.holidaysomething.holidaysomething.dto.SearchOrderMember;
import java.util.List;
import org.springframework.data.domain.Pageable;

public interface MemberRepositoryCustom {

  // test
  Member getMemberByDsl(Long id);

  List<Member> getMembersByDsl(SearchOrderMember searchOrderMember, Pageable pageable);

}

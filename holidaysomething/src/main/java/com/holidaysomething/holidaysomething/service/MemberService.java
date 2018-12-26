package com.holidaysomething.holidaysomething.service;

import com.holidaysomething.holidaysomething.domain.Member;
import com.holidaysomething.holidaysomething.dto.Search;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MemberService {

  Page<Member> findAllOrSearch(Search search, Pageable pageable);
}

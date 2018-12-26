package com.holidaysomething.holidaysomething.service.Impl;

import com.holidaysomething.holidaysomething.domain.Member;
import com.holidaysomething.holidaysomething.dto.Search;
import com.holidaysomething.holidaysomething.repository.MemberRepository;
import com.holidaysomething.holidaysomething.service.MemberService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberServiceImpl implements MemberService {

  private MemberRepository memberRepository;

  public MemberServiceImpl(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  @Override
  @Transactional
  public Page<Member> findAllOrSearch(Search search, Pageable pageable) {
    Page<Member> members = null;
    if (search.isSearched()) {
      members = memberRepository.findMembersByLoginId(search.getKeyword(), pageable);
    } else {
      members = memberRepository.findAll(pageable);
    }
    return members;
  }
}

package com.holidaysomething.holidaysomething.service.Impl;

import com.holidaysomething.holidaysomething.domain.Member;
import com.holidaysomething.holidaysomething.dto.MemberMileageForm;
import com.holidaysomething.holidaysomething.dto.Search;
import com.holidaysomething.holidaysomething.repository.MemberRepository;
import com.holidaysomething.holidaysomething.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

  private final MemberRepository memberRepository;

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

  @Override
  @Transactional(readOnly = true)
  public Member findMemberByLoginId(String loginId){
    return memberRepository.findMemberByLoginId(loginId);
  }

  @Override
  @Transactional
  public void updateMember(MemberMileageForm memberMileageForm){
    Member member = memberRepository.findMemberByLoginId(memberMileageForm.getLoginId());

    int mileage = member.getMileage();

    if(memberMileageForm.getPlusOrMinus().equals("+")) {
      mileage += memberMileageForm.getMileage();
    } else if(memberMileageForm.getPlusOrMinus().equals("-")) {
      mileage += memberMileageForm.getMileage() * -1;
    }
    // 적립금에 상한선이 있을까??
    // 적립금이 (-)가 되지 않게 막자
    // 애당초 마일리지가 0원인 사람은 음수 값을 입력할 수 없게 막아야 되겠지

    member.setMileage(mileage);

    memberRepository.save(member);
  }
}

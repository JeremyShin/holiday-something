package com.holidaysomething.holidaysomething.service.member;

import com.holidaysomething.holidaysomething.domain.Member;
import com.holidaysomething.holidaysomething.dto.MemberMileageDto;
import com.holidaysomething.holidaysomething.dto.SearchDto;
import com.holidaysomething.holidaysomething.repository.MemberRepository;
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
  @Transactional(readOnly = true)
  public Page<Member> findAllOrSearch(SearchDto searchDto, Pageable pageable) {
    Page<Member> members = null;
    if (searchDto.isSearched()) {
      members = memberRepository.findMembersByLoginId(searchDto.getKeyword(), pageable);
    } else {
      members = memberRepository.findAll(pageable);
    }
    return members;
  }

  @Override
  @Transactional(readOnly = true)
  public Member findMemberByLoginId(String loginId) {
    return memberRepository.findMemberByLoginId(loginId);
  }

  @Override
  @Transactional
  public void updateMember(MemberMileageDto memberMileageDto) {
    Member member = memberRepository.findMemberByLoginId(memberMileageDto.getLoginId());

    int mileage = member.getMileage();

    if (memberMileageDto.getPlusOrMinus().equals("+")) {
      mileage += memberMileageDto.getAddMileage();
    } else if (memberMileageDto.getPlusOrMinus().equals("-")) {
      mileage += memberMileageDto.getAddMileage() * -1;
    }
    // 적립금에 상한선이 있을까??

    member.setMileage(mileage);

    memberRepository.save(member);
  }
}

package com.holidaysomething.holidaysomething.service.member;

import com.holidaysomething.holidaysomething.domain.Member;
import com.holidaysomething.holidaysomething.dto.MemberMileageDto;
import com.holidaysomething.holidaysomething.dto.SearchDto;
import com.holidaysomething.holidaysomething.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

  private final MemberRepository memberRepository;

  @Override
  @Transactional
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
      mileage += memberMileageDto.getMileage();
    } else if (memberMileageDto.getPlusOrMinus().equals("-")) {
      mileage += memberMileageDto.getMileage() * -1;
    }
    // 적립금에 상한선이 있을까??
    // 적립금이 (-)가 되지 않게 막자
    // 애당초 마일리지가 0원인 사람은 음수 값을 입력할 수 없게 막아야 되겠지

    member.setMileage(mileage);

    memberRepository.save(member);
  }

  @Override
  public Page<Member> searchMembers(String searchClassificationValue,
      String searchClassificationInput, String birthdayStart, String birthdayEnd,
      String regDateStart, String regDateEnd, String orderDateStart, String orderDateEnd, Pageable pageable) {

    log.info("안녕 난 서비스야");

    Page<Member> memberPage = memberRepository.searchMembers(searchClassificationValue, searchClassificationInput, birthdayStart, birthdayEnd, regDateStart, regDateEnd, orderDateStart, orderDateEnd, pageable);

    return memberPage;
  }
}

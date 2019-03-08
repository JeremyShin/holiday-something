package com.holidaysomething.holidaysomething.service.member;

import com.holidaysomething.holidaysomething.domain.Member;
import com.holidaysomething.holidaysomething.dto.MemberOrderDto;
import com.holidaysomething.holidaysomething.dto.MemberMileageDto;
import com.holidaysomething.holidaysomething.dto.MemberSearchDto;
import com.holidaysomething.holidaysomething.dto.OrderMemberDto;
import com.holidaysomething.holidaysomething.dto.SearchDto;
import com.holidaysomething.holidaysomething.dto.SearchOrderMemberDto;
import com.holidaysomething.holidaysomething.repository.MemberRepository;
import com.querydsl.core.Tuple;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

  private final MemberRepository memberRepository;

  @Override
  @Transactional(readOnly = true)
  public Page<Member> findAllOrSearch(SearchDto searchDto, Pageable pageable) {
    if (searchDto.isValid()) {
      return memberRepository.findMembersByLoginId(searchDto.getKeyword(), pageable);
    } else {
      return memberRepository.findAll(pageable);
    }
  }

  /**
   * 현재 로그인 된 userId로 유저의 모든 정보를 찾는다. https://stackoverflow.com/a/49317013/8962314
   */
  @Override
  @Transactional(readOnly = true)
  public Member getCurrentMemberInfo(Long userId) {
    return memberRepository.findById(userId)
        .orElse(null);
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
    } else {
      throw new RuntimeException("plus or minus can press only one");
    }

    member.setMileage(mileage);
    memberRepository.save(member);
  }

  @Override
  @Transactional(readOnly = true)
  public Page<Member> searchMembers(MemberSearchDto memberSearchDto, Pageable pageable) {
    return memberRepository.searchMembers(memberSearchDto, pageable);
  }

  /**
   * @author JDragon member/order.html 에서 입력한 폼 데이터를 이용해 검색하는 서비스.
   */
  @Override
  @Transactional(readOnly = true)
  public Page<OrderMemberDto> findMembersBySearchingInQuerydsl(
      SearchOrderMemberDto searchOrderMemberDto, Pageable pageable) {

    Page<Tuple> tuples = memberRepository.getMembersByDsl(searchOrderMemberDto, pageable);

    long totalElements = tuples.getTotalElements();

    List<OrderMemberDto> orderMemberDtoList = new ArrayList<>();

    for (Tuple tuple : tuples) {
      Object[] objects = tuple.toArray();
      OrderMemberDto temp = new OrderMemberDto((Member) objects[0], (LocalDateTime) objects[1],
          (String) objects[2]);
      orderMemberDtoList.add(temp);
    }

    return new PageImpl<>(orderMemberDtoList, pageable, totalElements);
  }

  @Override
  @Transactional(readOnly = true)
  public MemberOrderDto findMemberById(Long id) {
    MemberOrderDto memberOrderDto = new MemberOrderDto();

    Member member = memberRepository.findMemberById(id);

    memberOrderDto.setName(member.getName());
    memberOrderDto.setPhone(member.getPhone());
    memberOrderDto.setEmail(member.getEmail());
    memberOrderDto.setAddress1(member.getAddress1());
    memberOrderDto.setAddress2(member.getAddress2());
    memberOrderDto.setPostcode(member.getPostcode());
    memberOrderDto.setMileage(member.getMileage());

    return memberOrderDto;
  }
}

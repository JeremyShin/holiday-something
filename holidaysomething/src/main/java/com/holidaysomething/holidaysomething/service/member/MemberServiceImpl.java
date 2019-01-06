package com.holidaysomething.holidaysomething.service.member;

import com.holidaysomething.holidaysomething.domain.Member;
import com.holidaysomething.holidaysomething.dto.MemberMileageDto;
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


  /**
   * @author JDragon member/order.html 에서 입력한 폼 데이터를 이용해 검색하는 서비스.
   */
  @Override
  @Transactional
  public Page<OrderMemberDto> findMembersBySearchingInQuerydsl(
      SearchOrderMemberDto searchOrderMemberDto, Pageable pageable) {

    Page<Tuple> tuples = memberRepository.getMembersByDsl(searchOrderMemberDto, pageable);

    log.info("==========tuples 의 길이 : " + tuples.getTotalElements());
    // searchOrderMemberDto 넘어온 값좀 확인해보자...
    log.info(
        "************** searchOrderMemberDto.getLoginId() :" + searchOrderMemberDto.getLoginId());
    log.info("************** searchOrderMemberDto.getName() :" + searchOrderMemberDto.getName());
    log.info("************** searchOrderMemberDto.getProductName() :" + searchOrderMemberDto
        .getProductName());
    log.info("************** searchOrderMemberDto.getOrderNumber() :" + searchOrderMemberDto
        .getOrderNumber());
    log.info("************** searchOrderMemberDto.getOrderStartDate() :" + searchOrderMemberDto
        .getOrderStartDate());
    log.info("************** searchOrderMemberDto.getOrderEndDate() :" + searchOrderMemberDto
        .getOrderEndDate());

    List<Tuple> orderMemberDtos = tuples.getContent();
    List<OrderMemberDto> orderMemberDtoList = new ArrayList<>();

    for (int i = 0; i < orderMemberDtos.size(); i++) {
      Tuple tuple = orderMemberDtos.get(i);
      Object[] objects = tuple.toArray();
      OrderMemberDto temp = new OrderMemberDto((Member) objects[0], (LocalDateTime) objects[1],
          (String) objects[2]);
      orderMemberDtoList.add(temp);
    }

    //  최종적으로 Controller 로 보내야 하는 Page.
    Page<OrderMemberDto> orderMemberDtoPages = new PageImpl<>(orderMemberDtoList, pageable,
        orderMemberDtoList.size());

    // java 8 부터 가능
    // int size = Math.toIntExact(tuples.getTotalElements());
    // return new PageImpl<>(tuples.getContent(), pageable, size);

    return orderMemberDtoPages;
  }

}

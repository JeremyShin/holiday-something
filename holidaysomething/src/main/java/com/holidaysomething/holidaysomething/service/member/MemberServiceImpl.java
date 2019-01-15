package com.holidaysomething.holidaysomething.service.member;

import com.holidaysomething.holidaysomething.domain.Member;
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
    member.setMileage(mileage);

    memberRepository.save(member);
  }


  @Override
  public Page<Member> searchMembers(MemberSearchDto memberSearchDto, Pageable pageable) {

    log.info("안녕 난 서비스야");

    log.info("getSearchClassificationInput" + memberSearchDto.getMemberSearchClassificationInput());
    log.info("getSearchClassificationValue" + memberSearchDto.getMemberSearchClassificationValue());
    log.info("getBirthdayStart" + memberSearchDto.getMemberBirthdayStart());
    log.info("getBirthdayEnd" + memberSearchDto.getMemberBirthdayEnd());
    log.info("getOrderDateStart" + memberSearchDto.getMemberOrderDateStart());
    log.info("getOrderDateEnd" + memberSearchDto.getMemberOrderDateEnd());
    log.info("getRegDateStart" + memberSearchDto.getMemberRegDateStart());
    log.info("getRegDateEnd" + memberSearchDto.getMemberRegDateEnd());

    Page<Member> memberPage = memberRepository.searchMembers(memberSearchDto, pageable);

    return memberPage;
  }


  /**
   * @author JDragon member/order.html 에서 입력한 폼 데이터를 이용해 검색하는 서비스.
   */
  @Override
  @Transactional
  public Page<OrderMemberDto> findMembersBySearchingInQuerydsl(
      SearchOrderMemberDto searchOrderMemberDto, Pageable pageable) {

    Page<Tuple> tuples = memberRepository.getMembersByDsl(searchOrderMemberDto, pageable);
    log.info("==========tuples getTotalPages : " + tuples.getTotalPages());
    log.info("==========tuples getSize : " + tuples.getSize());

    long totalElements = tuples.getTotalElements();

    //List<Tuple> orderMemberDtos = tuples.getContent();
    List<OrderMemberDto> orderMemberDtoList = new ArrayList<>();

    //Object[] objects = null;
    //OrderMemberDto temp = new OrderMemberDto(null,null,null);

    for (Tuple tuple : tuples) {
      Object[] objects = tuple.toArray();
//      objects = tuple.toArray();

      // 새로운 객체를 계속 생성하는걸 피하려고 바꿨는데... 어떤게 더 좋을까!?

//      temp.setMember((Member)objects[0]);
//      temp.setDate((LocalDateTime)objects[1]);
//      temp.setOrderNumber((String)objects[2]);
//      temp = new OrderMemberDto((Member) objects[0], (LocalDateTime) objects[1],
//          (String) objects[2]);
      OrderMemberDto temp = new OrderMemberDto((Member) objects[0], (LocalDateTime) objects[1],
          (String) objects[2]);
      orderMemberDtoList.add(temp);
    }

    Page<OrderMemberDto> orderMemberDtoPage =
        new PageImpl<>(orderMemberDtoList, pageable, totalElements);

    return orderMemberDtoPage;
  }

}

package com.holidaysomething.holidaysomething.JDragon.serviceTest;


import com.holidaysomething.holidaysomething.domain.Member;
import com.holidaysomething.holidaysomething.domain.Order;
import com.holidaysomething.holidaysomething.dto.OrderMemberDto;
import com.holidaysomething.holidaysomething.dto.SearchOrderMemberDto;
import com.holidaysomething.holidaysomething.repository.MemberRepository;
import com.holidaysomething.holidaysomething.service.member.MemberService;
import com.querydsl.core.Tuple;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberTest {

  private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager
      .getLogger(MemberTest.class);

  @Autowired
  MemberRepository memberRepository;

  @Autowired
  MemberService memberService;

  Pageable pageable;

  @Before
  public void pageable생성하기() {
    pageable = PageRequest.of(0, 2);

  }


  @Test
  public void 검색조건여러개사용해서회원조회서비스byDsl() {
    SearchOrderMemberDto searchOrderMemberDto = new SearchOrderMemberDto();
//    searchOrderMemberDto.setLoginId("sky");
//    searchOrderMemberDto.setName("김하늘");
//    searchOrderMemberDto.setProductName("스밋코구라시");
    LocalDateTime ldt1 = LocalDateTime.of(2018, 11, 01, 00, 00, 00);
    LocalDateTime ldt2 = LocalDateTime.of(2018, 11, 25, 00, 00, 00);
    searchOrderMemberDto.setOrderStartDate(ldt1);
    searchOrderMemberDto.setOrderEndDate(ldt2);
//    searchOrderMemberDto.setOrderNumber("2018111950137514");
//    searchOrderMemberDto.setName("오박사");

//    Page<OrderMemberDto> orderMemberDtoPage = memberService
//        .findMembersBySearchingInQuerydsl(searchOrderMemberDto, pageable);
    Page<Tuple> tuples = memberService
        .findMembersBySearchingInQuerydsl(searchOrderMemberDto, pageable);

    log.info("=============== tuples" + tuples.getTotalPages());
    log.info("=============== tuples" + tuples.getTotalElements());

    long totalElements = tuples.getTotalElements();

    List<Tuple> orderMemberDtos = tuples.getContent();
    log.info(
        "**************List<Tuple> 형태. tuples.getContent().size : " + tuples.getContent().size());
    List<OrderMemberDto> orderMemberDtoList = new ArrayList<>();
    log.info("************** orderMemberDtos.size() : " + orderMemberDtos.size());

    for (Tuple tuple : tuples) {
      Object[] objects = tuple.toArray();
      log.info("+++++++++++++++++++++++ objects.length : " + objects.length);
      OrderMemberDto temp = new OrderMemberDto((Member) objects[0], (LocalDateTime) objects[1],
          (String) objects[2]);
      orderMemberDtoList.add(temp);
    }

//    for (int i = 0; i < orderMemberDtos.size(); i++) {
//      Tuple tuple = orderMemberDtos.get(i);
//      Object[] objects = tuple.toArray();
//      log.info("+++++++++++++++++++++++ objects.length : " + objects.length);
//      OrderMemberDto temp = new OrderMemberDto((Member) objects[0], (LocalDateTime) objects[1],
//          (String) objects[2]);
//      orderMemberDtoList.add(temp);
//    }

    log.info("==================== orderMemberDtoList.size() : " + orderMemberDtoList.size());

//    Page<OrderMemberDto> orderMemberDtoPages = new PageImpl<>(orderMemberDtoList, pageable,
//        orderMemberDtoList.size());

    Page<OrderMemberDto> orderMemberDtoPages =
        new PageImpl<>(orderMemberDtoList, pageable, totalElements);
    log.info("%%%%%%%%%%%%%%%% orderMemberDtoPages.getTotalPages() " + orderMemberDtoPages
        .getTotalPages());
    log.info("%%%%%%%%%%%%%%%% orderMemberDtoPages.getTotalElements() " + orderMemberDtoPages
        .getTotalElements());
    log.info("%%%%%%%%%%%%%%%% orderMemberDtoPages.getSize() " + orderMemberDtoPages.getSize());

    for (OrderMemberDto orderMemberDto : orderMemberDtoPages) {
      log.info(" id : " + orderMemberDto.getMember().getId());
      log.info("date : " + orderMemberDto.getDate());
      log.info("orderNumber : " + orderMemberDto.getOrderNumber());
    }

  }
}

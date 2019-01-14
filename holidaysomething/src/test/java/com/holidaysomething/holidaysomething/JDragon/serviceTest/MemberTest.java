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
    searchOrderMemberDto.setOrderStartDate("2018-11-01T00:00:00");
    searchOrderMemberDto.setOrderEndDate("2018-11-25T23:59:59");
//    searchOrderMemberDto.setOrderStartDate(ldt1);
//    searchOrderMemberDto.setOrderEndDate(ldt2);
//    searchOrderMemberDto.setOrderNumber("2018111950137514");
//    searchOrderMemberDto.setName("오박사");

//    Page<OrderMemberDto> orderMemberDtoPage = memberService
//        .findMembersBySearchingInQuerydsl(searchOrderMemberDto, pageable);
    Page<OrderMemberDto> orderMemberDtoPages = memberService
        .findMembersBySearchingInQuerydsl(searchOrderMemberDto, pageable);


    for (OrderMemberDto orderMemberDto : orderMemberDtoPages) {
      log.info(" id : " + orderMemberDto.getMember().getId());
      log.info("date : " + orderMemberDto.getDate());
      log.info("orderNumber : " + orderMemberDto.getOrderNumber());
    }

  }
}

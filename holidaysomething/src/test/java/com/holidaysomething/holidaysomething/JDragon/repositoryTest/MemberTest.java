package com.holidaysomething.holidaysomething.JDragon.repositoryTest;


import com.holidaysomething.holidaysomething.domain.Member;
import com.holidaysomething.holidaysomething.domain.Order;
import com.holidaysomething.holidaysomething.dto.OrderMemberDto;
import com.holidaysomething.holidaysomething.dto.SearchOrderMemberDto;
import com.holidaysomething.holidaysomething.repository.MemberRepository;
import com.querydsl.core.Tuple;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
public class MemberTest {

  private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager
      .getLogger(MemberTest.class);

  @Autowired
  MemberRepository memberRepository;

  Pageable pageable;

  @Before
  public void pageable생성하기() {
    pageable = PageRequest.of(0, 10);

  }

  @Test
  public void 사용자정보loginId로읽어들이기() throws Exception {
    Member member = memberRepository.findByIdContaining("root");

    log.info("=====================================");
    log.info(member.getId());
    log.info(member.getEmail());
    log.info(member.getName());
    log.info(member.getBirthday());
    log.info("=====================================");
  }

  // 주문정보에서 로그인 아이디로 회원 검색하기.

  @Test
  public void Orders조회하기() {
    List<Order> orders = memberRepository.findAllOrders(18l);
    for (Order order : orders) {
      log.info("========================" + order.getId());
    }
  }

  @Test
  public void 로그인아이디로주문회원조회() {
    // 최신 버전 방법. 아래 두 방법 다 필요없다. count 함수를 빼기로함.
    List<Member> members = memberRepository.findMembersByLoginIdInOrders("sky");
    for (Member member : members) {
      log.info("===================== member : " + member.getId());
      log.info("===================== member : " + member.getName());
    }

    //List<Object[]> members = memberRepository.findMembersInOrders("sky");
    //List<OrderMemberDto> members = memberRepository.findMembersInOrders("sky");
    //log.info(members.size());

    // 1. List<Object[]> 으로 받는 방법.
//    for(Object[] object : members) {
//      System.out.println(object[0]);
//      System.out.println(object[1]);
//    }

    // 2. DTO 객체를 만들어 받는 방법.
//    OrderMemberDto orderMemberDto = members.get(0);
//    log.info("==================== : " + orderMemberDto.getMember().getName());
//    log.info("==================== : " + orderMemberDto.getCountOrder());
  }

  @Test
  public void 이름으로주문회원조회() {
//    List<OrderMemberDto> orderMemberDtos = memberRepository.findMembersByNameInOrders("김하늘");
//    OrderMemberDto orderMemberDto = orderMemberDtos.get(0);

    List<Member> members = memberRepository.findMembersByNameInOrders("김하늘");

    for (Member member : members) {
      log.info("====================== : " + member.getId() + "    " + member.getLoginId());
    }

//    log.info("==================== : " + orderMemberDto.getMember().getLoginId());
//    log.info("==================== : " + orderMemberDto.getMember().getName());
//    log.info("==================== : " + orderMemberDto.getCountOrder());
  }

  @Test
  public void 기간으로주문회원조회() {
    LocalDateTime ldt1 = LocalDateTime.of(2018, 11, 01, 00, 00, 00);
    LocalDateTime ldt2 = LocalDateTime.of(2018, 12, 01, 00, 00, 00);
    List<Member> members = memberRepository.findMembersByOrderPeriod(ldt1, ldt2);
    log.info("==================== size : " + members.size());
    for (Member member : members) {
      log.info(member.getId() + "        " + member.getName());
    }
//    for (Member member : members) {
//      log.info(member.getId() + " ----- " + member.getName() + " ----- " + member.getNickname());
//    }
  }


  @Test
  public void 주문번호로회원조회() {
    Member member = memberRepository.findMembersByOrderNumberInOrders("2018111950137514");
    // member id가 6인 회원만 출력 되어야 한다!
    log.info("====== member.id = " + member.getId());
    log.info("====== member.id = " + member.getName());
  }


  @Test
  public void id로회원조회byDSL() {
    Member member = memberRepository.getMemberByDsl(18L);
    log.info("=====================================");
    log.info(member.getId());
    log.info(member.getEmail());
    log.info(member.getName());
    log.info(member.getBirthday());
    log.info("=====================================");
  }


  @Test
  public void loginId로회원조회byDsl() {
    List<Tuple> tuples = memberRepository.findMembersByLoginIdInOrdersByDsl("sky");
    log.info("==================================" + tuples.size());
    for (Tuple tuple : tuples) {
      log.info(tuple);
    }
  }

  @Test
  public void name으로회원조회byDsl() {
    List<Tuple> tuples = memberRepository.findMembersByNameInOrdersByDsl("김하늘");
    log.info("==================================" + tuples.size());
    for (Tuple tuple : tuples) {
      log.info(tuple);
    }
  }

  @Test
  public void productName으로회원조회byDsl() {
    List<Tuple> tuples = memberRepository.findMembersByProductNameInOrdersByDsl("스밋코구라시");
    log.info("==================================" + tuples.size());
    for (Tuple tuple : tuples) {
      log.info(tuple);
    }
  }


  @Test
  public void 주문기간으로회원조회byDsl() {
    LocalDateTime ldt1 = LocalDateTime.of(2018, 11, 01, 00, 00, 00);
    LocalDateTime ldt2 = LocalDateTime.of(2018, 11, 25, 00, 00, 00);
    List<Tuple> tuples = memberRepository.findMembersByProductPeriodInOrdersByDsl(ldt1, ldt2);
    log.info("==================================" + tuples.size());
    for (Tuple tuple : tuples) {
      log.info(tuple);
    }
  }


  @Test
  public void 주문코드으로회원조회byDsl() {
    List<Tuple> tuples = memberRepository.findMembersByProductCodeInOrdersByDsl("2018111950137514");
    log.info("==================================" + tuples.size());
    for (Tuple tuple : tuples) {
      log.info(tuple);
    }
  }

  @Test
  public void 검색조건여러개사용해서회원조회byDsl() {
    SearchOrderMemberDto searchOrderMemberDto = new SearchOrderMemberDto();
//    searchOrderMemberDto.setLoginId("sky");
//    searchOrderMemberDto.setName("김하늘");
    searchOrderMemberDto.setProductName("스밋코구라시");
    LocalDateTime ldt1 = LocalDateTime.of(2018, 11, 01, 00, 00, 00);
    LocalDateTime ldt2 = LocalDateTime.of(2018, 11, 25, 00, 00, 00);
    searchOrderMemberDto.setOrderStartDate(ldt1);
    searchOrderMemberDto.setOrderEndDate(ldt2);
//    searchOrderMemberDto.setOrderNumber("2018111950137514");

    //searchOrderMemberDto.setName("오박사");

    log.info("=======================================" + searchOrderMemberDto.getLoginId());
    log.info("=======================================" + searchOrderMemberDto.getName());

    Page<Tuple> tuples = memberRepository.getMembersByDsl(searchOrderMemberDto, pageable);
    log.info("========================= tuples.getTotalElements() : " + tuples.getTotalElements());

//    OrderMemberDto[] orderMemberDtos = new OrderMemberDto[size];
    List<Tuple> orderMemberDtos = tuples.getContent();
    List<OrderMemberDto> orderMemberDtoList = new ArrayList<>();

    for (int i = 0; i < orderMemberDtos.size(); i++) {
      Tuple tuple = orderMemberDtos.get(i);
      log.info("======tuple.toArray().length : " + tuple.toArray().length);
      Object[] objects = tuple.toArray();
      log.info("======tuple.toArray() : " + objects[0]);
      log.info("======tuple.toArray() : " + objects[1]);
      log.info("======tuple.toArray() : " + objects[2]);
      OrderMemberDto temp = new OrderMemberDto((Member) objects[0], (LocalDateTime) objects[1],
          (String) objects[2]);
      orderMemberDtoList.add(temp);
    }

    for (OrderMemberDto orderMemberDto : orderMemberDtoList) {
      log.info("============ orderMemberDto.getMember().getId() : " + orderMemberDto.getMember()
          .getId());
      log.info("============ orderMemberDto.getOrderNumber() : " + orderMemberDto.getOrderNumber());
      log.info("============ orderMemberDto.getDate() : " + orderMemberDto.getDate());
    }

    //  최종적으로 Controller 로 보내야 하는 Page.
    Page<OrderMemberDto> orderMemberDtoPages = new PageImpl<>(orderMemberDtoList, pageable,
        orderMemberDtoList.size());
    log.info("*************** orderMemberDtoPages.getTotalElements() : " + orderMemberDtoPages
        .getTotalElements());
    log.info("*************** orderMemberDtoPages.getTotalPages() : " + orderMemberDtoPages
        .getTotalPages());
    log.info("*************** orderMemberDtoPages.getSize() : " + orderMemberDtoPages.getSize());

  }
}

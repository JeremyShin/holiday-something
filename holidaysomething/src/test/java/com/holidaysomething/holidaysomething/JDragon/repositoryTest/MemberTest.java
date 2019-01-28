package com.holidaysomething.holidaysomething.JDragon.repositoryTest;


import com.holidaysomething.holidaysomething.dto.CurrentMemberDto;
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
    pageable = PageRequest.of(0, 2);

  }

  @Test
  public void 현재_사용자_최근주문_가져오기() throws Exception {
    List<CurrentMemberDto> currentMemberDtoList = memberRepository.findCurrentMember(3L);
    for (CurrentMemberDto currentMemberDto : currentMemberDtoList) {
      log.info(currentMemberDto.getMemberId());
      log.info(currentMemberDto.getName());
      log.info(currentMemberDto.getNickname());
      log.info(currentMemberDto.getMileage());
      log.info(currentMemberDto.getOrderNumber());
      log.info(currentMemberDto.getTotalPrice());
    }
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
//  }
//
//  @Test
//  public void 로그인아이디로주문회원조회() {
//    // 최신 버전 방법. 아래 두 방법 다 필요없다. count 함수를 빼기로함.
//    List<Member> members = memberRepository.findMembersByLoginIdInOrders("sky");
//    for (Member member : members) {
//      log.info("===================== member : " + member.getId());
//      log.info("===================== member : " + member.getName());
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
    Page<Tuple> pages = memberRepository.findMembersByLoginIdInOrdersByDsl("sky", pageable);
    log.info(
        "============================= pages.getTotalElements() : " + pages.getTotalElements());
    log.info("============================= pages.getTotalPages() : " + pages.getTotalPages());
    List<Tuple> lists = pages.getContent();
    log.info("============================= lists.size() : " + lists.size());
    for (Tuple tuple : lists) {
      log.info("=========== tuple : " + tuple);
      Object[] objects = tuple.toArray();
      log.info("=========== objects[0] : " + ((Member) objects[0]).getId() + "   "
          + ((Member) objects[0]).getName());
      log.info("=========== objects[1] : " + objects[1]);
      log.info("=========== objects[2] : " + objects[2]);
//    for(Order order : lists) {
//      log.info("============================= lists.size() : " + order.getMember().getId());
//      log.info("============================= lists.size() : " + order.getMember().getName());
//      log.info("============================= lists.size() : " + order.getId());
//      log.info("============================= lists.size() : " + order.getOrderNumber());
//      log.info("============================= lists.size() : " + order.getDate());
    }

  }

  @Test
  public void name으로회원조회byDsl() {
    List<Tuple> tuples = memberRepository.findMembersByNameInOrdersByDsl("김준형");
    log.info("==================================" + tuples.size());
    for (Tuple tuple : tuples) {
      log.info(tuple);
    }
    log.info("======TEST FINISHED========");
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

    /*
        SearchOrderMemberDto 를 테스트에서 쓸땐 필드에 null 값이 들어간다.
        실제 데이터에선 "" 로 되기도 해서 실제 repo의 메소드에서는 "" 비교도 추가했다.
     */

    SearchOrderMemberDto searchOrderMemberDto = new SearchOrderMemberDto();
//    searchOrderMemberDto.setLoginId("sky");
    searchOrderMemberDto.setName("김준형");
//    searchOrderMemberDto.setProductName("스밋코구라시");
//    LocalDateTime ldt1 = LocalDateTime.of(2018, 11, 01, 00, 00, 00);
//    LocalDateTime ldt2 = LocalDateTime.of(2018, 11, 25, 00, 00, 00);
//    searchOrderMemberDto.setOrderStartDate("2018-11-01");
//    searchOrderMemberDto.setOrderEndDate("2018-11-25");
//    searchOrderMemberDto.setOrderStartDate(ldt1);
//    searchOrderMemberDto.setOrderEndDate(ldt2);
//    searchOrderMemberDto.setOrderNumber("2018111950137514");

    //searchOrderMemberDto.setName("오박사");

    log.info("=======================================" + searchOrderMemberDto.getLoginId());
    log.info("=======================================" + searchOrderMemberDto.getName());
    log.info("=======================================" + searchOrderMemberDto.getProductName());
    log.info("=======================================" + searchOrderMemberDto.getOrderStartDate());
    log.info("=======================================" + searchOrderMemberDto.getOrderEndDate());
    log.info("=======================================" + searchOrderMemberDto.getOrderNumber());

    Page<Tuple> tuples = memberRepository.getMembersByDsl(searchOrderMemberDto, pageable);
    log.info("========================= tuples.getTotalElements() : " + tuples.getTotalElements());
    log.info("========================= tuples.getSize() : " + tuples.getSize());
    log.info("========================= tuples.getTotalPages() : " + tuples.getTotalPages());
    log.info(
        "========================= tuples.getNumberOfElements() : " + tuples.getNumberOfElements());
    log.info("========================= pageable.getOffset : " + pageable.getOffset());
    log.info("========================= pageable.getPageSize : " + pageable.getPageSize());

//    OrderMemberDto[] orderMemberDtos = new OrderMemberDto[size];

    // getContent 를 하면 pageable 의 size 만큼만 리스트화 한다.
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
      log.info("============ orderMemberDto.getName() : " + orderMemberDto.getMember().getName());
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


/*
select
        member0_.id as col_0_0_,
        orders1_.date as col_1_0_,
        orders1_.order_number as col_2_0_,
        member0_.id as id1_2_,
        member0_.address1 as address2_2_,
        member0_.address2 as address3_2_,
        member0_.birthday as birthday4_2_,
        member0_.email as email5_2_,
        member0_.last_login as last_log6_2_,
        member0_.login_id as login_id7_2_,
        member0_.marketing as marketin8_2_,
        member0_.mileage as mileage9_2_,
        member0_.name as name10_2_,
        member0_.nickname as nicknam11_2_,
        member0_.password as passwor12_2_,
        member0_.personal_info as persona13_2_,
        member0_.phone as phone14_2_,
        member0_.postcode as postcod15_2_,
        member0_.receive_email as receive16_2_,
        member0_.receive_sms as receive17_2_,
        member0_.recommender as recomme18_2_,
        member0_.reg_date as reg_dat19_2_,
        member0_.sex as sex20_2_
    from
        member member0_
    inner join
        orders orders1_
            on member0_.id=orders1_.member_id
    where
        orders1_.date in (
            select
                max(order2_.date)
            from
                orders order2_ cross
            join
                member member3_
            where
                order2_.member_id=member3_.id
                and (
                    member3_.name like ? escape '!'
                )
                and order2_.member_id=member0_.id
            group by
                order2_.member_id
        ) limit ?
 */
package com.holidaysomething.holidaysomething.JDragon.repositoryTest;


import com.holidaysomething.holidaysomething.domain.Member;
import com.holidaysomething.holidaysomething.domain.Order;
import com.holidaysomething.holidaysomething.dto.OrderMemberDto;
import com.holidaysomething.holidaysomething.repository.MemberRepository;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
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
    //List<Object[]> members = memberRepository.findMembersInOrders("sky");
    List<OrderMemberDto> members = memberRepository.findMembersInOrders("sky");
    log.info(members.size());

    // 1. List<Object[]> 으로 받는 방법.
//    for(Object[] object : members) {
//      System.out.println(object[0]);
//      System.out.println(object[1]);
//    }

    // 2. DTO 객체를 만들어 받는 방법.
    OrderMemberDto orderMemberDto = members.get(0);
    log.info("==================== : " + orderMemberDto.getMember().getName());
    log.info("==================== : " + orderMemberDto.getCountOrder());
  }

  @Test
  public void 이름으로주문회원조회() {
    List<OrderMemberDto> orderMemberDtos = memberRepository.findMembersByNameInOrders("김하늘");
    OrderMemberDto orderMemberDto = orderMemberDtos.get(0);
    log.info("==================== : " + orderMemberDto.getMember().getLoginId());
    log.info("==================== : " + orderMemberDto.getMember().getName());
    log.info("==================== : " + orderMemberDto.getCountOrder());
  }

  @Test
  public void 기간으로주문회원조회() {
    LocalDateTime ldt1 = LocalDateTime.of(2018, 11, 01, 00, 00, 00);
    LocalDateTime ldt2 = LocalDateTime.of(2018, 12, 01, 00, 00, 00);
    List<Member> members = memberRepository.getMembersByOrderPeriod(ldt1, ldt2);
    for (Member member : members) {
      log.info(member.getId() + " ----- " + member.getName() + " ----- " + member.getNickname());
    }
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
}

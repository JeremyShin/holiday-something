package com.holidaysomething.holidaysomething.JDragon.repositoryTest;


import com.holidaysomething.holidaysomething.domain.Member;
import com.holidaysomething.holidaysomething.domain.Order;
import com.holidaysomething.holidaysomething.dto.OrderMemberDto;
import com.holidaysomething.holidaysomething.repository.MemberRepository;
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

  @Autowired
  MemberRepository memberRepository;

  @Test
  public void 사용자정보loginId로읽어들이기() throws Exception {
    Member member = memberRepository.findByIdContaining("root");

    System.out.println("=====================================");
    System.out.println(member.getId());
    System.out.println(member.getEmail());
    System.out.println(member.getName());
    System.out.println(member.getBirthday());
    System.out.println("=====================================");

  }

  // 주문정보에서 로그인 아이디로 회원 검색하기.

  @Test
  public void Orders조회하기() {
    List<Order> orders = memberRepository.findAllOrders(18l);
    for (Order order : orders) {
      System.out.println("========================" + order.getId());
    }
  }

  @Test
  public void 로그인아이디로주문회원조회() {
    //List<Object[]> members = memberRepository.findMembersInOrders("sky");
    List<OrderMemberDto> members = memberRepository.findMembersInOrders("sky");
    System.out.println(members.size());

    // 1. List<Object[]> 으로 받는 방법.
//    for(Object[] object : members) {
//      System.out.println(object[0]);
//      System.out.println(object[1]);
//    }

    // 2. DTO 객체를 만들어 받는 방법.
    OrderMemberDto orderMemberDto = members.get(0);
    System.out.println("==================== : " + orderMemberDto.getMember().getName());
    System.out.println("==================== : " + orderMemberDto.getCountOrder());


  }

  @Test
  public void 이름으로주문회원조회() {
    List<OrderMemberDto> orderMemberDtos = memberRepository.findMembersByNameInOrders("김하늘");
    OrderMemberDto orderMemberDto = orderMemberDtos.get(0);
    System.out.println("==================== : " + orderMemberDto.getMember().getLoginId());
    System.out.println("==================== : " + orderMemberDto.getMember().getName());
    System.out.println("==================== : " + orderMemberDto.getCountOrder());

  }

//  @Test
//  public void 기간으로주문회원조회() {
//    List<Order> orders = memberRepository.getMembersByOrderPeriod(18l);
//    System.out.println("============================= " + orders.size());
//
//  }
}

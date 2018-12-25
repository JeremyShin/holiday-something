package com.holidaysomething.holidaysomething.repository;

import com.holidaysomething.holidaysomething.domain.Member;
import com.holidaysomething.holidaysomething.domain.Order;
import com.holidaysomething.holidaysomething.dto.OrderMemberDto;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberRepository extends JpaRepository<Member, Long> {

    /*
    회원 : loginId,password,email,name,nickname,phone,birthday,postcode, cartProducts
            address1,address2,receiveEmail,receiveSms,marketing,personalInfo,recommender
    */

  // 회원가입

  // 회원탈퇴

  // 회원 정보 수정

  // 회원 비밀번호 수정

  // 회원 정보 수정

  // 회원 비밀번호 수정


  // 회원정보조회
  @Query(value = "select me from Member me where me.loginId=(:loginId)")
  Member findByIdContaining(@Param("loginId") String loginId);

  @Query(value = "select me.orders from Member me where me.id=(:id)")
  List<Order> findAllOrders(@Param("id") Long id);

  /*
    주문회원 . 로그인 아이디로 조회하기
    1. 회원의 로그인 아이디로 select 해서 회원의 id(autoincrement 값)를 알아낸다.
    2. 그 아이디 값을 가지고 있는 orders 정보를 조회한다.
    3. member 정보를 출력한다.
    group by 가 있으면 값을 한개만 받아올 수 있는데... 그러면 주문 건 수를 찾을 수가 없다
   mysql workbench 에서는 count(*) 하면 주문 건수를 알수 있고 출력값도 제어할 수 있는데 여긴 뭐
   힘드네?
   */
  @Query(value = "select new com.holidaysomething.holidaysomething.dto.OrderMemberDto(me, count(me)) from Member as me left join ORDERS as o on (me.id=o.member) where o.member in (select me.id from Member as me where me.loginId=(:loginId)) group by me.id")
  List<OrderMemberDto> findMembersInOrders(@Param("loginId") String loginId);


  @Query(value = "select new com.holidaysomething.holidaysomething.dto.OrderMemberDto(me, count(me)) from Member as me left join ORDERS as o on (me.id=o.member) where o.member in (select me.id from Member as me where me.name=(:name)) group by me.id")
  List<OrderMemberDto> findMembersByNameInOrders(@Param("name") String name);


//  @Query(value="select me.orders from Member me, ORDERS o where o.member.id=(:memberId)")
//  List<Order> getMembersByOrderPeriod(@Param("loginId") Long memberId);

}

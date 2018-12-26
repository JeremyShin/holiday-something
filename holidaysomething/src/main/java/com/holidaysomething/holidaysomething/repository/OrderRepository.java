package com.holidaysomething.holidaysomething.repository;

import com.holidaysomething.holidaysomething.domain.Member;
import com.holidaysomething.holidaysomething.domain.Order;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderRepository extends JpaRepository<Order, Long> {

  //멤버가 주문한 정보 검색
  Order findByMemberId(Long memberId);

  // 주문기간으로 회원 조회.
//  @Query(value="select me from Order as o inner join o.member me where me.loginId=(:loginId)")
//  Page<Member> getMembersByOrderPeriod(@Param("loginId") String loginId);

//  @Query(value="select me from Order as o inner join o.member me where me.loginId=() ")
//  Page<Member> getMembersByOrderPeriod(@Param("startDate") LocalDateTime startDate, @Param("endDate")LocalDateTime endDate);


}

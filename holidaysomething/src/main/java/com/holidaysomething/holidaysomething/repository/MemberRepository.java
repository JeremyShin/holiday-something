package com.holidaysomething.holidaysomething.repository;

import com.holidaysomething.holidaysomething.domain.Member;
import com.holidaysomething.holidaysomething.dto.CurrentMemberDto;
import com.holidaysomething.holidaysomething.repository.custom.MemberRepositoryCustom;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {

  // member search all
  Page<Member> findAll(Pageable pageable);

  // Page<member> search by loginId
  Page<Member> findMembersByLoginId(String loginId, Pageable pageable);

  // member search by loginId
  Member findMemberByLoginId(String loginId);

  // 주문 페이지에서 member search by id
  Member findMemberById(Long id);

  @Query(value = "SELECT new com.holidaysomething.holidaysomething.dto.CurrentMemberDto"
      + "(m.id, m.name, m.nickname, m.mileage, o.id, "
      + "o.orderNumber, o.date, o.totalPrice, p.id, p.name, pi.path) "
      + "FROM Member as m"
      + "    INNER JOIN ORDERS as o ON m.id = o.member.id"
      + "    INNER JOIN OrderedProduct as op ON o.id = op.order.id"
      + "    INNER JOIN Product as p ON op.product.id = p.id"
      + "    INNER JOIN ProductImage as pi ON p.id = pi.product.id "
      + "WHERE m.id = (:userId)")
  List<CurrentMemberDto> findCurrentMember(@Param("userId") Long userId);

  // 멤버를 등록합시다.
  Member save(Member member);
}
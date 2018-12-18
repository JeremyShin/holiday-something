package com.holidaysomething.holidaysomething.repository;

import com.holidaysomething.holidaysomething.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

public interface MemberRepository extends JpaRepository<Member, String> {

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
    @Query(value="select me from Member me where me.loginId=(:loginId)")
    Member findByIdContaining(@Param("loginId") String loginId);
}

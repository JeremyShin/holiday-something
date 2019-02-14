//package com.holidaysomething.holidaysomething.repository;
//
//import com.holidaysomething.holidaysomething.domain.Member;
//import com.holidaysomething.holidaysomething.domain.Product;
//import com.holidaysomething.holidaysomething.dto.MemberSearchDto;
//import com.holidaysomething.holidaysomething.repository.custom.MemberRepositoryCustom;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.format.annotation.DateTimeFormat;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.transaction.annotation.Transactional;
//
//@Transactional
//@Rollback
//@Slf4j
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class MemberDslTest {
//  @Autowired
//  private MemberRepository memberRepository;
//
////  @Test
////  public void 멤버검색() throws Exception {
////    Pageable pageable = PageRequest.of(0, 30);
////
////    Page<Member> members = memberRepository.searchMembers("memberId", "o", pageable);
////
////    for (Member member : members) {
////      log.info(member.getId().toString());
////      log.info(member.getLoginId());
////      log.info(member.getName());
////      log.info("미선 DSL TEST ==============================");
////    }
////  }
//
//  @DateTimeFormat
//  @Test
//  public void 회원() throws Exception{
//    LocalDateTime ldt1 = LocalDateTime.of(2018, 11, 22, 00, 00, 00);
//    LocalDateTime ldt2 = LocalDateTime.of(2018, 12, 31, 00, 00, 00);
//    LocalDate ld1 = LocalDate.of(1990, 01, 01);
//    LocalDate ld2 = LocalDate.of(1995, 11, 22);
//    List<String> sexCheck = new ArrayList<>();
////    sexCheck.add("남성");
////    sexCheck.add("여성");
////    sexCheck.add("기타");
//
////    log.info("미선 DSL TEST ==============================");
////    MemberSearchDto memberSearchDto = new MemberSearchDto();
//////    memberSearchDto.setSearchClassificationValue("memberId");
//////    memberSearchDto.setSearchClassificationInput("o");
//////    memberSearchDto.setBirthdayStart(ld1.toString());
//////    memberSearchDto.setBirthdayEnd(ld2.toString());
////    memberSearchDto.setOrderDateStart(ld1.toString());
////    memberSearchDto.setOrderDateEnd(ld2.toString());
//////    memberSearchDto.setRegDateStart();
////    memberSearchDto.setRegDateEnd();
////    memberSearchDto.setSexCheck();
//
//
//
//
//    Pageable pageable = PageRequest.of(0, 30);
////    Page<Member> members = memberRepository.searchMembers(memberSearchDto,  pageable);
//
//    log.info("성별의 개수 :" + members.getTotalElements());
//
//    for (Member member : members) {
//      log.info(member.getId().toString());
//      log.info(member.getLoginId());
//      log.info(member.getName());
//      log.info(member.getBirthday().toString());
//    }
//
//  }
//}

package com.holidaysomething.holidaysomething.controller.user;

import com.holidaysomething.holidaysomething.domain.Member;
import com.holidaysomething.holidaysomething.service.member.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
public class UserRestController {

  private MemberService memberService;

  public UserRestController(
      MemberService memberService) {
    this.memberService = memberService;
  }

  @GetMapping("/user")
  @CrossOrigin(origins = "http://localhost:3000")
  public Member getCurrentUserInfo(@RequestParam("id") long userId) {
    return memberService.getCurrentMemberInfo(userId);
  }
}

package com.holidaysomething.holidaysomething.controller.user.member;

import com.holidaysomething.holidaysomething.domain.Member;
import com.holidaysomething.holidaysomething.security.MemberUserDetails;
import com.holidaysomething.holidaysomething.service.member.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Gyumin Kim
 * @since 2019-02-24
 */
@Slf4j
@RestController
@RequestMapping(path = "/api/user",
                produces = "application/json")
@CrossOrigin(origins = "*")
public class MemberRestController {

  private MemberService memberService;

  public MemberRestController(
      MemberService memberService) {
    this.memberService = memberService;
  }

  /**
   * 테스트용: user의 id를 매개변수로 받아 해당 user(member)의 모든 정보를 가져온다.
   * (실제 배포 시에는 로그인 정보를 Authentication으로 받아와서 조회)
   */
  @GetMapping("/{id}")
  public ResponseEntity<Member> getCurrentUserInfo(@PathVariable Long id) {
    Member member = memberService.getCurrentMemberInfo(id);
    if (member != null) {
      return new ResponseEntity<>(member, HttpStatus.OK);
    }
    return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
  }

  /**
   * 현재 로그인 되어있는 user 정보를 받아온다.
   */
  @GetMapping("/authenticated")
  public Member getAuthenticatedUser(Authentication authentication) {

    if (authentication == null) {
      log.info("No authenticated user.");
      return null;
    }

    MemberUserDetails memberUserDetails = (MemberUserDetails) authentication.getPrincipal();
    Long id = memberUserDetails.getId();

    return memberService.getCurrentMemberInfo(id);
  }

  /**
   * 회원정보 수정: mypage 회원정보 수정 > 입력한 필드(ex. email)에 한해 정보 수정
   */
  @PatchMapping(path = "/account", consumes = "application/json")
  public ResponseEntity<Member> patchMember(Authentication authentication,
      @RequestBody Member patch) {
    MemberUserDetails memberUserDetails = (MemberUserDetails) authentication.getPrincipal();
    Long id = memberUserDetails.getId();
    Member member = memberService.getCurrentMemberInfo(id);
    if (member == null) {
      return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    if (patch.getPassword() != null) {
      member.setPassword(patch.getPassword());
    }
    if (patch.getEmail() != null) {
      member.setEmail(patch.getEmail());
    }
    if (patch.getPhone() != null) {
      member.setPhone(patch.getPhone());
    }
    if (patch.getBirthday() != null) {
      member.setBirthday(patch.getBirthday());
    }
    if (patch.getPostcode() != null) {
      member.setPostcode(patch.getPostcode());
    }
    if (patch.getAddress1() != null) {
      member.setAddress1(patch.getAddress1());
    }
    if (patch.getAddress2() != null) {
      member.setAddress2(patch.getAddress2());
    }

    return new ResponseEntity<>(member, HttpStatus.OK);
  }
}

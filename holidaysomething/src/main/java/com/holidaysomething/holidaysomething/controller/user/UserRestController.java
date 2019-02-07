package com.holidaysomething.holidaysomething.controller.user;

import com.holidaysomething.holidaysomething.domain.Member;
import com.holidaysomething.holidaysomething.dto.AuthenticatedMemberDto;
import com.holidaysomething.holidaysomething.dto.CurrentMemberDto;
import com.holidaysomething.holidaysomething.security.MemberUserDetails;
import com.holidaysomething.holidaysomething.service.member.MemberService;
import java.security.Principal;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(path = "/api",
                produces = "application/json")
@CrossOrigin(origins = "*")
public class UserRestController {

  private MemberService memberService;

  public UserRestController(MemberService memberService) {
    this.memberService = memberService;
  }

  /**
   * user의 id를 매개변수로 받아 해당 user(member)의 모든 정보를 가져온다.
   */
  @GetMapping("/userTmp")
  public ResponseEntity<Member> getCurrentUserInfo(@RequestParam("id") long userId) {
    Member member = memberService.getCurrentMemberInfo(userId);
    if (member != null) {
      return new ResponseEntity<>(member, HttpStatus.OK);
    }
    return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
  }

  /**
   * id를 통해 CurrentMemberDto 객체가 제대로 리턴되지만,
   * order -> orderNumber -> ... 으로 계속 방향을 진행하는 것이 불가능해
   * id로 Member 객체를 얻고 Q객체의 방향성을 이용하는 getCurrentUserInfo()를 사용하기로 했다.
   */
  @GetMapping("/user/recentOrder")
  public List<CurrentMemberDto> getCurrentUserInfo(@RequestParam("id") Long userId) {
    return memberService.getCurrentMemberInfoJPQL(userId);
  }

  /**
   * 현재 로그인 되어있는 user 정보를 받아온다.
   */
  @GetMapping("/user/authenticated")
  public Member getAuthenticatedUser(Authentication authentication) {

    if (authentication == null) {
      log.info("No authenticated user.");
      return null;
    }
    MemberUserDetails memberUserDetails = (MemberUserDetails) authentication.getPrincipal();

    log.info("AuthenticatedUser - id: " + memberUserDetails.getId());
    log.info("AuthenticatedUser - username: " + memberUserDetails.getUsername());
    log.info("AuthenticatedUser - nickname: " + memberUserDetails.getNickname());
    log.info("AuthenticatedUser - member-Id: " + memberUserDetails.getMember().getId());
    log.info("AuthenticatedUser - member-LoginId: " + memberUserDetails.getMember().getLoginId());
    log.info("AuthenticatedUser - member-Name: " + memberUserDetails.getMember().getName());
    log.info("AuthenticatedUser - member-Password: " + memberUserDetails.getMember().getPassword());

    // Member 객체 이외에 추가 정보를 포함한 DTO를 리턴하려 했었는데, 막상 구현하다보니 그 추가 정보가 무엇인지 잘 모르겠다.
//    AuthenticatedMemberDto authenticatedMember = new AuthenticatedMemberDto();
//    authenticatedMember.setMember(memberUserDetails.getMember());
//    return authenticatedMember;

    return memberUserDetails.getMember();
  }

  /**
   * 회원정보 수정: 현재 로그인 되어있는 member의 property 중 null이 아닌 것들을 실제 data에 반영
   */
//  @PatchMapping(path = "/user", consumes = "application/json")
//  public Member patchMember(Authentication authentication,
//                            @RequestBody Member patch) {

//    MemberUserDetails memberUserDetails = (MemberUserDetails) authentication.getPrincipal();
//    Member member = memberUserDetails.getMember();
  @PatchMapping(path = "/user/{id}", consumes = "application/json")
  public Member patchMember(@PathVariable("id") Long memberId,
      @RequestBody Member patch) {
    log.info("patch Email: " + patch.getEmail());

    Member member = memberService.getCurrentMemberInfo(memberId);

    if (patch.getId() != null) {
      member.setId(patch.getId());
    }
    if (patch.getLoginId() != null) {
      member.setLoginId(patch.getLoginId());
    }
    if (patch.getPassword() != null) {
      member.setPassword(patch.getPassword());
    }
    if (patch.getEmail() != null) {
      member.setEmail(patch.getEmail());
    }
    if (patch.getName() != null) {
      member.setName(patch.getName());
    }
    if (patch.getNickname() != null) {
      member.setNickname(patch.getNickname());
    }
    if (patch.getPhone() != null) {
      member.setPhone(patch.getPhone());
    }
    if (patch.getMileage() != null) {
      member.setMileage(patch.getMileage());
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
    if (patch.getSex() != null) {
      member.setSex(patch.getSex());
    }
    if (patch.getOrders() != null) {
      member.setOrders(patch.getOrders());
    }

    return memberService.patchMember(member);
  }
}

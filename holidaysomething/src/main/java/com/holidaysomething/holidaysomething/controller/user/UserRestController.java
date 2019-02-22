package com.holidaysomething.holidaysomething.controller.user;

import com.holidaysomething.holidaysomething.domain.Member;
import com.holidaysomething.holidaysomething.security.MemberUserDetails;
import com.holidaysomething.holidaysomething.service.member.MemberService;
import com.holidaysomething.holidaysomething.service.product.CartProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(path = "/api",
                produces = "application/json")
@CrossOrigin(origins = "*")
public class UserRestController {

  private MemberService memberService;
  private CartProductService cartProductService;

  public UserRestController(
      MemberService memberService,
      CartProductService cartProductService) {
    this.memberService = memberService;
    this.cartProductService = cartProductService;
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
   * 현재 로그인 되어있는 user 정보를 받아온다.
   */
  @GetMapping("/user/authenticated")
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
  @PatchMapping(path = "/user/account", consumes = "application/json")
  public ResponseEntity<Member> patchMember(Authentication authentication,
                            @RequestBody Member patch) {
    MemberUserDetails memberUserDetails = (MemberUserDetails) authentication.getPrincipal();
    Long id = memberUserDetails.getId();
    Member member = memberService.getCurrentMemberInfo(id);
    if (member == null) {
      return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

//    if (patch.getId() != null) {
//      member.setId(patch.getId());
//    }
//    if (patch.getLoginId() != null) {
//      member.setLoginId(patch.getLoginId());
//    }
    if (patch.getPassword() != null) {
      member.setPassword(patch.getPassword());
    }
    if (patch.getEmail() != null) {
      member.setEmail(patch.getEmail());
    }
//    if (patch.getName() != null) {
//      member.setName(patch.getName());
//    }
//    if (patch.getNickname() != null) {
//      member.setNickname(patch.getNickname());
//    }
    if (patch.getPhone() != null) {
      member.setPhone(patch.getPhone());
    }
//    if (patch.getMileage() != null) {
//      member.setMileage(patch.getMileage());
//    }
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
//    if (patch.getSex() != null) {
//      member.setSex(patch.getSex());
//    }
//    if (patch.getOrders() != null) {
//      member.setOrders(patch.getOrders());
//    }

//    return memberService.patchMember(member);
    return new ResponseEntity<>(member, HttpStatus.OK);
  }

  /**
   * cart 내의 특정 상품을 cart에서 삭제
   */
  @DeleteMapping("/user/cart/{cartProductId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteCartProduct(@PathVariable("cartProductId") Long id) {
    try {
      cartProductService.removeCartProductById(id);
    } catch (EmptyResultDataAccessException e) {
      e.printStackTrace();
    }
  }
}

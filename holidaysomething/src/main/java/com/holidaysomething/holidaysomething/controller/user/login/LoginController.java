package com.holidaysomething.holidaysomething.controller.user.login;

import com.holidaysomething.holidaysomething.domain.Member;
import com.holidaysomething.holidaysomething.domain.Role;
import com.holidaysomething.holidaysomething.security.MemberUserDetails;
import com.holidaysomething.holidaysomething.service.member.MemberService;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author choijaeyong on 18/01/2019.
 * @project holidaysomething
 * @description
 */

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/user")
public class LoginController {

  private final MemberService memberService;

  private final BCryptPasswordEncoder passwordEncoder;

  @GetMapping("/login")
  public String loginForm() {

    return "user/login/login-form";
  }


  @PostMapping("/add")
  public String addMember() {
    Member member = new Member();
    member.setLoginId("koola97620");
    member.setPassword("1234");
    //member.setPassword(passwordEncoder.encode("1234"));
    //log.info("============== passwordEncoder.encode 후 : " + member.getPassword());
    //log.info("======= 확인 : " + passwordEncoder.matches("1234",member.getPassword()));

    member.setEmail("koola976@gmail.com");
    member.setName("최재용");
    member.setNickname("JD");
    member.setPhone("01099233293");
    member.setPostcode("POSTCODE");
    member.setAddress1("address1");
    member.setAddress2("address2");
    member.setRegDate(LocalDateTime.now());
    member.setLastLogin(LocalDateTime.now());
    member.setReceiveEmail(false);
    member.setReceiveSms(false);
    member.setMarketing(false);
    member.setPersonalInfo(false);
    member.setSex("없음.");

    Role role1 = new Role();
    role1.setId(1l);
    role1.setName("ADMIN");
    memberService.addRole(role1);
    log.info("======== role1  등록.");

    Role role2 = new Role();
    role2.setId(2l);
    role2.setName("USER");
    memberService.addRole(role2);
    log.info("======== role2  등록.");

    Set<Role> roleSet = new HashSet<>();
    roleSet.add(role1);
    roleSet.add(role2);
    member.setRoles(roleSet);
    Date today = new Date();
    member.setBirthday(today);

    memberService.addMember(member);

    return "redirect:/user/login";
  }


  @GetMapping("/info")
  public String loginInfo(Principal principal) {
    System.out.println(principal.getName());

    MemberUserDetails loginUser =
        (MemberUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    System.out.println(loginUser.getNickname());
    System.out.println(loginUser.getId());
    System.out.println(loginUser.getUsername());
    return "user/login/login-info";
  }

}

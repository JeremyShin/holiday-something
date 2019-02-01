package com.holidaysomething.holidaysomething.controller.user.login;

import com.holidaysomething.holidaysomething.domain.Member;
import com.holidaysomething.holidaysomething.domain.Role;
import com.holidaysomething.holidaysomething.security.MemberUserDetails;
import com.holidaysomething.holidaysomething.service.member.MemberService;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * @author choijaeyong on 18/01/2019.
 * @project holidaysomething
 * @description
 */

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserLoginController {

  private final MemberService memberService;

  private final BCryptPasswordEncoder passwordEncoder;

  @GetMapping("/login")
  public String loginForm(HttpSession httpSession) {
    if (httpSession.getAttribute("LOGINUSER") != null) {
      log.info("==== 이미 로그인유저 세션이 있으면(로그인되어 있는 상태라면)!?");
      log.info("자바스크립트에서 alert 창 띄어서 로그인 중입니다. 라고 알려주는 것도 고려중.");
      return "redirect:/";
    }

    return "user/login/login-form";
  }


  /**
   * @author JDragon 회원 가입이 아직 미구현 상태라. 임시로 만들었음.
   */
  @PostMapping("/add")
  public String addMember() {
    // 운영자 아이디는 디비에 1234 로 저장되어 있고
    // 실제 고객이 이용하는건 인코딩 해서 저장해야한다.

    Member member = new Member();
    member.setLoginId("koola97620");
    member.setPassword("1234");
    member.setPassword(passwordEncoder.encode("1234"));
    log.info("============== passwordEncoder.encode 후 : " + member.getPassword());
    log.info("======= 확인 : " + passwordEncoder.matches("1234", member.getPassword()));

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

//    Role role1 = new Role();
//    role1.setId(1l);
//    role1.setName("ADMIN");
//    memberService.addRole(role1);
//    log.info("======== role1  등록.");

    Role role2 = new Role();
    role2.setId(2l);
    role2.setName("USER");
    memberService.addRole(role2);
    log.info("======== role2  등록.");

    Set<Role> roleSet = new HashSet<>();
    //roleSet.add(role1);
    roleSet.add(role2);
    member.setRoles(roleSet);
    //LocalDate로 바꾸면서 안들어감 ㅠㅠ
//    Date today = new Date();
//    member.setBirthday(today);
    LocalDate birthday = LocalDate.parse("1991-01-31");
    member.setBirthday(birthday);


    memberService.addMember(member);

    return "redirect:/";
  }


  /**
   * @author JDragon
   * 로그인 했을 때, 아이디가 root 이면 해당 url 호출.
   */
  @GetMapping("/after")
  public String loginInfo(Principal principal, HttpSession httpSession) {
    log.info("======= loginInfo 메소드 안.");
    // 로그인 이후에 나타나는 페이지.
    // admin 권한이 있으면 back-or-user 페이지를 뜨게 하고
    // admin 없으면 바로 메인 페이지 or 이전 페이지 뜨게 하고. 싶은데...
    // 여기에서 설정하니 안된다. successHandler 에서 건드려봐야겠다.
//    log.info(" principal.getName() : " + principal.getName());
//    if(principal.getName().equals("root")) {
//      return "user/login/back-or-user";
//    }

    // .... csrf disable 하니까. 이것도 안된다. 뭐지? 진짜 이유를 모르겠네.
//    MemberUserDetails loginUser =
//        (MemberUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//    log.info("loginUser.getNickname() : " + loginUser.getNickname());
//    log.info("loginUser.getId() : " + loginUser.getId());
//    log.info("loginUser.getUsername() : " + loginUser.getUsername());

//    null 값 나온다.
//    log.info("member.getId() : "+member.getId());
//    log.info("member.getRoles() : "+member.getRoles());
//    log.info("member.getNickname() : "+member.getNickname());

    log.info("httpSession.getId() : " + httpSession.getId());
    log.info("httpSession.getAttribute() : " + httpSession.getAttribute("LOGINUSER"));
    log.info("httpSession.getMaxInactiveInterval() : " + httpSession.getMaxInactiveInterval());

    return "user/login/back-or-user";
  }


  @GetMapping("/temp")
  public String tempMethod(HttpSession httpSession, ModelMap model) {
    if (httpSession.getAttribute("LOGINUSER") == null) {
      log.info("======================== 세션 null");
    }

    // 로그아웃하고 이 메소드가 실행되면
    // httpSession.getAttribute("LOGINUSER")) 가 null값이 나온다.
    log.info("====================tempMethod");
    log.info("httpSession.getId() : " + httpSession.getId());
    log.info("httpSession.getAttribute() : " + httpSession.getAttribute("LOGINUSER"));
    log.info("httpSession.getMaxInactiveInterval() : " + httpSession.getMaxInactiveInterval());

    // logout 상태에서 하면 오류난다. NullPointerException!
    // getAttribute 할게 없어서 그런듯.
    MemberUserDetails member = (MemberUserDetails) httpSession.getAttribute("LOGINUSER");
    log.info("======= member.getId() :  " + member.getId());
    log.info("======= member.getNickname() :  " + member.getNickname());
    log.info("======= member.getUsername() :  " + member.getUsername());

    // login 과정에서 session.setAttribute 해주면 여기에서도 자유롭게 꺼내 쓸 수 있다.

    // 위에 HttpSession 을 쓰는 것과. 아래처럼 저렇게 값을 가져오는거랑. 출력값은 똑같다.
    // 그럼 무슨 방법을 써야 하는거지?
    MemberUserDetails loginUser =
        (MemberUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    log.info("loginUser.getNickname() : " + loginUser.getNickname());
    log.info("loginUser.getId() : " + loginUser.getId());
    log.info("loginUser.getUsername() : " + loginUser.getUsername());

    model.addAttribute("id", member.getId());
    model.addAttribute("username", member.getUsername());
    model.addAttribute("nickname", member.getNickname());
    log.info("======= httpSession.getCreationTime() : " + httpSession.getCreationTime());
    log.info("=======  httpSession.getLastAccessedTime() : " + httpSession.getLastAccessedTime());

    //log.info("******** loginUser.getMember().getOrders().size() : "+ loginUser.getMember().getOrders().size());

    return "user/temp";
  }

//  @ExceptionHandler(NoHandlerFoundException.class)

  /*@ExceptionHandler(UsernameNotFoundException.class)
  public String LoginIdNotSuitedException() {
    //@RequestParam(value = "msg") String msg



    return "/user/login?error=true";
  }*/

  @GetMapping("/info")
  public String showInfo(@RequestParam("userId") String userId) {

    return "user/login/login-info";
  }


}

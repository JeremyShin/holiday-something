package com.holidaysomething.holidaysomething.security;

import java.io.IOException;
import java.security.Principal;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

/**
 * @author choijaeyong on 19/01/2019.
 * @project holidaysomething
 * @description
 */
@Slf4j
public class AuthSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

  public AuthSuccessHandler(String defaultTargetUrl) {
    setDefaultTargetUrl(defaultTargetUrl);
  }

  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
      Authentication authentication) throws ServletException, IOException {
    HttpSession session = request.getSession();
    log.info("============ session : " + session);
    log.info("============ session : " + session.getId());
    log.info("authentication.getPrincipal() : " + authentication.getPrincipal());
    log.info("authentication.getAuthorities().size() : " + authentication.getAuthorities().size());
    // 아래 결과에도 세션이 포함되어 있는데 . 이 세션과 위에 세션 아이디가 다르다.
    // 차이가 뭘까.
    log.info("authentication.getDetails() : " + authentication.getDetails());

    MemberUserDetails principal = (MemberUserDetails) authentication.getPrincipal();
    log.info("principal.getName() : " + principal.getId());
    log.info("principal.getName() : " + principal.getNickname());
    log.info("principal.getName() : " + principal.getUsername());

    if (principal.getUsername().equals("root")) {
      log.info("root니까 이전페이지 말고 유저,백오피스 선택할 수 있는 페이지로 갈게!");
      session.setAttribute("LOGINUSER", principal);
      getRedirectStrategy().sendRedirect(request, response, "/user/after");
      return;
    } else {
      log.info("root 외의 유저.   / 로 가즈아.");
      session.setAttribute("LOGINUSER", principal);
      getRedirectStrategy().sendRedirect(request, response, "/");
      return;
    }

//    if (session != null) {
//      String redirectUrl = (String) session.getAttribute("prevPage");
//      if (redirectUrl != null) {
//        session.removeAttribute("prevPage");
//        getRedirectStrategy().sendRedirect(request, response, redirectUrl);
//      } else {
//        super.onAuthenticationSuccess(request, response, authentication);
//      }
//    } else {
//      super.onAuthenticationSuccess(request, response, authentication);
//    }
  }

}

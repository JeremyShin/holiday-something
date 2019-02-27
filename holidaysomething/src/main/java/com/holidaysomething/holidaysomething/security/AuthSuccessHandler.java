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

    MemberUserDetails principal = (MemberUserDetails) authentication.getPrincipal();

    if (principal.getUsername().equals("root")) {
      session.setAttribute("LOGINUSER", principal);
      session.setMaxInactiveInterval(1500);
      getRedirectStrategy().sendRedirect(request, response, "/");
    } else {
      session.setAttribute("LOGINUSER", principal);
      session.setMaxInactiveInterval(1500);
      getRedirectStrategy().sendRedirect(request, response, "/");
    }
  }

}

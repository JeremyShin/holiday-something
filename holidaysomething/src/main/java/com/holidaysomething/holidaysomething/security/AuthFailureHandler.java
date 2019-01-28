package com.holidaysomething.holidaysomething.security;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.web.servlet.FlashMap;

/**
 * @author choijaeyong on 19/01/2019.
 * @project holidaysomething
 * @description
 */

@Slf4j
public class AuthFailureHandler extends SimpleUrlAuthenticationFailureHandler {


  @Override
  public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
      AuthenticationException exception) throws IOException, ServletException {

    log.info("============= exception.getMessage() : " + exception.getMessage());
    //request.setAttribute("errMsg",exception.getMessage());

    HttpSession session = request.getSession();
    session.setAttribute("errMsg", exception.getMessage());

//    FlashMap fm = new FlashMap();
//    fm.put("errMsg",exception.getMessage());
//    fm.setTargetRequestPath("/user/login?error=true");

    getRedirectStrategy().sendRedirect(request, response, "/user/login?error=true&err2");

    //super.onAuthenticationFailure(request, response, exception);
  }
}

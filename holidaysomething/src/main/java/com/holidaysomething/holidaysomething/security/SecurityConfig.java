package com.holidaysomething.holidaysomething.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * @author choijaeyong on 18/01/2019.
 * @project holidaysomething
 * @description forbidden(403) 에러시 봐야할 곳. 1. Ajax 로 post 전송 할 때, forbidden 오류가 날 수 있다. 그때 ajax 메소드
 * 안에 headers: {'X-CSRF-Token': $('input[name="_csrf"]').val()} 추가해주면 된다.
 *
 * 2. root로 로그인을 하지 않고 /admin/** 로 접근하면 forbidden 에러가 난다.
 */

//@EnableAutoConfiguration
@EnableWebSecurity
@Configuration
@Slf4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  //private final UserDetailsService userDetailsService;

//  private final BCryptPasswordEncoder passwordEncoder;

//  @Bean
//  public static PasswordEncoder passwordEncoder() {
//    return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//  }

  @Bean
  public UserDetailsService userDetailsService() {
    return new UserDetailsServiceImpl();
  }

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    //BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    return new BCryptPasswordEncoder();
  }

  @Bean
  public AuthenticationSuccessHandler successHandler() {
    return new AuthSuccessHandler("/");  // default로 이동할 url
  }

  @Bean
  public AuthFailureHandler failureHandler() {
    return new AuthFailureHandler();
  }

  // 세션 동시에 몇개 존재할 수 있게 할건지 정하는 빈?? baeldung
  // 추가하니까 계속 403 에러 난다...
//  @Bean
//  public HttpSessionEventPublisher httpSessionEventPublisher() {
//    return new HttpSessionEventPublisher();
//  }

  /*
    인증에 대한 처리를 아예 무시할 경로를 설정.
    ex> http://localhost:8080/logo.gif
    AntPathRequestMatcher : ant 문법으로 path를 지정. ant :빌드도구
    /css/** , /js/**, /images/**, /webjars/**, ** /favicon.ico
     */

  @Override
  public void configure(WebSecurity web) throws Exception {
//    web.ignoring()
//        .antMatchers(
//            "/resources/**",
//            "/static/**", "/css/**", "/js/**", "/img/**", "/webjars/**");

    web.ignoring()
        .requestMatchers(PathRequest.toStaticResources().atCommonLocations())
        .requestMatchers(new AntPathRequestMatcher("/**.html"))
        .requestMatchers(new AntPathRequestMatcher("/static/**"));

  }

  /*
    http://localhost:8080/logout - 로그아웃처리
    http://localhost:8080/ - 모두 접근가능
    http://localhost:8080/admin/** - admin권한 사용자만 접근 가능.
    http://localhost:8080/members/login - 아무나 접근할 수 있다.
    http://localhost:8080/admin/** - member권한 사용자만 접근 가능
    GET http://localhost:8080/members/login - 로그인 화면
     */

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    log.info("=================== 성공 ");

    // .antMatchers("/admin/**").hasRole("ADMIN") 와 같은 특정 조건이 위로 와야되나보다...?
    http.authorizeRequests()
        .antMatchers("/admin/**").hasRole("ADMIN")
//        .antMatchers("/user/after").hasRole("ADMIN")
        .antMatchers("/**").permitAll();
//          .antMatchers("/user/add").permitAll()
//          .antMatchers("/user/login").permitAll()

//        .access("hasRole('ADMIN')");
//        .anyRequest().fullyAuthenticated();
    //.antMatchers("/members/**").hasRole("USER")
    // .authenticated() 로그인시에만 해당 페이지로 접근 가능하도록 막을때 사용.

    http
        .formLogin()
        .loginPage("/user/login")
        .loginProcessingUrl("/user/authenticate")
        .usernameParameter("loginId").passwordParameter("password")
//        .defaultSuccessUrl("/user/after")
        .successHandler(successHandler()) // 로그인 이전 페이지로 이동할때 사용.
//        .failureHandler(failureHandler());
        .failureUrl("/user/login?error=true");

    http.csrf().disable();

    /*
    예외처리??? 로그인 id, password 입력 글자수 제한은 정규표현식 이용해서 프론트에서도
    한번 막아줄거고. 백엔드에서 어떻게 해야할까?
    로그인 아이디 형식은 맞는데 db에 회원이 없을 경우는 예외처리가 되어있다.
    근데 입력된 로그인 아이디 형식이 범위에 어긋나면. 틀린 형식 입니다 메시지를 화면에 보여주고
    싶은데....

    1. successHandler 에서 throw 예외처리를 해주면?? 끝?
    2. failureHandler() 에서 설정...? 근데 뭐가 오류인지 전달받는게 없으면 처리를 못하지 않나?
    3. failureUrl로 처리? /user/login 에 파라미터 추가해주고... 아 아닌듯.
     */



//    http.sessionManagement()
//        .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);
//
//    // 같은 유저가 만들 수 있는 세션의 수??
//    http.sessionManagement().maximumSessions(5);
//
//    http.sessionManagement()
//        .sessionFixation().migrateSession();

    http
        .logout()
        .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
        .logoutSuccessUrl("/")
        .invalidateHttpSession(true) // logout 시 모든 세션을 없애주는건가?
        .deleteCookies("JSESSIONID") // remember me?? 쿠키 삭제하는것도 써줘야할듯.
        .permitAll();

    http
        .rememberMe()
        .key("uniqueAndSecret")
        .rememberMeParameter("remember-me")
        .tokenValiditySeconds(70000);
    // key 는 토큰의 내용을 생성할 때 사용한다는데....? 뭔말인지....?
    // 기본값은 2주인데 여기서 바꿀 수 있다.

    log.info("======= 끝");

  }


  // auth 에 UserDetailsService를 등록하고 인코더를 등록.
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    log.info("======= AuthenticationManagerBuilder");
    auth
        .userDetailsService(userDetailsService())
        .passwordEncoder(passwordEncoder());
  }

//  @Bean
//  public DaoAuthenticationProvider authenticationProvider() {
//    DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//    authenticationProvider.setUserDetailsService(userDetailsService);
//    authenticationProvider.setPasswordEncoder(passwordEncoder());
//    return authenticationProvider;
//  }
}

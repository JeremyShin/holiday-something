package com.holidaysomething.holidaysomething.security;

import com.holidaysomething.holidaysomething.domain.Member;
import com.holidaysomething.holidaysomething.domain.Role;
import com.holidaysomething.holidaysomething.service.member.MemberService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author choijaeyong on 18/01/2019.
 * @project holidaysomething
 * @description
 */
@Slf4j
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private MemberService memberService;

  @Autowired
  private BCryptPasswordEncoder passwordEncoder;


  @Override
  @Transactional(readOnly = true)
  public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {

    // 여기서 로그인폼에서 넘어온 데이터 유효성검사를 해야 할 것 같다!
    log.info("====== loginId : " + loginId);
//    Pattern pattern = Pattern.compile("^[a-zA-Z0-9]{3,20}$");
//    Matcher matcher = pattern.matcher(loginId);
//    if(!matcher.find()) {
//      log.info("====== loginId error  ");
//      throw new BadCredentialsException(loginId + " is not type. please a~z,3~20");
//    }

    Member member = memberService.findMemberByLoginId(loginId);

    log.info("==== member : " + member);
    if (member == null) {
      log.info("==== null");
      throw new UsernameNotFoundException(loginId + " is not found");
    }

    log.info("===== member.getId : " + member.getId());
    log.info("===== member.getLoginId : " + member.getLoginId());
    log.info("===== member.getRoles.size : " + member.getRoles().size());

    Collection<GrantedAuthority> authorities = new ArrayList<>();
    for (Role role : member.getRoles()) {
      log.info("====== role.getName() : " + role.getName());
      authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
    }

    log.info("====== member.getPassword : " + member.getPassword());

    // root는 현재 기본으로 등록되어 있는 회원(관리자계정으로 쓸거)이다.
    // db에 1234로 저장되어 있기 때문에 여기서 encode 해서 암호화 문자로 바꿔줘야 한다.
    // 그리고 User 객체 생성.
    // 새로 등록하는 계정(메인에서 버튼 클릭)은 계정 생성할때부터 암호화 작업이 진행되게
    // 해놨기 때문에 root 와 다르게 처리해줘야한다.
    // 결론: 관리자 테스트 : root, 일반유저 테스트 : 메인에서 버튼클릭으로 만드는 계정
    if (loginId.equals("root")) {
      String encodePassword = passwordEncoder.encode(member.getPassword());
      log.info("====== root encodePassword : " + encodePassword);
      member.setPassword(encodePassword);
    }

//    String encodePassword = passwordEncoder.encode(member.getPassword());
//    log.info("====== encodePassword : " + encodePassword);

    MemberUserDetails userDetails = new MemberUserDetails(loginId, member.getPassword(),
        authorities);
    userDetails.setNickname(member.getNickname());
    userDetails.setId(member.getId());
    userDetails.setMember(member);

    log.info("====== userDetails.getMember().getId() : " + userDetails.getMember().getId());
    log.info(
        "====== userDetails.getMember().getNickname() : " + userDetails.getMember().getNickname());
    log.info(
        "====== userDetails.getMember().getLoginId() : " + userDetails.getMember().getLoginId());
    //log.info("====== userDetails.getMember().getOrders().size() : " + userDetails.getMember().getOrders().size());


    return userDetails;
  }
}

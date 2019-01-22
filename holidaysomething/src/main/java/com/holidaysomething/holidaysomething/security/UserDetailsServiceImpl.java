package com.holidaysomething.holidaysomething.security;

import com.holidaysomething.holidaysomething.domain.Member;
import com.holidaysomething.holidaysomething.domain.Role;
import com.holidaysomething.holidaysomething.service.member.MemberService;
import java.util.ArrayList;
import java.util.Collection;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    return userDetails;
  }
}

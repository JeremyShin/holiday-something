package com.holidaysomething.holidaysomething.security;

import com.holidaysomething.holidaysomething.domain.Member;
import com.holidaysomething.holidaysomething.domain.Role;
import com.holidaysomething.holidaysomething.service.member.MemberService;
import java.util.ArrayList;
import java.util.Collection;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author choijaeyong on 18/01/2019.
 * @project holidaysomething
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

    if (member == null) {
      throw new UsernameNotFoundException(loginId + " is not found");
    }

    Collection<GrantedAuthority> authorities = new ArrayList<>();
    for (Role role : member.getRoles()) {
      authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
    }

    if (loginId.equals("root")) {
      String encodePassword = passwordEncoder.encode(member.getPassword());
      member.setPassword(encodePassword);
    }

    MemberUserDetails userDetails = new MemberUserDetails(loginId, member.getPassword(),
        authorities);
    userDetails.setNickname(member.getNickname());
    userDetails.setId(member.getId());
    userDetails.setMember(member);

    //TODO: 아래 문장을 실행하지 않으면, lazy loading이어서 member에 order 정보가 포함되지 않은 채로 MemberUserDetails 객체가 리턴된다.
    //TODO: 그럼 eager loading(?)으로 바꿔서, 여기서 order 정보를 member에 포함한 채로 넘겨주면 해결되지 않을까?
//    log.info(userDetails.getMember().getOrders().size() + "");

    return userDetails;
  }
}

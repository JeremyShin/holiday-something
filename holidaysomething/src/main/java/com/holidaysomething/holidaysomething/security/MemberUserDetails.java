package com.holidaysomething.holidaysomething.security;

import com.holidaysomething.holidaysomething.domain.Member;
import java.util.Collection;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 * @author choijaeyong on 18/01/2019.
 * @project holidaysomething
 * @description
 */
@Getter
@Setter
public class MemberUserDetails extends User {


  private String nickname;
  private Long id;
  private Member member;

  public MemberUserDetails(String loginId, String password,
      Collection<? extends GrantedAuthority> authorities) {
    super(loginId, password, true, true, true, true, authorities);
  }

  @Override
  public String getUsername() {
    return super.getUsername();
  }

  @Override
  public boolean isEnabled() {
    return super.isEnabled();
  }

  @Override
  public boolean isAccountNonExpired() {
    return super.isAccountNonExpired();
  }

  @Override
  public boolean isAccountNonLocked() {
    return super.isAccountNonLocked();
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return super.isCredentialsNonExpired();
  }
}

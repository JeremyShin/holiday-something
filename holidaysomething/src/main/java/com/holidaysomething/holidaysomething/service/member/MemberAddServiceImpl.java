package com.holidaysomething.holidaysomething.service.member;

import com.holidaysomething.holidaysomething.domain.Member;
import com.holidaysomething.holidaysomething.domain.Role;
import com.holidaysomething.holidaysomething.dto.MemberAddDto;
import com.holidaysomething.holidaysomething.repository.MemberRepository;
import com.holidaysomething.holidaysomething.repository.RoleRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberAddServiceImpl implements MemberAddService {

  private final MemberRepository memberRepository;
  private final RoleRepository roleRepository;

  private final BCryptPasswordEncoder passwordEncoder;

  @Override
  @Transactional
  public Member memberRegister(MemberAddDto memberAddDto) {

    Member member = new Member();

    member.setLoginId(memberAddDto.getLoginId());
    member.setPassword(passwordEncoder.encode(memberAddDto.getPassword()));
    member.setEmail(memberAddDto.getEmail());
    member.setName(memberAddDto.getName());
    member.setNickname(memberAddDto.getNickname());
    member.setPhone(memberAddDto.getPhone());
    member.setBirthday(LocalDate.parse(memberAddDto.getBirthday()));
    member.setPostcode(memberAddDto.getPostcode());
    member.setAddress1(memberAddDto.getAddress1());
    member.setAddress2(memberAddDto.getAddress2());
    member.setReceiveEmail(memberAddDto.isReceiveEmail());
    member.setReceiveSms(memberAddDto.isReceiveSms());
    member.setMarketing(memberAddDto.isMarketing());
    member.setPersonalInfo(memberAddDto.isPersonalInfo());
    member.setRecommender(memberAddDto.getRecommender());
    member.setSex(memberAddDto.getSex());
    member.setRegDate(LocalDateTime.now());
    member.setLastLogin(LocalDateTime.now());

    // 가입하는 회원에게 USER 권한 부여해주기.
    Set<Role> roleSet = new HashSet<>();

    Role userRole = memberRegisterLoadUserRole(2L);
    roleSet.add(userRole);
    member.setRoles(roleSet);

    memberRepository.save(member);

    return member;
  }

  @Override
  @Transactional
  public Role memberRegisterLoadUserRole(long id) {
    // Role 테이블에 1 : ADMIN 2: USER
    return roleRepository.getOne(2L);
  }
}

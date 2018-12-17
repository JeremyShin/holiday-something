package com.holidaysomething.holidaysomething.JDragon.repositoryTest;


import com.holidaysomething.holidaysomething.domain.Member;
import com.holidaysomething.holidaysomething.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
public class MemberTest {

  @Autowired
  MemberRepository memberRepository;

  @Test
  public void 사용자정보loginId로읽어들이기() throws Exception {
    Member member = memberRepository.findByIdContaining("root");

    System.out.println("=====================================");
    System.out.println(member.getId());
    System.out.println(member.getEmail());
    System.out.println(member.getName());
    System.out.println(member.getBirthday());
    System.out.println("=====================================");

  }
}

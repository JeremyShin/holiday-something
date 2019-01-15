package com.holidaysomething.holidaysomething.repository;

import com.holidaysomething.holidaysomething.domain.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.assertj.core.util.DateUtil.now;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberJoinTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void 회원가입이되는지볼까() {
        Member m = new Member();

        m.setAddress1("서울시 중구 퇴계로");
        m.setAddress1("12345");
        m.setBirthday(now());
        m.setEmail("jonmattang@gmail.com");
        m.setLastLogin(LocalDateTime.of(2018, 01, 01, 18, 00));
        m.setLoginId("joan");
        m.setMarketing(true);
        m.setMileage(0);
        m.setName("존맛탱");
        m.setNickname("mattaeng-e");
        m.setPassword("1234");
        m.setPersonalInfo(false);
        m.setPhone("010-0011-0101");
        m.setPostcode("06344");
        m.setReceiveEmail(true);
        m.setReceiveSms(false);
        m.setRegDate(LocalDateTime.of(2018, 02, 01, 00, 00, 00));
        m.setSex("남성");

    }
}

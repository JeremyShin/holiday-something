package com.holidaysomething.holidaysomething.service;

import com.holidaysomething.holidaysomething.JDragon.serviceTest.ProductServiceTest;
import com.holidaysomething.holidaysomething.domain.Member;
import com.holidaysomething.holidaysomething.dto.MemberAddDto;
import com.holidaysomething.holidaysomething.service.member.MemberAddService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberJoinTest {

    private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager
            .getLogger(ProductServiceTest.class);

    @Autowired
    private MemberAddService memberAddService;

    @Test
    public void 회원가입하기테스트() {
        MemberAddDto m = new MemberAddDto();

        m.setAddress1("서울시 중구 퇴계로");
        m.setAddress2("12345");
//        m.setBirthday(LocalDate.of(2000, 01, 01));
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

        Member insertedMember = memberAddService.memberRegister(m);

        log.info("==============================");
        log.info(insertedMember.getBirthday());
        log.info(insertedMember.getLoginId());
        log.info(insertedMember.getEmail());

    }

}

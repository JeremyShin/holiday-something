package com.holidaysomething.holidaysomething.service.member;

import com.holidaysomething.holidaysomething.domain.Member;
import com.holidaysomething.holidaysomething.dto.MemberAddDto;
import com.holidaysomething.holidaysomething.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberAddServiceImpl implements MemberAddService{
    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public Member memberRegister(MemberAddDto memberAddDto) {

        //DTO에 데이터를 담자
        Member member = new Member();

        member.setLoginId(memberAddDto.getLoginId());
        member.setPassword(memberAddDto.getPassword());
        member.setEmail(memberAddDto.getEmail());
        member.setName(memberAddDto.getName());
        member.setNickname(memberAddDto.getNickName());
        member.setPhone(memberAddDto.getPhone());
        member.setBirthday(memberAddDto.getBirthday());
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

        //save메소드 사용해서 insert하기
        memberRepository.save(member);

        return member;
    }
}

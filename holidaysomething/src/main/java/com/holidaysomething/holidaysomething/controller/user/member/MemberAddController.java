package com.holidaysomething.holidaysomething.controller.user.member;

import com.holidaysomething.holidaysomething.domain.Member;
import com.holidaysomething.holidaysomething.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
@Slf4j
@RequiredArgsConstructor
public class MemberAddController {

    private final MemberService memberService;

    @GetMapping("/join")
    public String memberAdd(ModelMap model) {

        Member member = new Member();
        model.addAttribute("member", member);


        return "/user/join";
    }
}

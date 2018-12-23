package com.holidaysomething.holidaysomething.controller.admin;

import com.holidaysomething.holidaysomething.service.MemberService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/member")
public class AdminMemberController {
    private static final Log log = LogFactory.getLog(AdminMemberController.class);
//    private MemberService memberService;
//
//    public AdminMemberController(MemberService memberService){
//        this.memberService = memberService;
//    }

    @GetMapping("/mileage/search")
    public String mileageSearch(@PageableDefault(sort = {"loginId"}, size = 10)Pageable pageable,
                                @ModelAttribute("search")MemberSearch memberSearch, ModelMap modelMap){
        return "/admin/member/mileage_search";
    }
}

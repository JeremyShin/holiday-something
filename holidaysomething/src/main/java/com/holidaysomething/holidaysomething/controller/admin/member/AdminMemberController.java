package com.holidaysomething.holidaysomething.controller.admin.member;


import com.holidaysomething.holidaysomething.domain.Member;
import com.holidaysomething.holidaysomething.dto.Search;
import com.holidaysomething.holidaysomething.service.MemberService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/member")
public class AdminMemberController {

  private static final Log log = LogFactory
      .getLog(
          com.holidaysomething.holidaysomething.controller.admin.member.AdminMemberController.class);

  private MemberService memberService;

  public AdminMemberController(MemberService memberService) {
    this.memberService = memberService;
  }

  @GetMapping("/order/search")
  public String memberOrderSearch() {

    return "admin/member/member_order";
  }


  @GetMapping("/mileage/search")
  public String mileageSearch(@PageableDefault(sort = {"loginId"}, size = 10) Pageable pageable,
      @ModelAttribute("search") Search search, ModelMap modelMap) {
    Page<Member> members = memberService.findAllOrSearch(search, pageable);
    modelMap.addAttribute("members", members);

    return "/admin/member/mileage_search";
  }



}


/*

181222

주문회원 조회 : 주문기간, 주문번호, 이름/아이디 검색.
 */
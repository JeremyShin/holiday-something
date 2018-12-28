package com.holidaysomething.holidaysomething.controller.admin.member;


import com.holidaysomething.holidaysomething.domain.Member;
import com.holidaysomething.holidaysomething.dto.OrderMemberDto;
import com.holidaysomething.holidaysomething.dto.Search;
import com.holidaysomething.holidaysomething.dto.SearchOrderMember;
import com.holidaysomething.holidaysomething.service.MemberService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

  @PostMapping("/order/search")
  public String memberOrderSearchPost(
      @ModelAttribute(value = "SearchOrderMember") SearchOrderMember searchOrderMember,
      @RequestParam(value = "date1") @DateTimeFormat(pattern = "MMddyyyy") StringBuffer date1,
      @RequestParam(value = "date1") @DateTimeFormat(iso = ISO.DATE) StringBuffer date2) {

    System.out.println(searchOrderMember.getName());
    System.out.println(searchOrderMember.getLoginId());
    System.out.println(searchOrderMember.getProductName());
    System.out.println(searchOrderMember.getOrderNumber());
    System.out.println(date1);
    System.out.println(date2);
    date1.append("T00:00:00");
    date2.append("T23:59:59");
    System.out.println(date1);
    System.out.println(date2);

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    searchOrderMember.setOrderStartDate(LocalDateTime.parse(date1));
    searchOrderMember.setOrderEndDate(LocalDateTime.parse(date2));

    System.out.println(searchOrderMember.getOrderStartDate());
    System.out.println(searchOrderMember.getOrderEndDate());

    return "redirect:/admin/member/order/search";
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
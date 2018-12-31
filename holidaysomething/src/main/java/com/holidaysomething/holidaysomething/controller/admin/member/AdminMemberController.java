package com.holidaysomething.holidaysomething.controller.admin.member;


import com.holidaysomething.holidaysomething.domain.Member;
import com.holidaysomething.holidaysomething.dto.MemberMileageForm;
import com.holidaysomething.holidaysomething.dto.Search;
import com.holidaysomething.holidaysomething.dto.SearchOrderMember;
import com.holidaysomething.holidaysomething.service.MemberService;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/member")
@Slf4j
@RequiredArgsConstructor
public class AdminMemberController {

  private final MemberService memberService;

  @GetMapping("/order/search")
  public String memberOrderSearch() {

    return "admin/member/member_order";
  }

  @PostMapping("/order/search")
  public String memberOrderSearchPost(
      @ModelAttribute(value = "SearchOrderMember") SearchOrderMember searchOrderMember,
      @RequestParam(value = "date1") @DateTimeFormat(pattern = "MMddyyyy") StringBuffer date1,
      @RequestParam(value = "date1") @DateTimeFormat(iso = ISO.DATE) StringBuffer date2) {

    log.info(searchOrderMember.getName());
    log.info(searchOrderMember.getLoginId());
    log.info(searchOrderMember.getProductName());
    log.info(searchOrderMember.getProductCode());
    log.info("TAG", date1);
    log.info("TAG", date2);

    date1.append("T00:00:00");
    date2.append("T23:59:59");
    log.info("TAG", date1);
    log.info("TAG", date2);

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    searchOrderMember.setOrderStartDate(LocalDateTime.parse(date1));
    searchOrderMember.setOrderEndDate(LocalDateTime.parse(date2));

    log.info("TAG", searchOrderMember.getOrderStartDate());
    log.info("TAG", searchOrderMember.getOrderEndDate());

    return "redirect:/admin/member/order/search";
  }


  @GetMapping("/mileage/search")
  public String mileageSearch(@PageableDefault(sort = {"loginId"}, size = 10) Pageable pageable,
      @ModelAttribute("search") Search search, ModelMap modelMap) {
    Page<Member> members = memberService.findAllOrSearch(search, pageable);
    modelMap.addAttribute("members", members);

    return "/admin/member/mileage_search";
  }

  @GetMapping("/mileage/modify")
  public String mileageModify(@RequestParam("loginId")String loginId, ModelMap modelMap){

    modelMap.addAttribute("member", memberService.findMemberByLoginId(loginId));

    return "/admin/member/mileage_modify_form";
  }

  @PostMapping("/mileage/modify")
  public String mileageModifyPost(@ModelAttribute("mileageModify")MemberMileageForm memberMileageForm){

    if(memberMileageForm.getMileage() < 0){
      return "redirect:/";
    }

    memberService.updateMember(memberMileageForm);

    return "redirect:/admin/member/mileage/search";
  }
}


/*

181222

주문회원 조회 : 주문기간, 주문번호, 이름/아이디 검색.
 */
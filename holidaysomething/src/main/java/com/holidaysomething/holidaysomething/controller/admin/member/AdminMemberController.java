package com.holidaysomething.holidaysomething.controller.admin.member;

import com.holidaysomething.holidaysomething.domain.Member;
import com.holidaysomething.holidaysomething.dto.MemberMileageDto;
import com.holidaysomething.holidaysomething.dto.SearchDto;
import com.holidaysomething.holidaysomething.dto.SearchOrderMemberDto;
import com.holidaysomething.holidaysomething.service.member.MemberService;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
@Slf4j
@RequiredArgsConstructor
public class AdminMemberController {

  private final MemberService memberService;

  @GetMapping("/order/search")
  public String memberOrderSearch() {
    return "admin/member/order";
  }

  @PostMapping("/order/search")
  public String memberOrderSearchPost(
      @ModelAttribute(value = "SearchOrderMember") SearchOrderMemberDto searchOrderMemberDto,
      @RequestParam(value = "date1") @DateTimeFormat(pattern = "MMddyyyy") StringBuffer date1,
      @RequestParam(value = "date1") @DateTimeFormat(iso = ISO.DATE) StringBuffer date2) {

    log.info(searchOrderMemberDto.getName());
    log.info(searchOrderMemberDto.getLoginId());
    log.info(searchOrderMemberDto.getProductName());
    log.info("TAG", date1);
    log.info("TAG", date2);

    date1.append("T00:00:00");
    date2.append("T23:59:59");
    log.info("TAG", date1);
    log.info("TAG", date2);

//    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    searchOrderMemberDto.setOrderStartDate(LocalDateTime.parse(date1));
    searchOrderMemberDto.setOrderEndDate(LocalDateTime.parse(date2));

    log.info("TAG", searchOrderMemberDto.getOrderStartDate());
    log.info("TAG", searchOrderMemberDto.getOrderEndDate());

    return "redirect:/admin/member/order/search";
  }

  @GetMapping("/mileage/search")
  public String mileageSearch(@PageableDefault(sort = {"loginId"}, size = 10) Pageable pageable,
      @ModelAttribute("search") SearchDto searchDto, ModelMap modelMap) {

    Page<Member> members = memberService.findAllOrSearch(searchDto, pageable);
    modelMap.addAttribute("members", members);

    return "/admin/member/mileage-search";
  }

  @GetMapping("/mileage/modify")
  public String mileageModify(@RequestParam("loginId") String loginId, ModelMap modelMap) {

    modelMap.addAttribute("member", memberService.findMemberByLoginId(loginId));

    return "/admin/member/mileage-modify";
  }

  @PostMapping("/mileage/modify")
  public String mileageModifyPost(
      @ModelAttribute("mileageModify") MemberMileageDto memberMileageDto) {

    if (memberMileageDto.getMileage() < 0) {
      return "redirect:/";
    }

    memberService.updateMember(memberMileageDto);

    return "redirect:/admin/member/mileage/search";
  }

  @GetMapping("/search")
  public String memberSearch(){
    return "admin/member/search";
  }

  @PostMapping("/search")
  public String memberSearchPost(
      @RequestParam(value = "memberSearchClassificationValue", required = false) String searchClassificationValue,
      @RequestParam(value = "memberSearchClassificationInput", required = false) String searchClassificationInput,
      @RequestParam(value = "memberBirthdayStart", required = false) String birthdayStart,
      @RequestParam(value = "memberBirthdayEnd", required = false) String birthdayEnd,
      @RequestParam(value = "memberRegDateStart", required = false) String regDateStart,
      @RequestParam(value = "memberRegDateEnd", required = false) String regDateEnd){

    log.info("searchClassificationValue" + searchClassificationValue);
    log.info("memberSearchClassificationInput" + searchClassificationInput);
    log.info("미선memberBirthdayStart" + birthdayStart);
    log.info("미선memberBirthdayStart" + birthdayEnd);

    Pageable pageable = PageRequest.of(0, 5);

    Page<Member> members = memberService.searchMembers(searchClassificationValue, searchClassificationInput, birthdayStart, birthdayEnd, regDateStart, regDateEnd, pageable);

    for (Member member : members){
      log.info(member.getBirthday().toString());
      log.info(member.getId().toString());
    }

    return "redirect:/admin/member/search";
  }
}
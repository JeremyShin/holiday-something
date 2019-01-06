package com.holidaysomething.holidaysomething.controller.admin.member;

import com.holidaysomething.holidaysomething.domain.Member;
import com.holidaysomething.holidaysomething.dto.MemberMileageDto;
import com.holidaysomething.holidaysomething.dto.OrderMemberDto;
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


  // 검색 조건 입력시 endDate가 더 미래여야 한다.
  @PostMapping("/order/search")
  public String memberOrderSearchPost(
      @ModelAttribute(value = "SearchOrderMember") SearchOrderMemberDto searchOrderMemberDto,
      @RequestParam(value = "date1", required = false) @DateTimeFormat(pattern = "MMddyyyy") String date1,
      @RequestParam(value = "date2", required = false) @DateTimeFormat(iso = ISO.DATE) String date2,
      ModelMap model) {

    /*
      date1 , date2 가 stringbuffer 이면 null 도 아니고 "" 도 아니고.처음부터 capacity가 16이다...
      뭐지????
     */

    log.info(searchOrderMemberDto.getName());
    log.info(searchOrderMemberDto.getLoginId());
    log.info(searchOrderMemberDto.getProductName());
    log.info("date1 : " + date1 + "    date1.capacity = " + date1.length());
    log.info("date2 : " + date2 + "    date1.capacity = " + date2.length());

    if (!date1.equals("") && !date2.equals("")) {
      date1 += "T00:00:00";
      date2 += "T23:59:59";
      //date1.append("T00:00:00");
      //date2.append("T23:59:59");
      log.info("date1 : " + date1);
      log.info("date2 : " + date2);
      searchOrderMemberDto.setOrderStartDate(LocalDateTime.parse(date1));
      searchOrderMemberDto.setOrderEndDate(LocalDateTime.parse(date2));
      log.info("searchDto : " + searchOrderMemberDto.getOrderStartDate());
      log.info("searchDto : " + searchOrderMemberDto.getOrderEndDate());
    } else if (date1.equals("") && date2.equals("")) {
      log.info("==================== 날짜 빈칸!");
    }



//    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    Pageable pageable = pageable = PageRequest.of(0, 5);
    ;
    Page<OrderMemberDto> orderMemberDtoPage = memberService.findMembersBySearchingInQuerydsl(
        searchOrderMemberDto, pageable);

    log.info("=============== orderMemberDtoPage : " + orderMemberDtoPage.getTotalElements());

    model.addAttribute("orderMemberDtoPage", orderMemberDtoPage);

    return "/admin/member/order";
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
}
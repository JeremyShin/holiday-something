package com.holidaysomething.holidaysomething.controller.admin.member;

import com.holidaysomething.holidaysomething.domain.Member;
import com.holidaysomething.holidaysomething.dto.MemberMileageDto;
import com.holidaysomething.holidaysomething.dto.MemberSearchDto;
import com.holidaysomething.holidaysomething.dto.SearchDto;
import com.holidaysomething.holidaysomething.dto.SearchOrderMemberDto;
import com.holidaysomething.holidaysomething.service.member.MemberService;
import java.time.LocalDateTime;
import java.util.List;
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
import org.springframework.web.bind.annotation.RequestBody;
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
//
//  @GetMapping("/search")
//  public String memberSearch(){
//    return "admin/member/search";
//  }

  @GetMapping("/search")
  public String memberSearch(ModelMap modelMap, @ModelAttribute MemberSearchDto memberSearchDto,
      @RequestParam(value = "page", defaultValue = "1")int page){
    log.info("getSearchClassificationInput" + memberSearchDto.getMemberSearchClassificationInput());
    log.info("getSearchClassificationValue" + memberSearchDto.getMemberSearchClassificationValue());
    log.info("getBirthdayStart" + memberSearchDto.getMemberBirthdayStart());
    log.info("getBirthdayEnd" + memberSearchDto.getMemberBirthdayEnd());
    log.info("getOrderDateStart" + memberSearchDto.getMemberOrderDateStart());
    log.info("getOrderDateEnd" + memberSearchDto.getMemberOrderDateEnd());
    log.info("getRegDateStart" + memberSearchDto.getMemberRegDateStart());
    log.info("getRegDateEnd" + memberSearchDto.getMemberRegDateEnd());


    if (memberSearchDto.hasValue()) {
      Pageable pageable = PageRequest.of(page - 1 , 5);
      Page<Member> memberList = memberService.searchMembers(memberSearchDto, pageable);
      int memberPageCount = memberList.getTotalPages();

      log.info("memberPageCountㅋㅋㅋ" + memberPageCount);

      log.info("으아아아아아아아아");
      log.info("컨트롤러로 넘어온 Member의 개수는" + memberList.getTotalElements());

      for (Member member : memberList) {
        log.info(member.getBirthday().toString());
        log.info(member.getId().toString());
      }



      log.info("멤버검색 총 개수는 : " + memberList.getTotalElements() + "개 이다.");

      modelMap.addAttribute("memberList", memberList);
      modelMap.addAttribute("memberPageCount", memberPageCount);
    }


    return "admin/member/search";
  }
}
package com.holidaysomething.holidaysomething.controller.admin.member;

import com.holidaysomething.holidaysomething.domain.Member;
import com.holidaysomething.holidaysomething.dto.MemberMileageDto;
import com.holidaysomething.holidaysomething.dto.MemberSearchDto;
import com.holidaysomething.holidaysomething.dto.OrderMemberDto;
import com.holidaysomething.holidaysomething.dto.SearchDto;
import com.holidaysomething.holidaysomething.dto.SearchOrderMemberDto;
import com.holidaysomething.holidaysomething.service.member.MemberService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
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

  @GetMapping
  public String member() {
    return "admin/member/index";
  }

  /**
   * @param searchOrderMemberDto input 검색 데이터를 담기 위한 Dto
   * @author JDragon
   */
  @GetMapping("/order/search")
  public String memberOrderSearchPost(
      @Valid @ModelAttribute(value = "SearchOrderMemberDto") SearchOrderMemberDto searchOrderMemberDto,
      BindingResult bindingResult,
      ModelMap model, @PageableDefault(size = 5) Pageable pageable) {

    if (bindingResult.hasErrors()) {
      for (ObjectError error : bindingResult.getAllErrors()) {
        log.info(error.getDefaultMessage());
      }
      return "admin/member/order";
    }
    else {
      if (!searchOrderMemberDto.isEmpty()) {
        Page<OrderMemberDto> orderMemberDtoPage = memberService.findMembersBySearchingInQuerydsl(
            searchOrderMemberDto, pageable);
        model.addAttribute("orderMemberDtoPage", orderMemberDtoPage);
      }
      return "admin/member/order";
    }
  }

  /**
   * 마일리지 조회
   */
  @GetMapping("/mileage/search")
  public String mileageSearch(@PageableDefault(sort = {"loginId"}) Pageable pageable,
          @ModelAttribute("search") SearchDto searchDto, ModelMap modelMap) {

    Page<Member> members = memberService.findAllOrSearch(searchDto, pageable);
    modelMap.addAttribute("members", members);

    return "admin/member/mileage-search";
  }

  /**
   * 마일리지 수정 페이지로 이동
   */
  @GetMapping("/mileage/modify")
  public String mileageModify(@RequestParam("loginId") String loginId, ModelMap modelMap) {

    modelMap.addAttribute("member", memberService.findMemberByLoginId(loginId));

    return "admin/member/mileage-modify";
  }

  /**
   * 마일리지 수정
   */
  @PostMapping("/mileage/modify")
  public String mileageModifyPost(
      @Valid @ModelAttribute("mileageModify") MemberMileageDto memberMileageDto,
      BindingResult bindingResult) {

    if (bindingResult.hasErrors() || !memberMileageDto.isPossible()) {
      for (ObjectError error : bindingResult.getAllErrors()) {
        log.info(error.getDefaultMessage());
      }
      return "redirect:/admin";
    } else {
      memberService.updateMember(memberMileageDto);
      return "redirect:/admin/member/mileage/search";
    }
  }

  /**
   * 회원 마일리지 조회
   */
  @GetMapping("/search")
  public String memberSearch(ModelMap modelMap, @ModelAttribute MemberSearchDto memberSearchDto,
      @RequestParam(value = "page", defaultValue = "1") int page) {

    if (memberSearchDto.hasValue()) {
      Pageable pageable = PageRequest.of(page - 1, 5);
      Page<Member> memberList = memberService.searchMembers(memberSearchDto, pageable);
      int memberPageCount = memberList.getTotalPages();

      modelMap.addAttribute("memberList", memberList);
      modelMap.addAttribute("memberPageCount", memberPageCount);
    }
    return "admin/member/search";
  }
}


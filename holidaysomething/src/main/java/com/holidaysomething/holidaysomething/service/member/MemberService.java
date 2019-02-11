package com.holidaysomething.holidaysomething.service.member;

import com.holidaysomething.holidaysomething.domain.CartProduct;
import com.holidaysomething.holidaysomething.domain.Member;
import com.holidaysomething.holidaysomething.domain.Role;
import com.holidaysomething.holidaysomething.dto.CurrentMemberDto;
import com.holidaysomething.holidaysomething.dto.MemberMileageDto;
import com.holidaysomething.holidaysomething.dto.MemberSearchDto;
import com.holidaysomething.holidaysomething.dto.SearchDto;
import com.holidaysomething.holidaysomething.dto.UserCartProductDto;
import java.util.List;
import com.holidaysomething.holidaysomething.dto.OrderMemberDto;
import com.holidaysomething.holidaysomething.dto.SearchOrderMemberDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MemberService {

  Member findMemberByLoginId(String loginId);

  Member getCurrentMemberInfo(Long userId);

  List<CurrentMemberDto> getCurrentMemberInfoJPQL(Long userId);

  void updateMember(MemberMileageDto memberMileageDto);

  Member patchMember(Member member);

  Page<Member> findAllOrSearch(SearchDto searchDto, Pageable pageable);

  Page<Member> searchMembers(MemberSearchDto memberSearchDto, Pageable pageable);
  
  Page<OrderMemberDto> findMembersBySearchingInQuerydsl(
      SearchOrderMemberDto searchOrderMemberDto, Pageable pageable);

  /************** User *************/
  void addMember(Member member);

  // 나중에 불필요.테스트용으로 만드는거.
  void addRole(Role role);

  List<UserCartProductDto> getUserCartProduct(Long userId);
}

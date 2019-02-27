package com.holidaysomething.holidaysomething.dto;

import com.holidaysomething.holidaysomething.config.SearchOrderMemberConstraint;
import lombok.Data;

/**
 * member/order.html 에서 입력한 폼 데이터(검색용)를 전송하기 위해 설계된 클래스.
 */
@Data
public class SearchOrderMemberDto {

  @SearchOrderMemberConstraint(regexp = "^[가-힣a-zA-Z0-9]{2,20}$", message = "회원 로그인 아이디 2~20자의 한(자음만 입력 불가),영,숫자로 입력하셔야 합니다.\"")
  private String loginId;

  @SearchOrderMemberConstraint(regexp = "^[가-힣a-zA-Z0-9]{2,20}$", message = "회원 이름 2~20자의 한(자음만 입력 불가),영,숫자로 입력하셔야 합니다.")
  private String name;

  @SearchOrderMemberConstraint(regexp = "^[가-힣a-zA-Z0-9]{2,20}$", message = "상품이름은 2~20자의 한(자음만 입력 불가),영,숫자로 입력하셔야 합니다.")
  private String productName;

  @SearchOrderMemberConstraint(regexp = "^[가-힣a-zA-Z0-9]{2,20}$", message = "주문번호 2~20자의 한(자음만 입력 불가),영,숫자로 입력하셔야 합니다.")
  private String orderNumber;

  private String orderStartDate;

  private String orderEndDate;

  public boolean isEmpty() {
    return loginId == null && name == null && orderNumber == null && productName == null
        && orderStartDate == null && orderEndDate == null;
  }
}
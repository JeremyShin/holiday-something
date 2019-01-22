package com.holidaysomething.holidaysomething.dto;


import com.holidaysomething.holidaysomething.config.SearchOrderMemberConstraint;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.annotation.Nullable;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Data;
import net.bytebuddy.implementation.bind.annotation.Empty;
import org.springframework.format.annotation.DateTimeFormat;


/**
 * member/order.html 에서 입력한 폼 데이터(검색용)를 전송하기 위해 설계된 클래스.
 *
 */

@Data
public class SearchOrderMemberDto {

  @SearchOrderMemberConstraint(regexp = "^[가-힣a-zA-Z0-9]{2,20}$", message = "회원 로그인 아이디 2~20자의 한(자음만 입력 불가),영,숫자로 입력하셔야 합니다.\"")
  private String loginId;

  @SearchOrderMemberConstraint(regexp = "^[가-힣a-zA-Z0-9]{2,20}$", message = "회원 이름 2~20자의 한(자음만 입력 불가),영,숫자로 입력하셔야 합니다.")
  private String name;

  //@Pattern(regexp="\\S{2,6}", message="상품이름은 2~6자로 입력해주세요.")
  //@Size(min = 2, max = 20, message = "1~10자로 입력해주세요.")
  @SearchOrderMemberConstraint(regexp = "^[가-힣a-zA-Z0-9]{2,20}$", message = "상품이름은 2~20자의 한(자음만 입력 불가),영,숫자로 입력하셔야 합니다.")
  private String productName;

  @SearchOrderMemberConstraint(regexp = "^[가-힣a-zA-Z0-9]{2,20}$", message = "주문번호 2~20자의 한(자음만 입력 불가),영,숫자로 입력하셔야 합니다.")
  private String orderNumber;




  private String orderStartDate;

  //@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
  //@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private String orderEndDate;


  public boolean isEmpty() {
    if (loginId == null && name == null && orderNumber == null && productName == null
        && orderStartDate == null && orderEndDate == null) {
      return true;
    }
    return false;
  }
}
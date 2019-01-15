package com.holidaysomething.holidaysomething.config;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author JDragon on 15/01/2019.
 * @project holidaysomething
 * @description 기존의 Size 및 Pattern Annotation 을 이용하면 해당 필드에 해당하는 * input에 값을 반드시 입력해야만 한다. * 반드시
 * 입력하지 않아도 되게 방지? 해주는 역할을 하는 annotation!
 */
public class SearchOrderMemberValidator implements
    ConstraintValidator<SearchOrderMemberConstraint, String> {

  private String regExp;

  @Override
  public void initialize(SearchOrderMemberConstraint constraintAnnotation) {
    this.regExp = constraintAnnotation.regexp();

  }

  @Override
  public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

    System.out.println("============== valid! " + s);
    Pattern pattern = Pattern.compile(regExp);

    // 처음 요청에서는 ModelAttribute 객체가 비어있는 상태다.
    // false 를 반환할때! 인터페이스에 정의해놓은 디폴트 메시지가 출력된다.
    // 처음 요청은 비어있는 상태인데. 이때 if(s==null) return true; 를
    // 해주지 않으면 첫 요청부터 에러메시지가 출력된다.
    if (s == null) {
      return true;
    }

    if (s != null) {
      System.out.println("null 이 아니다.");
      // 검색조건에 아무것도 입력하지 않아도 null 상태는 아니다. 그냥 "" 상태??다.
      // 그래서 null 은 아니기에 해당 if 문으로 들어오게 된다.
      // null은 아니지만 비어있는? 값이 객체에 있으면. 무시하게 한다.
      if (s.length() == 0) {
        return true;
      }

      // 검색하고자 하는 문자열이 정확하게 입력된 경우!
      Matcher matcher = pattern.matcher(s);
      if (matcher.find()) {
        System.out.println("정확한 검색 문자열!");
        return true;
      } else {
        System.out.println("문자열 이긴 한데. 정규표현식에 의해 걸러진 문자열!!!!!!");
        return false;
      }
    }

//    if(s == null) {
//      System.out.println("================================ null이다.");
//      return true;
//    }else {
//      System.out.println("============== null이 아니다.");
//    }

    return false;
  }
}

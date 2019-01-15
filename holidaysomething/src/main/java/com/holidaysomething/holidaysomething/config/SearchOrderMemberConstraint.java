package com.holidaysomething.holidaysomething.config;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * @author JDragon on 15/01/2019.
 * @project holidaysomething
 * @description 기존의 Size 및 Pattern Annotation 을 이용하면 해당 필드에 해당하는 input에 값을 반드시 입력해야만 한다. 반드시 입력하지
 * 않아도 되게 방지? 해주는 역할을 하는 annotation!
 */
@Documented
@Constraint(validatedBy = SearchOrderMemberValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SearchOrderMemberConstraint {

  String regexp();

  String message() default "com.holidaysomething.holidaysomething.config.SearchOrderMemberValidator";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
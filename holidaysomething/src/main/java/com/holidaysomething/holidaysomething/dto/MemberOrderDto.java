package com.holidaysomething.holidaysomething.dto;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MemberOrderDto {
  @NotNull(message = "email must not be null")
  private String email;

  @NotNull(message = "phone must not be null")
  private String phone;

  @NotNull(message = "name must not be null")
  private String name;

  @NotNull(message = "address1 must not be null")
  private String address1;

  @NotNull(message = "address2 must not be null")
  private String address2;

  @NotNull(message = "postcode must not be null")
  private String postcode;

  @NotNull(message = "mileage must not be null")
  private int mileage;
}

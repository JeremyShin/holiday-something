package com.holidaysomething.holidaysomething.dto;

import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class AddOrderMemberDto {
  @NotNull(message = "email must not be null")
  private String email;
  @NotNull(message = "phone must not be null")
  private String phone;
  @NotNull(message = "name must not be null")
  private String name;
}

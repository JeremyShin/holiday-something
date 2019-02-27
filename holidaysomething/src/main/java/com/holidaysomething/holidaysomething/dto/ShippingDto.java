package com.holidaysomething.holidaysomething.dto;

import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class ShippingDto {
  @NotNull
  private String orderRecipientNameInput;

  @NotNull
  private String orderRecipientPhoneInput;

  @NotNull
  private String orderRecipientPostcodeInput;

  @NotNull
  private String orderRecipientAddress1Input;

  @NotNull
  private String orderRecipientAddress2Input;

  @NotNull
  private String orderRecipientMessageInput;

  @NotNull
  private Integer orderTotalShippingPrice;
}

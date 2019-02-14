package com.holidaysomething.holidaysomething.dto;

import com.holidaysomething.holidaysomething.domain.ProductOption;
import java.util.List;

public class ProductOrderInfoCommand {
  private List<ProductOrderInfoDto> productOrderInfoDtos;

  public List<ProductOrderInfoDto> getProductOrderInfoDtos() {
    return productOrderInfoDtos;
  }

  public void setProductOrderInfoDtos(List<ProductOrderInfoDto> productOrderInfoDtos) {
    this.productOrderInfoDtos = productOrderInfoDtos;
  }
}

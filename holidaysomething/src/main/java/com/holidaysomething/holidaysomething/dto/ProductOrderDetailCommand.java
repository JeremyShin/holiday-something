package com.holidaysomething.holidaysomething.dto;

import java.util.List;

public class ProductOrderDetailCommand {
  private List<ProductOrderDetailDto> productOrderDetailDtos;

  public List<ProductOrderDetailDto> getProductOrderDetailDtos() {
    return productOrderDetailDtos;
  }

  public void setProductOrderDetailDtos(
      List<ProductOrderDetailDto> productOrderDetailDtos) {
    this.productOrderDetailDtos = productOrderDetailDtos;
  }
}

package com.holidaysomething.holidaysomething.dto;

import com.holidaysomething.holidaysomething.domain.ProductOption;
import java.util.List;

public class ProductOptionCommand {

  private List<ProductOption> productOptions;

  public List<ProductOption> getProductOptions() {
    return productOptions;
  }

  public void setProductOptions(List<ProductOption> productOptions) {
    this.productOptions = productOptions;
  }
}

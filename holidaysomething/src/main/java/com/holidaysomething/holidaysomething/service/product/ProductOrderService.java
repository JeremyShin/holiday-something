package com.holidaysomething.holidaysomething.service.product;

import com.holidaysomething.holidaysomething.dto.ProductOrderDetailCommand;
import com.holidaysomething.holidaysomething.dto.ProductOrderDetailDto;
import com.holidaysomething.holidaysomething.dto.ProductOrderInfoCommand;
import com.holidaysomething.holidaysomething.dto.ProductOrderInfoDto;
import java.util.List;

public interface ProductOrderService {
  List<ProductOrderInfoDto> fromProductOrderInfoCommandToProductOrderInfoList(ProductOrderInfoCommand poc);
  List<ProductOrderDetailDto> fromProductOrderDetailCommandToProductOrderDetailList(ProductOrderDetailCommand poc);
}

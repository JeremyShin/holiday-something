package com.holidaysomething.holidaysomething.service.product;

import com.holidaysomething.holidaysomething.dto.ProductOrderDetailCommand;
import com.holidaysomething.holidaysomething.dto.ProductOrderDetailDto;
import com.holidaysomething.holidaysomething.dto.ProductOrderInfoCommand;
import com.holidaysomething.holidaysomething.dto.ProductOrderInfoDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductOrderServiceImpl implements ProductOrderService {

  @Override
  public List<ProductOrderInfoDto> fromProductOrderInfoCommandToProductOrderInfoList(
      ProductOrderInfoCommand poc) {
    List<ProductOrderInfoDto> productOrderInfoDtos = poc.getProductOrderInfoDtos();
    return productOrderInfoDtos;
  }

  @Override
  public List<ProductOrderDetailDto> fromProductOrderDetailCommandToProductOrderDetailList(
      ProductOrderDetailCommand poc) {
    List<ProductOrderDetailDto> productOrderDetailDtos = poc.getProductOrderDetailDtos();
    return productOrderDetailDtos;
  }
}

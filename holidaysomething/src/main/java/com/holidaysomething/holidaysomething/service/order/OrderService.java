package com.holidaysomething.holidaysomething.service.order;

import com.holidaysomething.holidaysomething.domain.Order;
import com.holidaysomething.holidaysomething.dto.ProductOrderCompleteDto;
import com.holidaysomething.holidaysomething.dto.ProductOrderDetailDto;

public interface OrderService {
  Order add(ProductOrderCompleteDto productOrderCompleteDto, ProductOrderDetailDto productOrderDetailDto);

}

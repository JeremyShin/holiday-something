package com.holidaysomething.holidaysomething.service.order;

import com.holidaysomething.holidaysomething.domain.Order;
import com.holidaysomething.holidaysomething.dto.ProductOrderCompleteDto;
import com.holidaysomething.holidaysomething.dto.ProductOrderDetailDto;
import com.holidaysomething.holidaysomething.dto.ProductOrderInfoDto;
import java.util.List;

public interface OrderService {
  Order add(Integer totalUseMileage, List<ProductOrderInfoDto> orderInfos, Long memberId);
}

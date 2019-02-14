package com.holidaysomething.holidaysomething.service.order;

import com.holidaysomething.holidaysomething.domain.OrderedProduct;
import com.holidaysomething.holidaysomething.dto.ProductOrderInfoDto;
import java.util.List;

public interface OrderedProductService {
  List<OrderedProduct> add(Long orderId, List<ProductOrderInfoDto> orderInfos);

}

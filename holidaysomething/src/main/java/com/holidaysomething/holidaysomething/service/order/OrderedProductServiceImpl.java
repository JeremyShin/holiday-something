package com.holidaysomething.holidaysomething.service.order;

import com.holidaysomething.holidaysomething.domain.Order;
import com.holidaysomething.holidaysomething.domain.OrderedProduct;
import com.holidaysomething.holidaysomething.domain.Product;
import com.holidaysomething.holidaysomething.domain.ProductOption;
import com.holidaysomething.holidaysomething.dto.ProductOrderInfoDto;
import com.holidaysomething.holidaysomething.repository.OrderRepository;
import com.holidaysomething.holidaysomething.repository.OrderedProductRepository;
import com.holidaysomething.holidaysomething.repository.ProductOptionRepository;
import com.holidaysomething.holidaysomething.repository.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderedProductServiceImpl implements OrderedProductService {

  private final OrderRepository orderRepository;
  private final OrderedProductRepository orderedProductRepository;
  private final ProductRepository productRepository;
  private final ProductOptionRepository productOptionRepository;

  @Override
  public List<OrderedProduct> add(Long orderId, List<ProductOrderInfoDto> orderInfos) {
    List<OrderedProduct> orderedProducts = new ArrayList<>();

    for (ProductOrderInfoDto orderInfo : orderInfos){
      Order order = orderRepository.getOne(orderId);
      OrderedProduct orderedProduct = new OrderedProduct();
      Product product = productRepository.getOne(orderInfo.getProductId());
      ProductOption productOption = productOptionRepository.getOne(orderInfo.getOptionId());

      orderedProduct.setOrder(order);

      if (productOption.getPrice() != null){
        orderedProduct.setOrderPrice(product.getSellingPrice()  + productOption.getPrice());
      } else {
        orderedProduct.setOrderPrice(product.getSellingPrice());
      }

      orderedProduct.setMileage(product.getMileage());
      orderedProduct.setQuantity(orderInfo.getQuantity());
      orderedProduct.setProduct(product);
      orderedProduct.setProductOption(productOption);

      orderedProductRepository.save(orderedProduct);
      orderedProducts.add(orderedProduct);
    }

    return orderedProducts;
  }
}

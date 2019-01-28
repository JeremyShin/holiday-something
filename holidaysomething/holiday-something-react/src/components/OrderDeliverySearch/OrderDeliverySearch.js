import React, { Component } from 'react';
import '../../App.css';

class OrderDeliverySearch extends Component {
  render() {
    const { user } = this.props;

    return (
      <div>
        <h2>주문배송 조회</h2>
        <table>
          <thead>
            <tr>
              <th>상품 정보</th>
              <th>배송비</th>
              <th>진행 상태</th>
            </tr>
          </thead>
          <tbody>
            {user.orders.map((order) => {
              return (
                <React.Fragment key={order.id}>
                  <tr className="order-tbl-header">
                    <td>
                      <p>주문일자 {order.date}</p>
                      <p>주문번호 {order.orderNumber}</p>
                    </td>
                  </tr>

                  {order.orderedProduct.map((product) => {
                    let img;
                    if (product.product.productImages !== undefined && product.product.productImages.length !== 0) {
                      img = <img src={product.product.productImages[0].path} 
                                alt={product.product.productImages[0].storedFileName}
                                className="order-delivery-search-img" />
                    }
                    return (
                      <tr key={product.id}>
                        <td>
                          {img}
                          <h4>{product.product.name}</h4>
                        </td>
                        <td>
                          {order.shipping.shippingPrice}
                        </td>
                        <td>
                          {order.status}
                        </td>
                      </tr>
                    )
                  })}
                </React.Fragment>
              )
            })}
          </tbody>
        </table>
      </div>
    );
  }
}

export default OrderDeliverySearch;
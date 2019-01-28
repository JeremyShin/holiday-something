import React, { Component } from 'react';

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
                <div key={order.id}>
                  <tr className="order-tbl-header">
                    <div>
                      <p>주문일자 {order.date}</p>
                      <p>주문번호 {order.orderNumber}</p>
                      <p>{order.status}</p>
                    </div>
                  </tr>

                  {order.orderedProduct.map((product) => {
                    return (
                      <tr key={product.id}>
                        <td>
                        <img src={product.product.productImages[0].path} 
                              alt={product.product.productImages[0].storedFileName}/>
                        <h4>{product.product.name}</h4>
                        </td>
                        <td>
                          {order.shipping.shippingPrice}
                        </td>
                      </tr>
                    )
                  })}
                </div>
              )
            })}
          </tbody>
        </table>
      </div>
    );
  }
}

export default OrderDeliverySearch;
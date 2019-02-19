import React, { Component } from 'react';
import styled from 'styled-components';

const RecentOrderWrapper = styled.div`

`;

class RecentOrder extends Component {
  render() {
    const { user } = this.props;
    let orders;

    if (user.orders === null)
      orders = '';
    else {
      orders = user.orders.map((order) => {
        return (
          <tr key={order.id}>
            <td>{order.date}</td>
            <td>{order.orderedProduct.length < 1 ? '' : order.orderedProduct[0].product.name}</td>
            <td>{order.orderNumber}</td>
            <td>{order.totalPrice}원</td>
          </tr>
        )
      })
    }

    return (
      <RecentOrderWrapper>
        <h3>최근 주문</h3>
        <table>
          <thead>
            <tr>
              <th>주문일</th>
              <th>주문내역</th>
              <th>주문번호</th>
              <th>결제금액</th>
            </tr>
          </thead>
          <tbody>
            {orders}
          </tbody>
        </table>
      </RecentOrderWrapper>
    );
  }
}

export default RecentOrder;
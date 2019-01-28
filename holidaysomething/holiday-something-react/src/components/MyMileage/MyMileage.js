import React, { Component } from 'react';

class MyMileage extends Component {
  render() {
    const { user } = this.props;

    return (
      <div>
        <h2>마일리지 현황</h2>
        <table>
          <thead>
            <tr>
              <th>현재 마일리지</th>
              {/* <th>적립 마일리지</th>
              <th>사용한 마일리지</th>
              <th>소멸된 마일리지</th> */}
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>{user.mileage}</td>
              {/* <td></td>
              <td></td>
              <td></td> */}
            </tr>
          </tbody>
        </table>
        <ul>
          <li>마일리지는 부여된 해로부터 5년 이내에 사용하셔야 합니다.</li>
          <li>특정 이벤트 당첨 마일리지는 이벤트 기한내에서만 사용이 가능하고 미사용 적립금은 소멸됩니다.</li>
        </ul>

        <h2>마일리지 적립 및 사용</h2>
        <p>마일리지는 적립 및 사용하신 내역입니다. (주문 마일리지는 주문 내역 조회에서 확인 가능합니다.)</p>
        <table>
          <thead>
            <tr>
              <th>적용일자</th>
              <th>적용내용</th>
              <th>마일리지</th>
              <th>관련주문번호</th>
            </tr>
          </thead>
          <tbody>
            {user.orders.map((order) => {
              return (
                <tr>
                  <td>{order.date}</td>
                  <td>주문적립</td>
                  <td>{order.mileage}</td>
                  <td>{order.orderNumber}</td>
                </tr>
              )
            })}
          </tbody>
        </table>

        <h5>마일리지 사용기준 및 사용기한</h5>
        <ul>
          <li>마일리지는 구매금액 제한 없이 현금처럼 사용하실 수 있습니다.</li>
          <li>마일리지는 부여된 해로부터 5년 이내에 사용하셔야 합니다.</li>
          <li>특정 이벤트 당첨 마일리지는 이벤트 기한내에서만 사용이 가능하고 미사용 적립금은 소멸됩니다.</li>
          <li>마일리지는 부여 된 순서로 사용 되며 해당 기간 내에 사용하지 않으실 경우, 잔여 마일리지는 1년 단위로 매해 12월 31일 자동 소멸 됩니다.</li>
          <li>주문적립 마일리지는 배송완료일 기준 7일 시점으로 적립 됩니다.</li>
        </ul>
      </div>
    );
  }
}

export default MyMileage;
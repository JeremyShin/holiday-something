import React, { Component } from 'react';
import { Route } from 'react-router-dom';
import { Home, Orders, Account, Mileage } from '../pages';

class App extends Component {
  render() {
    return (
      <div>
        <Route exact path="/" component={Home} />       {/* 마이페이지 메인 */}
        <Route path="/orders" component={Orders} />     {/* 주문배송 조회 */}
        <Route path="/account" component={Account} />   {/* 회원정보 수정 */}
        <Route path="/mileage" component={Mileage} />   {/* 마일리지 현황 */}
      </div>
    )
  }
}

export default App;
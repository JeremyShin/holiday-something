import React, { Component } from 'react';
import styled from 'styled-components';
import MainContentHeader from '../MainContentHeader/MainContentHeader';
import RecentOrder from '../RecentOrder/RecentOrder';
import OrderDeliverySearch from '../OrderDeliverySearch/OrderDeliverySearch';
import AccountModify from '../AccountModify/AccountModify';
import MyMileage from '../MyMileage/MyMileage';

const MainContentWrapper = styled.div`
  flex-grow: 1;
  margin-right: 50px;
`;

class MainContent extends Component {
  
  render() {
    const { user, mainCenter } = this.props;
    let mainContentCenter;

    if (mainCenter === 'home') {
      mainContentCenter = <RecentOrder user={user} />
    }
    else if (mainCenter === 'orders') {
      mainContentCenter = <OrderDeliverySearch user={user} />
    }
    else if (mainCenter === 'account') {
      mainContentCenter = <AccountModify user={user} />
    }
    else if (mainCenter === 'mileage') {
      mainContentCenter = <MyMileage user={user} />
    }

    return (
      <MainContentWrapper>
        <MainContentHeader user={user} />

        {/* 'mainCenter' state가 무엇이냐에 따라 하단에 어떤 컴포넌트를 쓸지 결정 */}
        {mainContentCenter}
      </MainContentWrapper>
    );
  }
}

export default MainContent;
import React, { Component } from 'react';
import styled from 'styled-components';
import MainContentHeader from '../MainContentHeader/MainContentHeader';
import RecentOrder from '../RecentOrder/RecentOrder';

const MainContentWrapper = styled.div`
  flex-grow: 1;
  margin-right: 50px;
`;

class MainContent extends Component {

  render() {
    const { user } = this.props;

    return (
      <MainContentWrapper>
        <MainContentHeader user={user} />
        <RecentOrder />
      </MainContentWrapper>
    );
  }
}

export default MainContent;
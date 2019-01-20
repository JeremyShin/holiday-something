import React, { Component } from 'react';
import styled from 'styled-components';

const SideBarWrapper = styled.div`
  width: 210px;
  height: 600px;
  margin: 0 20px 0 50px;
  // border: 1px dotted blue;
`;

class Sidebar extends Component {
  render() {
    return (
      <SideBarWrapper>
        <h3>{this.props.user.name}님</h3>
        <p><a href="">주문배송 조회</a></p>
        <p><a href="">회원정보 수정</a></p>
        <p><a href="">마일리지 현황</a></p>
      </SideBarWrapper>
    );
  }
}

export default Sidebar;
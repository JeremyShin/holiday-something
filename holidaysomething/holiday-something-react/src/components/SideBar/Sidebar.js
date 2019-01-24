import React, { Component } from 'react';
import styled from 'styled-components';
import { Link } from 'react-router-dom';
import './SideBar.css'

const SideBarWrapper = styled.div`
  width: 210px;
  height: 600px;
  margin: 0 20px 0 50px;
`;

class SideBar extends Component {
  render() {
    return (
      <SideBarWrapper>
        <h3 className="user-name">{this.props.user.name}님</h3>
        <p><Link to="/orders">주문배송 조회</Link></p>
        <p><Link to="/account">회원정보 수정</Link></p>
        <p><Link to="/mileage">마일리지 현황</Link></p>
      </SideBarWrapper>
    );
  }
}

export default SideBar;
import React, { Component } from 'react';
import styled from 'styled-components';
import { NavLink } from 'react-router-dom';
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
        <NavLink to="/orders" className="Nav_link"><p>주문배송 조회</p></NavLink>
        <NavLink to="/account" className="Nav_link"><p>회원정보 수정</p></NavLink>
        <NavLink to="/mileage" className="Nav_link"><p>마일리지 현황</p></NavLink>
      </SideBarWrapper>
    );
  }
}

export default SideBar;
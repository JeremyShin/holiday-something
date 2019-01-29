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
        <Link to="/orders"><p>주문배송 조회</p></Link>
        <Link to="/account"><p>회원정보 수정</p></Link>
        <Link to="/mileage"><p>마일리지 현황</p></Link>
      </SideBarWrapper>
    );
  }
}

export default SideBar;
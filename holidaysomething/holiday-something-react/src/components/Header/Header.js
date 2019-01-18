import React, { Component } from 'react';
import HeaderTop from '../HeaderTop/HeaderTop';
import HeaderCategories from '../HeaderCategories/HeaderCategories';
import styled from 'styled-components';

const HeaderWrapper = styled.div`
  background: rgba(255, 255, 255, 0);
  z-index: 5;
  position: relative;
  left: 0;
  top: 0;
  width: 100%;
  overflow: hidden;
`;

const HeaderHr = styled.hr`
  display: block;
  height: 1px;
  border: 0;
  border-top: 1px solid #D4D4D4;
  padding: 0;
`;

class Header extends Component {
  render() {
    return (
      <HeaderWrapper className="header">
        <HeaderTop />
        <HeaderCategories/>
        <HeaderHr />
      </HeaderWrapper>
    );
  }
}

export default Header;
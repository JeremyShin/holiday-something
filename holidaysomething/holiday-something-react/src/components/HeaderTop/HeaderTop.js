import React from 'react';
import { FiSearch } from "react-icons/fi";
import { FaRegUser } from "react-icons/fa";
import { FiShoppingCart } from "react-icons/fi";
import hsLogo from './hs-logo.png';
import styled from 'styled-components';
import './HeaderTop.css'

const LogoImg = styled.img`
  height: 60px;
  width: auto;
`;

const HeaderTopWrapper = styled.div`
  display: flex;
  justify-content: space-between;
  padding: 10px 40px 0 40px;
  margin: 0 180px;
  max-width: 1440px;
  height: 68px;
  align-items: center;
  font-size: 16px;
  font-family: Helvetica, Arial, sans-serif;
  color: #363636;
`;

const HeaderTop = () => {
  return (
    <HeaderTopWrapper className="header-top">
      <div className="header-search">
        <FiSearch/> Search
      </div>
      <LogoImg src={hsLogo} alt="hs-logo" className="hsLogo" />
      <div className="header-sign-in-cart">
        <FaRegUser/> Sign in
        <FiShoppingCart/> Cart
      </div>
    </HeaderTopWrapper>
  );
}

export default HeaderTop;
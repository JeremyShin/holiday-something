import React, { Component } from 'react';
import styled from 'styled-components';

const HeaderCategoriesWrapper = styled.div`
  display: flex;
  justify-content: center;
  max-width: 1260px;
  margin: 0 auto;
  margin-top: 10px;
  font-family: Helvetica, Arial, sans-serif;
  letter-spacing: 0.15px;
  font-size: 12px;
  font-style: normal;
  font-stretch: normal;
  line-height: 1.88;
  text-align: center;
  color: #333;

  & > div {
    margin-right: 40px;
    font-size: 15px;
    font-weight: 600;
  }
  & > div > a {
    text-decoration: none;
  }
  & > div > a:visited {
    color: inherit;
  }
`;

class HeaderCategories extends Component {
  render() {
    return (
      <HeaderCategoriesWrapper className="header-categories">
        {/* 이렇게만 해도 8080 포트 상에서 실행할 때는 mypage와 /product/* 페이지 사이를 잘 이동한다. */}
        {/* 단, 3000 포트에서 react 테스트 시 다른 포트(8080)로 이동하는 방법은 아직 모르겠다. */}
        <div><a href="/product/1">Stationery</a></div>
        <div><a href="/product/2">D.I.Y</a></div>
        <div><a href="/product/3">Fashion</a></div>
        <div><a href="/product/4">Food</a></div>
      </HeaderCategoriesWrapper>
    );
  }
}

export default HeaderCategories;
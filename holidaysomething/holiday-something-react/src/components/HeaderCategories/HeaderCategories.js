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
  & a {
    text-decoration: none;
  }
  & a:visited {
    color: inherit;
  }
`;

class HeaderCategories extends Component {
  render() {
    return (
      <HeaderCategoriesWrapper className="header-categories">
        <div><a href="{#}">Stationery</a></div>
        <div><a href="{#}">D.I.Y</a></div>
        <div><a href="{#}">Fashion</a></div>
        <div><a href="{#}">Design</a></div>
        <div><a href="{#}">Soap</a></div>
      </HeaderCategoriesWrapper>
    );
  }
}

export default HeaderCategories;
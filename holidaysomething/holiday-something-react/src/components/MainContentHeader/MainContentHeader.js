import React from 'react';
import styled from 'styled-components';

const MainContentHeaderWrapper = styled.div`
  height: 135px;
  background-color: #303032;
  margin-bottom: 45px;
  color: white;
`;

const MainContentHeader = (props) => {
  return (
    <MainContentHeaderWrapper>
      <p>{props.user.nickname}</p>
      <div>
        <p>마일리지</p>
        <p>{props.user.mileage}</p>
      </div>
    </MainContentHeaderWrapper>
  );
}

export default MainContentHeader;
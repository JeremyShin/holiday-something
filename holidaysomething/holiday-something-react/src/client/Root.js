import React from 'react';
import { BrowserRouter } from 'react-router-dom';
import App from '../shared/App';

const Root = () => (
  <BrowserRouter
      basename="/mypage">
    <App/>
  </BrowserRouter>
);

export default Root;
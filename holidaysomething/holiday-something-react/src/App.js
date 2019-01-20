import React, { Component } from 'react';
import './App.css';
import styled from 'styled-components';
import Header from './components/Header/Header';
import Sidebar from './components/SideBar/Sidebar';
import MainContent from './components/MainContent/MainContent';

const MainWrapper = styled.div`
  display: flex;
  margin-top: 30px;
`;

class App extends Component {

  state = {

  }

  componentDidMount() {
    this._getUser()
  }

  // await을 쓰려면 바깥에 async가 있어야 한다
  _getUser = async () => {
    const user = await this._callApi();
    // await: 위 문장이 끝나기 전까지는(성공하든 실패하든) setState가 실행되지 않는다
    this.setState({
      user: user,  // "user: user" 와 같은 결과. (이름이 같은 경우)
    })
  };

  _callApi = () => {
    // 현재 로그인 되어 있는 user의 id를 가져와서 사용하는 것으로 변경해야 한다.
    return fetch('http://localhost:8080/api/user?id=2')
    .then(response => response.json())
    .then(json => json)
    .catch(err => console.error(err))
  };

  render() {
    return (
      <div>
        <Header />
        <MainWrapper>
          {this.state.user ? <Sidebar user={this.state.user} /> : 'Loading ...'}
          {this.state.user ? <MainContent user={this.state.user} /> : 'Loading ...'}
        </MainWrapper>
      </div>
    );
  }
}

export default App;
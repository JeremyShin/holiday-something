import React, { Component } from 'react';
import { Route, Switch } from 'react-router-dom';
import { Home, Orders, Account, Mileage } from '../pages';
// import { AuthProvider } from './AuthContext';

// const UserContext = React.createContext('user data not loaded');

class App extends Component {

  fetchAuthenticatedUser = async () => {
    const user = await this._callApi();
    // await: 위 문장이 끝나기 전까지는(성공하든 실패하든) 아래 문장이 실행되지 않는다
    if (user === null) {
      console.log('user is null!');
      return null;
    }

    // this.setState({
    //   user: user,
    // });
    return user;
  };

  _callApi = () => {
    // 현재 로그인 되어 있는 user의 id를 가져와서 사용하는 것으로 변경해야 한다.
    return fetch('http://localhost:8080/api/userTmp?id=11')
    // return fetch('http://localhost:8080/api/user/authenticated')  // 현재 로그인된 유저
    .then(response => response.json())
    .then(json => json)
    .catch(err => console.error(err));
  };

  render() {
    // const { user } = this.fetchAuthenticatedUser();

    return (
      // <AuthProvider>
      // <UserContext.Provider value={user}>
        <div>
        {/* {routes.map(({path, component: C, fetchAuthenticatedUser}) => (
          <Route
            path={path}
            render={(props) => <C fetchAuthenticatedUser={fetchAuthenticatedUser} />}
          />
        ))} */}

        <Switch>
          <Route exact path="/" component={Home}  />    
          <Route path="/orders" component={Orders} />   
          <Route path="/account" component={Account} /> 
          <Route path="/mileage" component={Mileage} /> 
        </Switch>

        {/* <Route exact path="/" render={(props) => <Home user={this.fetchAuthenticatedUser()} />} />
        <Route path="/orders" render={(props) => <Orders something={'here'} />} />
        <Route path="/account" render={(props) => <Account something={'here'} />} />
        <Route path="/mileage" render={(props) => <Mileage something={'here'} />} /> */}
        </div>
      // </UserContext.Provider>
      // </AuthProvider>
    )
  }
}

export default App;
import React, { Component } from 'react';

const AuthContext = React.createContext();

class AuthProvider extends Component {
  fetchAuthenticatedUser = async () => {
    const user = await this._callApi();

    if (user === null) {
      console.log('user is null!');
      return null;
    }

    this.setState({
      user: user,
    });
    // return user;
  };

  _callApi = () => {
    // return fetch('/api/user/11')
    return fetch('/api/user/authenticated')  // 현재 로그인된 유저
          .then(response => response.json())
          .then(json => json)
          .catch(err => console.error(err));
  };

  render() {
    const { user } = this.fetchAuthenticatedUser();

    return (
      <AuthContext.Provider
        value={user !== null ? user : ''}
      >

      </AuthContext.Provider>
    );
  }
}

const AuthConsumer = AuthContext.Consumer;

export { AuthProvider, AuthConsumer };
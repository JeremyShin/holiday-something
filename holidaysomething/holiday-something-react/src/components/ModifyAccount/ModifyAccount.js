import React, { Component } from 'react';

class ModifyAccount extends Component {
  constructor() {
    super();
    this.state = {
      modifyEmailBtnText: '이메일 변경',
      isModifyEmailHidden: true,
    };
  }

  toggleModifyEmail = () => {
    this.setState(prevState => ({
      ...prevState,
      isModifyEmailHidden: !prevState.isModifyEmailHidden,
      modifyEmailBtnText: (prevState.modifyEmailBtnText === '이메일 변경') ? '이메일 변경 취소' : '이메일 변경',
    }));
  };

  render() {
    const { user } = this.props;

    return (
      <div>
        <section className="my-modify">
          <h3>회원정보 수정</h3>

          <ul className="tbl-list">
            <li className="tbl-tr tbl-tr-id">
              <div className="tbl-th">
                <strong>아이디</strong>
              </div>
              <div className="tbl-td">
                <p>{user.loginId}</p>
              </div>
            </li>
            <li className="tbl-tr tbl-tr-email">
              <div className="tbl-th">
                <strong>이메일</strong>
              </div>
              <div className="tbl-td">
                <p>{user.email}</p>
                <ModifyEmailBtn 
                  handleClick={this.toggleModifyEmail}
                  text={this.state.modifyEmailBtnText} 
                />
                {!this.state.isModifyEmailHidden && <ModifyEmailDiv />}
              </div>
            </li>
            <li className="tbl-tr tbl-tr-password">
              <div className="tbl-th">
                <strong>비밀번호 변경</strong>
              </div>
              <div className="tbl-td">
                <form>
                  <div>
                    <label htmlFor="user_password">현재 비밀번호</label>
                    <input type="password" id="user_password" />
                  </div>
                  <div>
                    <label htmlFor="new_password">신규 비밀번호</label>
                    <input type="password" id="new_password" />
                  </div>
                  <div>
                    <label htmlFor="confirm_password">신규 비밀번호 확인</label>
                    <input type="password" id="confirm_password" />
                  </div>
                  <button className="btn-black">비밀번호 변경</button>
                </form>
              </div>
            </li>
            <li className="tbl-tr tbl-tr-name">
              <div className="tbl-th">
                <strong>이름</strong>
              </div>
              <div className="tbl-td">
                <p>{user.name}</p>
              </div>
            </li>
            <li className="tbl-tr tbl-tr-tel">
              <div className="tbl-th">
                <strong>휴대폰 번호</strong>
              </div>
              <div className="tbl-td">
                {/* 기존 휴대폰 정보 보여주는 부분 */}
                <div className="hp-in">
                  <div className="tel-field">
                    <div className="input-box">???</div>
                    <div className="dash">-</div>
                    <div className="input-box">???</div>
                    <div className="dash">-</div>
                    <div className="input-box">???</div>
                  </div>
                  <button className="btn-black" type="button">휴대폰번호 변경</button>
                </div>

                {/* 휴대폰 정보 수정 input */}
                <div className="edit-box">
                  <div className="hp-in">
                    <form>
                      <div className="tel-field">
                        <div className="user-cell-first">
                          <select>
                            <option value="010">010</option>
                            <option value="011">011</option>
                            <option value="016">016</option>
                            <option value="017">017</option>
                            <option value="018">018</option>
                            <option value="019">019</option>
                          </select>
                        </div>
                        <div className="dash">-</div>
                        <div className="input-box">???</div>
                        <div className="dash">-</div>
                        <div className="input-box">???</div>
                      </div>
                    </form>
                  </div>
                </div>
              </div>
            </li>
            <li className="tbl-tr tbl-tr-addr">
              <div className="tbl-th">
                <strong>주소</strong>
              </div>
              <div className="tbl-td">
                <div className="in-row">
                  <div className="zip-box">
                    <div className="box">{user.postcode}</div>
                  </div>
                </div>
                <div className="in-half">
                  <div className="input-box">
                    <input type="text" />
                  </div>
                  <div className="input-box">
                    <input type="text" />
                  </div>
                  <p className="info">주소를 수정할 경우 '기본배송지정보' 도 추가됩니다.</p>
                </div>
              </div>
            </li>
            <li className="tbl-tr tbl-tr-birth">
              <div className="tbl-th">
                <strong>생일</strong>
              </div>
              <div className="tbl-td">
                <form>
                  <div className="in-row">
                    <span className="input-box">
                      <input name="birth-year" />
                    </span>
                    <span className="split">년</span>
                    <span className="input-box">
                      <input name="birth-year" />
                    </span>
                    <span className="split">월</span>
                    <span className="input-box">
                      <input name="birth-year" />
                    </span>
                    <span className="split">일</span>
                  </div>
                </form>
              </div>
            </li>
          </ul>

          <div className="btn-box">
            <button className="btn-white" type="reset">취소</button>
            <button className="btn-black" type="submit">저장</button>
          </div>
        </section>
      </div>
    );
  }
}

// '이메일 변경' / '이메일 변경 취소' toggle 버튼
class ModifyEmailBtn extends Component {
  render() {
    return (
      <button className="btn-black" onClick={this.props.handleClick}>
        {this.props.text}
      </button>
    );
  }
}

// 이메일 변경 form (show/hide toggle)
const ModifyEmailDiv = () => {
  return (
    <div className="edit-box">
      <form>
        <div className="edit-in">
          <span className="input-box">
            <input type="email" />
          </span>
          <span className="input-box">@</span>
          <span className="input-box">
            <input type="email" />
          </span>
          <a className="btn-black" href="/">변경하기</a>
        </div>
      </form>
    </div>
  )
};

export default ModifyAccount;
-- alter table product_image_category default character set utf8;

-- INSERT INTO product_image_category (id, name) VALUES (1, '상세이미지');
-- INSERT INTO product_image_category (id, name) VALUES (2, '목록이미지');
-- INSERT INTO product_image_category (id, name) VALUES (3, '추가이미지');

INSERT INTO exchange_refund(apply_date, approve, approve_date, price, type) VALUES (now(), 1, now(), 3000, '환불');
INSERT INTO exchange_refund(apply_date, approve, approve_date, price, type) VALUES (now(), 1, now(), 3000, '환불');
INSERT INTO exchange_refund(apply_date, approve, approve_date, price, type) VALUES (now(), 1, now(), 3000, '환불');
INSERT INTO exchange_refund(apply_date, approve, approve_date, price, type) VALUES (now(), 1, now(), 3000, '환불');
INSERT INTO exchange_refund(apply_date, approve, approve_date, price, type) VALUES (now(), 1, now(), 3000, '환불');
INSERT INTO exchange_refund(apply_date, approve, approve_date, price, type) VALUES (now(), 1, now(), 3000, '환불');
INSERT INTO exchange_refund(apply_date, approve, approve_date, price, type) VALUES (now(), 1, now(), 3000, '환불');
INSERT INTO exchange_refund(apply_date, approve, approve_date, price, type) VALUES (now(), 1, now(), 3000, '환불');
INSERT INTO exchange_refund(apply_date, approve, approve_date, price, type) VALUES (now(), 1, now(), 3000, '환불');
INSERT INTO exchange_refund(apply_date, approve, approve_date, price, type) VALUES (now(), 1, now(), 3000, '환불');
INSERT INTO exchange_refund(apply_date, approve, approve_date, price, type) VALUES (now(), 1, now(), 3000, '환불');
INSERT INTO exchange_refund(apply_date, approve, approve_date, price, type) VALUES (now(), 1, now(), 3000, '환불');
INSERT INTO exchange_refund(apply_date, approve, approve_date, price, type) VALUES (now(), 1, now(), 3000, '환불');
INSERT INTO exchange_refund(apply_date, approve, approve_date, price, type) VALUES (now(), 1, now(), 3000, '환불');
INSERT INTO exchange_refund(apply_date, approve, approve_date, price, type) VALUES (now(), 1, now(), 3000, '환불');
INSERT INTO exchange_refund(apply_date, approve, approve_date, price, type) VALUES (now(), 1, now(), 3000, '환불');
INSERT INTO exchange_refund(apply_date, approve, approve_date, price, type) VALUES (now(), 1, now(), 3000, '환불');
INSERT INTO exchange_refund(apply_date, approve, approve_date, price, type) VALUES (now(), 1, now(), 3000, '환불');
INSERT INTO exchange_refund(apply_date, approve, approve_date, price, type) VALUES (now(), 1, now(), 3000, '환불');
INSERT INTO exchange_refund(apply_date, approve, approve_date, price, type) VALUES (now(), 1, now(), 3000, '환불');
INSERT INTO exchange_refund(apply_date, approve, approve_date, price, type) VALUES (now(), 1, now(), 3000, '환불');
INSERT INTO exchange_refund(apply_date, approve, approve_date, price, type) VALUES (now(), 1, now(), 3000, '환불');
INSERT INTO exchange_refund(apply_date, approve, approve_date, price, type) VALUES (now(), 1, now(), 3000, '환불');
INSERT INTO exchange_refund(apply_date, approve, approve_date, price, type) VALUES (now(), 1, now(), 3000, '환불');
INSERT INTO exchange_refund(apply_date, approve, approve_date, price, type) VALUES (now(), 1, now(), 3000, '환불');
INSERT INTO exchange_refund(apply_date, approve, approve_date, price, type) VALUES (now(), 1, now(), 3000, '환불');
INSERT INTO exchange_refund(apply_date, approve, approve_date, price, type) VALUES (now(), 1, now(), 3000, '환불');
INSERT INTO exchange_refund(apply_date, approve, approve_date, price, type) VALUES (now(), 1, now(), 3000, '환불');
INSERT INTO exchange_refund(apply_date, approve, approve_date, price, type) VALUES (now(), 1, now(), 3000, '환불');
INSERT INTO exchange_refund(apply_date, approve, approve_date, price, type) VALUES (now(), 1, now(), 3000, '환불');


INSERT INTO member (id, login_id, password, email, name, nickname, phone, birthday, postcode, address1, address2, receive_email, receive_sms, marketing, personal_info, recommender, sex, reg_date, last_login)
VALUES (null, 'root', '1234', 'root@naver.com', '김루트', 'rootnickname', '02-1111-1111', '1977-11-10', '04557', '서울특별시 중구 퇴계로', '211-5', 1, 1, 1, 1, null, '여성', '2019-01-01 00:00:01', '2019-01-01 05:00:01');
INSERT INTO member (id, login_id, password, email, name, nickname, phone, birthday, postcode, address1, address2, receive_email, receive_sms, marketing, personal_info, recommender, sex, reg_date, last_login)
VALUES (null, 'holiday', '1234', 'holidaysomething@gmail.com', '김홀리', 'holidaysomething', '02-7622-7622', '1988-12-31', '04547', '서울특별시 중구 동호로', '361', 1, 1, 1, 1, null, '여성', '2018-12-12 00:00:01', '2019-01-01 05:00:01');
INSERT INTO member (id, login_id, password, email, name, nickname, phone, birthday, postcode, address1, address2, receive_email, receive_sms, marketing, personal_info, recommender, sex, reg_date, last_login)
VALUES (null, 'larimar', '1234', 'larimar@gmail.com', '라리마', 'larimar', '010-3561-6124', '1990-01-28', '04757', '서울특별시 성동구 마장로 42길 16', '201호', 1, 1, 1, 1, null, '남성', '2018-12-30 00:00:01', '2019-01-01 05:00:01');
INSERT INTO member (id, login_id, password, email, name, nickname, phone, birthday, postcode, address1, address2, receive_email, receive_sms, marketing, personal_info, recommender, sex, reg_date, last_login)
VALUES (null, 'crazy', '1234', 'jhkim4685@gmail.com', '김준형', 'CrAzy', '010-2925-4685', '1995-02-01', '04960', '서울특별시 광진구 자양로 48길 34', '301호', 1, 1, 1, 1, null, '기타', '2019-01-01 00:00:01', '2019-01-01 05:00:01');
INSERT INTO member (id, login_id, password, email, name, nickname, phone, birthday, postcode, address1, address2, receive_email, receive_sms, marketing, personal_info, recommender, sex, reg_date, last_login)
VALUES (null, 'marin', '1111', 'marin24@gmail.com', '임요환', 'SlayersBoxeR', '010-1111-1111', '1980-09-04', '11111', '경기도 포천시 이동면 성장로', '111', 1, 1, 1, 1, null, '기타', '2019-01-01 00:00:01', '2019-01-01 05:00:01');
INSERT INTO member (id, login_id, password, email, name, nickname, phone, birthday, postcode, address1, address2, receive_email, receive_sms, marketing, personal_info, recommender, sex, reg_date, last_login)
VALUES (null, 'yellow', '22', 'yellow22@gmail.com', '홍진호', '콩진호콩진호', '010-2222-2222', '1982-10-31', '22222', '인천광역시 미추홀구 학익소로 63', '22', 1, 1, 1, 1, null, '여성', '2019-01-01 00:00:01', '2019-01-01 05:00:01');
INSERT INTO member (id, login_id, password, email, name, nickname, phone, birthday, postcode, address1, address2, receive_email, receive_sms, marketing, personal_info, recommender, sex, reg_date, last_login)
VALUES (null, 'faker', '1234', 'faker142@gmail.com', '이상혁', 'faker', '010-5671-6135', '1996-05-07', '12567', '경기도 양평군 개군면 양덕길 83', '', 1, 1, 1, 1, null, '남성', '2019-01-01 00:00:01', '2019-01-01 05:00:01');
INSERT INTO member (id, login_id, password, email, name, nickname, phone, birthday, postcode, address1, address2, receive_email, receive_sms, marketing, personal_info, recommender, sex, reg_date, last_login)
VALUES (null, 'ambition', '1234', 'ambition48@gmail.com', '강찬용', 'ambition', '010-6167-6125', '1992-10-27', '15256', '경기도 안산시 상록구', '', 1, 1, 1, 1, null, '남성', '2019-01-01 00:00:01', '2019-01-01 05:00:01');
INSERT INTO member (id, login_id, password, email, name, nickname, phone, birthday, postcode, address1, address2, receive_email, receive_sms, marketing, personal_info, recommender, sex, reg_date, last_login)
VALUES (null, 'blue', '1234', 'blue1528@gmail.com', '강블루', 'blue', '010-4125-4412', '1989-10-25', '14256', '경기도 광명시 오리로 801', '101', 1, 1, 1, 1, null, '남성', '2019-01-01 00:00:01', '2019-01-01 05:00:01');
INSERT INTO member (id, login_id, password, email, name, nickname, phone, birthday, postcode, address1, address2, receive_email, receive_sms, marketing, personal_info, recommender, sex, reg_date, last_login)
VALUES (null, 'black', '1234', 'black1528@gmail.com', '강블랙', 'black', '010-1631-2455', '1992-05-24', '15234', '경기도 안산시 단원구 선부로 166', '101', 1, 1, 1, 1, null, '여성', '2019-01-01 00:00:01', '2019-01-01 05:00:01');
INSERT INTO member (id, login_id, password, email, name, nickname, phone, birthday, postcode, address1, address2, receive_email, receive_sms, marketing, personal_info, recommender, sex, reg_date, last_login)
VALUES (null, 'white', '1234', 'blacka1528@gmail.com', '강하양', 'white', '010-5252-2245', '1992-07-14', '15234', '경기도 안산시 단원구 선부로 166', '201', 1, 1, 1, 1, null, '여성', '2019-01-01 00:00:01', '2019-01-01 05:00:01');
INSERT INTO member (id, login_id, password, email, name, nickname, phone, birthday, postcode, address1, address2, receive_email, receive_sms, marketing, personal_info, recommender, sex, reg_date, last_login)
VALUES (null, 'pink', '1234', 'pink1524@gmail.com', '김분홍', 'pink', '010-1124-5521', '1994-05-14', '15234', '경기도 안산시 단원구 선부로 166', '202', 1, 1, 1, 1, null, '여성', '2019-01-01 00:00:01', '2019-01-01 05:00:01');
INSERT INTO member (id, login_id, password, email, name, nickname, phone, birthday, postcode, address1, address2, receive_email, receive_sms, marketing, personal_info, recommender, sex, reg_date, last_login)
VALUES (null, 'red', '1234', 'red1524@gmail.com', '김빨강', 'red', '010-5512-4678', '1993-02-13', '15234', '경기도 안산시 단원구 선부로 166', '203', 1, 1, 1, 1, null, '여성', '2019-01-01 00:00:01', '2019-01-01 05:00:01');
INSERT INTO member (id, login_id, password, email, name, nickname, phone, birthday, postcode, address1, address2, receive_email, receive_sms, marketing, personal_info, recommender, sex, reg_date, last_login)
VALUES (null, 'green', '1234', 'green1524@gmail.com', '박초록', 'green', '010-4567-1379', '1991-01-14', '15234', '경기도 안산시 단원구 선부로 166', '303', 1, 1, 1, 1, null, '여성', '2019-01-01 00:00:01', '2019-01-01 05:00:01');
INSERT INTO member (id, login_id, password, email, name, nickname, phone, birthday, postcode, address1, address2, receive_email, receive_sms, marketing, personal_info, recommender, sex, reg_date, last_login)
VALUES (null, 'orange', '1234', 'orange2556@gmail.com', '나주황', 'orange', '010-5678-1251', '1991-11-14', '15234', '경기도 안산시 단원구 선부로 166', '302', 1, 1, 1, 1, null, '기타', '2019-01-01 00:00:01', '2019-01-01 05:00:01');
INSERT INTO member (id, login_id, password, email, name, nickname, phone, birthday, postcode, address1, address2, receive_email, receive_sms, marketing, personal_info, recommender, sex, reg_date, last_login)
VALUES (null, 'violet', '1234', 'violet26@gmail.com', '최보라', 'violet', '010-5511-2567', '1991-11-24', '15212', '경기도 안산시 단원구 우목골길 3-7', '101호', 1, 1, 1, 1, null, '기타', '2019-01-01 00:00:01', '2019-01-01 05:00:01');
INSERT INTO member (id, login_id, password, email, name, nickname, phone, birthday, postcode, address1, address2, receive_email, receive_sms, marketing, personal_info, recommender, sex, reg_date, last_login)
VALUES (null, 'navy', '1234', 'navy126@gmail.com', '최남색', 'navy', '010-5511-2252', '1989-09-29', '15212', '경기도 안산시 단원구 우목골길 3-7', '102호', 1, 1, 1, 1, null, '여성', '2019-01-01 00:00:01', '2019-01-01 05:00:01');
INSERT INTO member (id, login_id, password, email, name, nickname, phone, birthday, postcode, address1, address2, receive_email, receive_sms, marketing, personal_info, recommender, sex, reg_date, last_login)
VALUES (null, 'sky', '1234', 'sky126@gmail.com', '김하늘', 'sky', '010-5722-2567', '1989-03-07', '15212', '경기도 안산시 단원구 우목골길 3-7', '202호', 1, 1, 1, 1, null, '여성', '2019-01-01 00:00:01', '2019-01-01 05:00:01');
INSERT INTO member (id, login_id, password, email, name, nickname, phone, birthday, postcode, address1, address2, receive_email, receive_sms, marketing, personal_info, recommender, sex, reg_date, last_login)
VALUES (null, 'sea', '1234', 'sea126@gmail.com', '최바다', 'sea', '010-6661-2256', '1989-04-07', '15212', '경기도 안산시 단원구 우목골길 3-7', '201호', 1, 1, 1, 1, null, '여성', '2019-01-01 00:00:01', '2019-01-01 05:00:01');
INSERT INTO member (id, login_id, password, email, name, nickname, phone, birthday, postcode, address1, address2, receive_email, receive_sms, marketing, personal_info, recommender, sex, reg_date, last_login)
VALUES (null, 'earth', '1234', 'ground16@gmail.com', '박대지', 'earth', '010-5555-5555', '1988-05-07', '15212', '경기도 안산시 단원구 우목골길 3-7', '302호', 1, 1, 1, 1, null, '여성', '2019-01-01 00:00:01', '2019-01-01 05:00:01');
INSERT INTO member (id, login_id, password, email, name, nickname, phone, birthday, postcode, address1, address2, receive_email, receive_sms, marketing, personal_info, recommender, sex, reg_date, last_login)
VALUES (null, 'rlacjftn10', '1234', 'kcs1256@gmail.com', '김철수', 'kcs', '010-1257-2545', '1978-08-10', '11790', '경기도 의정부시 오목로35번길 49', '101호', 1, 1, 1, 1, null, '선택안함', '2019-01-01 00:00:01', '2019-01-01 05:00:01');
INSERT INTO member (id, login_id, password, email, name, nickname, phone, birthday, postcode, address1, address2, receive_email, receive_sms, marketing, personal_info, recommender, sex, reg_date, last_login)
VALUES (null, 'sky1234', '1234', 'kyh1252@gmail.com', '김영희', 'kyh', '010-7764-6896', '1980-04-10', '11790', '경기도 의정부시 오목로35번길 49', '102호', 1, 1, 1, 1, null, '남성', '2019-01-01 00:00:01', '2019-01-01 05:00:01');
INSERT INTO member (id, login_id, password, email, name, nickname, phone, birthday, postcode, address1, address2, receive_email, receive_sms, marketing, personal_info, recommender, sex, reg_date, last_login)
VALUES (null, 'monster', '1234', 'ryu99@gmail.com', '류현진', 'monster', '010-9999-9999', '1987-03-25', '06344', '서울시 강남구 일원동 689-1', '101', 1, 1, 1, 1, null, '여성', '2019-01-01 00:00:01', '2019-01-01 05:00:01');
INSERT INTO member (id, login_id, password, email, name, nickname, phone, birthday, postcode, address1, address2, receive_email, receive_sms, marketing, personal_info, recommender, sex, reg_date, last_login)
VALUES (null, 'kimalias', '1234', 'alias52@gmail.com', '김태균', 'kimalias', '010-5252-5252', '1982-05-29', '06344', '서울시 강남구 일원동 689-1', '102', 1, 1, 1, 1, null, '여성', '2019-01-01 00:00:01', '2019-01-01 05:00:01');
INSERT INTO member (id, login_id, password, email, name, nickname, phone, birthday, postcode, address1, address2, receive_email, receive_sms, marketing, personal_info, recommender, sex, reg_date, last_login)
VALUES (null, 'chuchutrain', '1234', 'train17@gmail.com', '추신수', 'chuchutrain', '010-1717-1717', '1982-07-13', '06344', '서울시 강남구 일원동 689-1', '103', 1, 1, 1, 1, null, '여성', '2019-01-01 00:00:01', '2019-01-01 05:00:01');
INSERT INTO member (id, login_id, password, email, name, nickname, phone, birthday, postcode, address1, address2, receive_email, receive_sms, marketing, personal_info, recommender, sex, reg_date, last_login)
VALUES (null, 'bigboy', '1234', 'bigboy10@gmail.com', '이대호', 'bigboy', '010-1010-1010', '1982-06-21', '06344', '서울시 강남구 일원동 689-1', '104', 1, 1, 1, 1, null, '남성', '2019-01-01 00:00:01', '2019-01-01 05:00:01');
INSERT INTO member (id, login_id, password, email, name, nickname, phone, birthday, postcode, address1, address2, receive_email, receive_sms, marketing, personal_info, recommender, sex, reg_date, last_login)
VALUES (null, 'kimtakgu', '1234', 'kimtakgu29@gmail.com', '김광현', 'kimtakgu', '010-2929-2929', '1988-07-22', '06344', '서울시 강남구 일원동 689-1', '201', 1, 1, 1, 1, null, '여성', '2019-01-01 00:00:01', '2019-01-01 05:00:01');
INSERT INTO member (id, login_id, password, email, name, nickname, phone, birthday, postcode, address1, address2, receive_email, receive_sms, marketing, personal_info, recommender, sex, reg_date, last_login)
VALUES (null, 'devil', '1234', 'devil8@gmail.com', '정근우', 'devil', '010-8888-8888', '1982-10-02', '06344', '서울시 강남구 일원동 689-1', '202', 1, 1, 1, 1, null, '남성', '2019-01-01 00:00:01', '2019-01-01 05:00:01');
INSERT INTO member (id, login_id, password, email, name, nickname, phone, birthday, postcode, address1, address2, receive_email, receive_sms, marketing, personal_info, recommender, sex, reg_date, last_login)
VALUES (null, '1234sky', '1234', 'whitetiger50@gmail.com', '강백호', 'whitetiger', '010-5050-5050', '1999-07-29', '06344', '서울시 강남구 일원동 689-1', '203', 1, 1, 1, 1, null, '남성', '2019-01-01 00:00:01', '2019-01-01 05:00:01');
INSERT INTO member (id, login_id, password, email, name, nickname, phone, birthday, postcode, address1, address2, receive_email, receive_sms, marketing, personal_info, recommender, sex, reg_date, last_login)
VALUES (null, 'TooMuchTalker', '1234', 'TooMuchTalker61@gmail.com', '박찬호', 'TooMuchTalker', '010-6161-6161', '1973-06-29', '06344', '서울시 강남구 일원동 689-1', '204', 1, 1, 1, 1, null, '여성', '2019-01-01 00:00:01', '2019-01-01 05:00:01');


INSERT INTO payment(amount,buyer_addr,buyer_email,buyer_name,buyer_postcode,buyer_tel,m_redirect_url,merchant_uid,msg,name,pay_method,pg)
VALUES(1,'buyeraddr1','afa1@gmail.com','buyer1','postcode1','01099233293','http://suunyvale.com/1','merchant1','msg1','name1','whatmethod1','pg1');
INSERT INTO payment(amount,buyer_addr,buyer_email,buyer_name,buyer_postcode,buyer_tel,m_redirect_url,merchant_uid,msg,name,pay_method,pg)
VALUES(2,'buyeraddr2','afa2@gmail.com','buyer2','postcode2','01099233291','http://suunyvale.com/2','merchant2','msg2','name2','whatmethod2','pg1');
INSERT INTO payment(amount,buyer_addr,buyer_email,buyer_name,buyer_postcode,buyer_tel,m_redirect_url,merchant_uid,msg,name,pay_method,pg)
VALUES(3,'buyeraddr3','afa3@gmail.com','buyer3','postcode3','01099233292','http://suunyvale.com/3','merchant3','msg3','name3','whatmethod3','pg1');
INSERT INTO payment(amount,buyer_addr,buyer_email,buyer_name,buyer_postcode,buyer_tel,m_redirect_url,merchant_uid,msg,name,pay_method,pg)
VALUES(4,'buyeraddr4','afa4@gmail.com','buyer4','postcode4','01099233294','http://suunyvale.com/4','merchant4','msg4','name4','whatmethod4','pg1');
INSERT INTO payment(amount,buyer_addr,buyer_email,buyer_name,buyer_postcode,buyer_tel,m_redirect_url,merchant_uid,msg,name,pay_method,pg)
VALUES(5,'buyeraddr5','afa5@gmail.com','buyer5','postcode5','01099233295','http://suunyvale.com/5','merchant5','msg5','name5','whatmethod5','pg1');
INSERT INTO payment(amount,buyer_addr,buyer_email,buyer_name,buyer_postcode,buyer_tel,m_redirect_url,merchant_uid,msg,name,pay_method,pg)
VALUES(6,'buyeraddr6','afa6@gmail.com','buyer6','postcode6','01099233296','http://suunyvale.com/6','merchant6','msg6','name6','whatmethod6','pg1');
INSERT INTO payment(amount,buyer_addr,buyer_email,buyer_name,buyer_postcode,buyer_tel,m_redirect_url,merchant_uid,msg,name,pay_method,pg)
VALUES(7,'buyeraddr7','afa7@gmail.com','buyer7','postcode7','01099233297','http://suunyvale.com/7','merchant7','msg7','name7','whatmethod7','pg1');
INSERT INTO payment(amount,buyer_addr,buyer_email,buyer_name,buyer_postcode,buyer_tel,m_redirect_url,merchant_uid,msg,name,pay_method,pg)
VALUES(8,'buyeraddr8','afa8@gmail.com','buyer8','postcode8','01099233298','http://suunyvale.com/8','merchant8','msg8','name8','whatmethod8','pg1');
INSERT INTO payment(amount,buyer_addr,buyer_email,buyer_name,buyer_postcode,buyer_tel,m_redirect_url,merchant_uid,msg,name,pay_method,pg)
VALUES(9,'buyeraddr9','afa9@gmail.com','buyer9','postcode9','01099233299','http://suunyvale.com/9','merchant9','msg9','name9','whatmethod9','pg1');
INSERT INTO payment(amount,buyer_addr,buyer_email,buyer_name,buyer_postcode,buyer_tel,m_redirect_url,merchant_uid,msg,name,pay_method,pg)
VALUES(10,'buyeraddr10','afa10@gmail.com','buyer10','postcode10','01099233212','http://suunyvale.com/10','merchant10','msg10','name10','whatmethod10','pg1');
INSERT INTO payment(amount,buyer_addr,buyer_email,buyer_name,buyer_postcode,buyer_tel,m_redirect_url,merchant_uid,msg,name,pay_method,pg)
VALUES(11,'buyeraddr11','afa11@gmail.com','buyer11','postcode11','01099233231','http://suunyvale.com/11','merchant11','msg11','name11','whatmethod11','pg1');
INSERT INTO payment(amount,buyer_addr,buyer_email,buyer_name,buyer_postcode,buyer_tel,m_redirect_url,merchant_uid,msg,name,pay_method,pg)
VALUES(12,'buyeraddr12','afa12@gmail.com','buyer12','postcode12','01099233232','http://suunyvale.com/12','merchant12','msg12','name12','whatmethod12','pg1');
INSERT INTO payment(amount,buyer_addr,buyer_email,buyer_name,buyer_postcode,buyer_tel,m_redirect_url,merchant_uid,msg,name,pay_method,pg)
VALUES(13,'buyeraddr13','afa13@gmail.com','buyer13','postcode13','01099233233','http://suunyvale.com/13','merchant13','msg13','name13','whatmethod13','pg1');
INSERT INTO payment(amount,buyer_addr,buyer_email,buyer_name,buyer_postcode,buyer_tel,m_redirect_url,merchant_uid,msg,name,pay_method,pg)
VALUES(14,'buyeraddr14','afa14@gmail.com','buyer14','postcode14','01099233234','http://suunyvale.com/14','merchant14','msg14','name14','whatmethod14','pg1');
INSERT INTO payment(amount,buyer_addr,buyer_email,buyer_name,buyer_postcode,buyer_tel,m_redirect_url,merchant_uid,msg,name,pay_method,pg)
VALUES(15,'buyeraddr15','afa15@gmail.com','buyer15','postcode15','01099233234','http://suunyvale.com/15','merchant15','msg15','name15','whatmethod15','pg1');
INSERT INTO payment(amount,buyer_addr,buyer_email,buyer_name,buyer_postcode,buyer_tel,m_redirect_url,merchant_uid,msg,name,pay_method,pg)
VALUES(16,'buyeraddr16','afa16@gmail.com','buyer16','postcode16','01099233236','http://suunyvale.com/16','merchant16','msg16','name16','whatmethod16','pg1');
INSERT INTO payment(amount,buyer_addr,buyer_email,buyer_name,buyer_postcode,buyer_tel,m_redirect_url,merchant_uid,msg,name,pay_method,pg)
VALUES(17,'buyeraddr17','afa17@gmail.com','buyer17','postcode17','01099233237','http://suunyvale.com/17','merchant17','msg17','name17','whatmethod17','pg1');
INSERT INTO payment(amount,buyer_addr,buyer_email,buyer_name,buyer_postcode,buyer_tel,m_redirect_url,merchant_uid,msg,name,pay_method,pg)
VALUES(18,'buyeraddr18','afa18@gmail.com','buyer18','postcode18','01099233238','http://suunyvale.com/18','merchant18','msg18','name18','whatmethod18','pg1');
INSERT INTO payment(amount,buyer_addr,buyer_email,buyer_name,buyer_postcode,buyer_tel,m_redirect_url,merchant_uid,msg,name,pay_method,pg)
VALUES(19,'buyeraddr19','afa19@gmail.com','buyer19','postcode19','01099233239','http://suunyvale.com/19','merchant19','msg19','name19','whatmethod19','pg1');
INSERT INTO payment(amount,buyer_addr,buyer_email,buyer_name,buyer_postcode,buyer_tel,m_redirect_url,merchant_uid,msg,name,pay_method,pg)
VALUES(20,'buyeraddr20','afa20@gmail.com','buyer20','postcode20','01099233240','http://suunyvale.com/20','merchant20','msg20','name20','whatmethod20','pg1');
INSERT INTO payment(amount,buyer_addr,buyer_email,buyer_name,buyer_postcode,buyer_tel,m_redirect_url,merchant_uid,msg,name,pay_method,pg)
VALUES(21,'buyeraddr21','afa21@gmail.com','buyer21','postcode21','01099233251','http://suunyvale.com/21','merchant21','msg21','name21','whatmethod21','pg1');
INSERT INTO payment(amount,buyer_addr,buyer_email,buyer_name,buyer_postcode,buyer_tel,m_redirect_url,merchant_uid,msg,name,pay_method,pg)
VALUES(22,'buyeraddr22','afa22@gmail.com','buyer22','postcode22','01099233252','http://suunyvale.com/22','merchant22','msg22','name22','whatmethod22','pg1');
INSERT INTO payment(amount,buyer_addr,buyer_email,buyer_name,buyer_postcode,buyer_tel,m_redirect_url,merchant_uid,msg,name,pay_method,pg)
VALUES(23,'buyeraddr23','afa23@gmail.com','buyer23','postcode23','01099233256','http://suunyvale.com/23','merchant23','msg23','name23','whatmethod23','pg1');
INSERT INTO payment(amount,buyer_addr,buyer_email,buyer_name,buyer_postcode,buyer_tel,m_redirect_url,merchant_uid,msg,name,pay_method,pg)
VALUES(24,'buyeraddr24','afa24@gmail.com','buyer24','postcode24','01099233267','http://suunyvale.com/24','merchant24','msg24','name24','whatmethod24','pg1');
INSERT INTO payment(amount,buyer_addr,buyer_email,buyer_name,buyer_postcode,buyer_tel,m_redirect_url,merchant_uid,msg,name,pay_method,pg)
VALUES(25,'buyeraddr25','afa25@gmail.com','buyer25','postcode25','01099233298','http://suunyvale.com/25','merchant25','msg25','name25','whatmethod25','pg1');
INSERT INTO payment(amount,buyer_addr,buyer_email,buyer_name,buyer_postcode,buyer_tel,m_redirect_url,merchant_uid,msg,name,pay_method,pg)
VALUES(26,'buyeraddr26','afa26@gmail.com','buyer26','postcode26','01099233277','http://suunyvale.com/26','merchant26','msg26','name26','whatmethod26','pg1');
INSERT INTO payment(amount,buyer_addr,buyer_email,buyer_name,buyer_postcode,buyer_tel,m_redirect_url,merchant_uid,msg,name,pay_method,pg)
VALUES(27,'buyeraddr27','afa27@gmail.com','buyer27','postcode27','01099233266','http://suunyvale.com/27','merchant27','msg27','name27','whatmethod27','pg1');
INSERT INTO payment(amount,buyer_addr,buyer_email,buyer_name,buyer_postcode,buyer_tel,m_redirect_url,merchant_uid,msg,name,pay_method,pg)
VALUES(28,'buyeraddr28','afa28@gmail.com','buyer28','postcode28','01099233296','http://suunyvale.com/28','merchant28','msg28','name28','whatmethod28','pg1');
INSERT INTO payment(amount,buyer_addr,buyer_email,buyer_name,buyer_postcode,buyer_tel,m_redirect_url,merchant_uid,msg,name,pay_method,pg)
VALUES(29,'buyeraddr29','afa29@gmail.com','buyer29','postcode29','01099233263','http://suunyvale.com/29','merchant29','msg29','name29','whatmethod29','pg1');
INSERT INTO payment(amount,buyer_addr,buyer_email,buyer_name,buyer_postcode,buyer_tel,m_redirect_url,merchant_uid,msg,name,pay_method,pg)
VALUES(30,'buyeraddr30','afa30@gmail.com','buyer30','postcode30','01099233267','http://suunyvale.com/30','merchant30','msg30','name30','whatmethod30','pg1');


INSERT INTO shipping(id, address, address_detail, message, phone, postcode, recipient, shipping_number, shipping_price, start_date, arrival_date, status)
VALUES (null, '인천광역시 미추홀구 토금북로28번길 15', '104호', '경비실에 맡겨주세요.', '010-8693-3454', '22186', '권은철', '305672231034', 3000, NULL, NULL, '입금 확인');
INSERT INTO shipping(id, address, address_detail, message, phone, postcode, recipient, shipping_number, shipping_price, start_date, arrival_date, status)
VALUES (null, '경기도 부천시 상일로 71', '1801동 739호', '집 앞에 놓아 주세요.', '010-2353-3462', '14597', '전민수', '897340523489', 3000, NULL, NULL, '배송 준비중');
INSERT INTO shipping(id, address, address_detail, message, phone, postcode, recipient, shipping_number, shipping_price, start_date, arrival_date, status)
VALUES (null, '경기도 부천시 중동로 204', '1307동 107호', '부재 시 경비실에 맡겨주세요.', '010-3468-2359', '14581', '신용권', '702345368234', 0, NULL, NULL, '입금 확인');
INSERT INTO shipping(id, address, address_detail, message, phone, postcode, recipient, shipping_number, shipping_price, start_date, arrival_date, status)
VALUES (null, '경기 부천시 중동 1293-1', '104동 703호', '경비실에 맡겨주세요.', '010-6823-3453', '14533', '강경미', '345790702345', 3000, '2018-12-25 22:24:53', NULL, '배송중');
INSERT INTO shipping(id, address, address_detail, message, phone, postcode, recipient, shipping_number, shipping_price, start_date, arrival_date, status)
VALUES (null, '서울특별시 양천구 오목로15길 11', '602호', '배송 전 연락주세요.', '010-6893-9621', '07935', '신윤철', '709235240475', 3000, '2018-06-24 12:35:51', NULL, '배송 출발');
INSERT INTO shipping(id, address, address_detail, message, phone, postcode, recipient, shipping_number, shipping_price, start_date, arrival_date, status)
VALUES (null, '서울특별시 양천구 중앙로29길 108', '102동 803호', '부재 시 경비실에 맡겨주세요.', '010-6983-3456', '08060', '김규민', '857239034985', 3000, '2018-04-23 18:24:34', NULL, '배송중');
INSERT INTO shipping(id, address, address_detail, message, phone, postcode, recipient, shipping_number, shipping_price, start_date, arrival_date, status)
VALUES (null, '서울특별시 양천구 목동서로 340', '901동 402호', '집 앞에 놓아 주세요.', '010-9682-9862', '08089', '주미선', '520456789234', 3000, '2018-04-23 18:24:34', '2018-04-26 17:34:35', '배송 완료');
INSERT INTO shipping(id, address, address_detail, message, phone, postcode, recipient, shipping_number, shipping_price, start_date, arrival_date, status)
VALUES (null, '서울특별시 영등포구 당산로 68', '102동 1023호', '부재 시 경비실에 맡겨주세요.', '010-9825-0286', '07292', '최재용', '502734898750', 3000, '2018-12-23 13:24:12', NULL, '배송중');
INSERT INTO shipping(id, address, address_detail, message, phone, postcode, recipient, shipping_number, shipping_price, start_date, arrival_date, status)
VALUES (null, '서울특별시 영등포구 영중로 15', '302호', '배송 전 연락주세요.', '010-9826-0872', '07305', '김준형', '068923458964', 3000, NULL, NULL, '배송 준비중');
INSERT INTO shipping(id, address, address_detail, message, phone, postcode, recipient, shipping_number, shipping_price, start_date, arrival_date, status)
VALUES (null, '서울특별시 영등포구 도신로29길 28', '110동 309호', '배송 전 연락주세요.', '010-0972-9863', '07365', '장태희', '68934550245', 3000, NULL, NULL, '입금 확인');
INSERT INTO shipping(id, address, address_detail, message, phone, postcode, recipient, shipping_number, shipping_price, start_date, arrival_date, status)
VALUES (null, '서울특별시 영등포구 여의나루로 76', '101호', '부재 시 경비실에 맡겨주세요.', '010-8629-9862', '07329', '정시윤', '798345893402', 0, '2018-10-17 13:52:11', NULL, '배송중');
INSERT INTO shipping(id, address, address_detail, message, phone, postcode, recipient, shipping_number, shipping_price, start_date, arrival_date, status)
VALUES (null, '서울특별시 영등포구 여의대방로 359', '302호', '경비실에 맡겨주세요.', '010-9862-0987', '07334', '김세화', '689235560289', 3000, NULL, NULL, '배송 준비중');
INSERT INTO shipping(id, address, address_detail, message, phone, postcode, recipient, shipping_number, shipping_price, start_date, arrival_date, status)
VALUES (null, '서울특별시 영등포구 국제금융로 106', '203호', '부재 시 경비실에 맡겨주세요.', '010-6578-6982', '07343', '장현준', '899823665948', 3000, NULL, NULL, '입금 확인');
INSERT INTO shipping(id, address, address_detail, message, phone, postcode, recipient, shipping_number, shipping_price, start_date, arrival_date, status)
VALUES (null, '서울특별시 마포구 마포대로 58', '5023호', '부재 시 경비실에 맡겨주세요.', '010-8962-9862', '04168', '윤지수', '134298734543', 3000, NULL, NULL, '입금 확인');
INSERT INTO shipping(id, address, address_detail, message, phone, postcode, recipient, shipping_number, shipping_price, start_date, arrival_date, status)
VALUES (null, '서울특별시 마포구 도화길 28', '110동 302호', '배송 전 연락주세요.', '010-7836-9862', '04170', '배대준', '235897463459', 0, '2018-05-24 13:53:12', NULL, '배송중');
INSERT INTO shipping(id, address, address_detail, message, phone, postcode, recipient, shipping_number, shipping_price, start_date, arrival_date, status)
VALUES (null, '서울특별시 마포구 백범로 205', '103동 604호', '부재 시 경비실에 맡겨주세요.', '010-9862-9861', '04194', '김지수', '789234678343', 0, '2018-09-23 18:23:35', '2018-09-24 21:32:53', '배송 완료');
INSERT INTO shipping(id, address, address_detail, message, phone, postcode, recipient, shipping_number, shipping_price, start_date, arrival_date, status)
VALUES (null, '서울특별시 용산구 임정로 26', '102호', '집 앞에 놓아 주세요.', '010-5678-9863', '04311', '김수정', '689234739485', 3000, '2018-12-31 09:59:12', '2019-01-04 13:34:41', '배송 완료');
INSERT INTO shipping(id, address, address_detail, message, phone, postcode, recipient, shipping_number, shipping_price, start_date, arrival_date, status)
VALUES (null, '서울특별시 성동구 독서당로 156', '8동 1023호', '배송 전 연락주세요.', '010-6892-3456', '04736', '김진선', '435925493334', 3000, NULL, NULL, '배송 준비중');
INSERT INTO shipping(id, address, address_detail, message, phone, postcode, recipient, shipping_number, shipping_price, start_date, arrival_date, status)
VALUES (null, '서울특별시 강남구 논현로 841', '스타벅스', '배송 전 연락주세요.', '010-6578-6782', '06031', '신원식', '345243998423', 3000, '2018-04-22 14:53:24', NULL, '배송중');
INSERT INTO shipping(id, address, address_detail, message, phone, postcode, recipient, shipping_number, shipping_price, start_date, arrival_date, status)
VALUES (null, '경기도 성남시 분당구 동판교로 123', '105동 302호', '부재 시 경비실에 맡겨주세요.', '010-2578-9863', '13528', '민경수', '235467682353', 3000, '2018-11-11 23:32:12', '2018-11-17 14:24:32', '배송 완료');
INSERT INTO shipping(id, address, address_detail, message, phone, postcode, recipient, shipping_number, shipping_price, start_date, arrival_date, status)
VALUES (null, '경기도 성남시 분당구 대왕판교로606번길 10', '103동 803호', '경비실에 맡겨주세요.', '010-9683-6982', '13530', '최다빈', '795239858344', 3500, '2018-06-11 15:24:34', NULL, '배송중');
INSERT INTO shipping(id, address, address_detail, message, phone, postcode, recipient, shipping_number, shipping_price, start_date, arrival_date, status)
VALUES (null, '경기도 성남시 분당구 백현로 100', '606호', '부재 시 경비실에 맡겨주세요.', '010-6892-6982', '13596', '김대인', '789235423894', 3000, NULL, NULL, '입금 확인');
INSERT INTO shipping(id, address, address_detail, message, phone, postcode, recipient, shipping_number, shipping_price, start_date, arrival_date, status)
VALUES (null, '경기 성남시 분당구 금곡동 305-2', '119동 203호', '배송 전 연락주세요.', '010-6872-6892', '13552', '문주현', '976983458634', 3000, NULL, NULL, '배송 준비중');
INSERT INTO shipping(id, address, address_detail, message, phone, postcode, recipient, shipping_number, shipping_price, start_date, arrival_date, status)
VALUES (null, '충청남도 천안시 서북구 시청로 39', '108동 803호', '배송 전 연락주세요.', '010-7192-1202', '31164', '박지호', '328956398534', 4000, NULL, NULL, '배송 준비중');
INSERT INTO shipping(id, address, address_detail, message, phone, postcode, recipient, shipping_number, shipping_price, start_date, arrival_date, status)
VALUES (null, '충청남도 아산시 배방읍 호서로79번길 20', '203호', '부재 시 경비실에 맡겨주세요.', '010-7582-6129', '31499', '차지형', '689235893535', 3000, NULL, NULL, '입금 확인');
INSERT INTO shipping(id, address, address_detail, message, phone, postcode, recipient, shipping_number, shipping_price, start_date, arrival_date, status)
VALUES (null, '충남 홍성군 홍북읍 신경리 928', '108동 304호', '배송 전 연락주세요.', '010-6892-7832', '32263', '김성박', '789235968234', 3000, '2018-12-09 20:34:12', NULL, '배송중');
INSERT INTO shipping(id, address, address_detail, message, phone, postcode, recipient, shipping_number, shipping_price, start_date, arrival_date, status)
VALUES (null, '대구 중구 남산동 3006', '102동 503호', '집 앞에 놓아 주세요.', '010-6398-9242', '41961', '이봉원', '709235678923', 3000, NULL, NULL, '입금 확인');
INSERT INTO shipping(id, address, address_detail, message, phone, postcode, recipient, shipping_number, shipping_price, start_date, arrival_date, status)
VALUES (null, '대구광역시 남구 성당로50길 33', '104호', '배송 전 연락주세요.', '010-5782-6823', '42400', '이세준', '689235687235', 2500, '2018-09-13 14:42:12', NULL, '배송중');
INSERT INTO shipping(id, address, address_detail, message, phone, postcode, recipient, shipping_number, shipping_price, start_date, arrival_date, status)
VALUES (null, '부산광역시 부산진구 동평로 352', '106동 305호', '부재 시 경비실에 맡겨주세요.', '010-5782-8728', '47206', '윤세현', '990896809098', 3000, '2018-12-11 15:21:23', NULL, '배송중');
INSERT INTO shipping(id, address, address_detail, message, phone, postcode, recipient, shipping_number, shipping_price, start_date, arrival_date, status)
VALUES (null, '제주특별자치도 제주시 첨단로 213-4', '102호', '배송 전 연락주세요.', '010-6384-6230', '63309', '김혜비', '435345345354', 3000, NULL, NULL, '입금 확인');


INSERT INTO orders (id, order_number, date, total_price, status, mileage, member_id, shipping_id, payment_id) VALUES(null, '2018110240057512', NOW(), 12000, '구매확정', 120, 2, 2, 2);
INSERT INTO orders (id, order_number, date, total_price, status, mileage, member_id, shipping_id, payment_id) VALUES(null, '2018110230057613', '2018-11-22', 12000, '구매확정', 120, 18, 3, 3);
INSERT INTO orders (id, order_number, date, total_price, status, mileage, member_id, shipping_id, payment_id) VALUES(null, '2018110360057614', '2018-10-01', 9000, '구매확정', 90, 18, 4, 4);
INSERT INTO orders (id, order_number, date, total_price, status, mileage, member_id, shipping_id, payment_id) VALUES(null, '2018110350057415', '2018-11-29', 6500, '구매확정', 60, 18, 5, 5);
INSERT INTO orders (id, order_number, date, total_price, status, mileage, member_id, shipping_id, payment_id) VALUES(null, '2018110350057516', '2018-11-01', 6500, '구매확정', 60, 3, 6, 6);
INSERT INTO orders (id, order_number, date, total_price, status, mileage, member_id, shipping_id, payment_id) VALUES(null, '2018111050067517', '2018-11-02', 4500, '구매확정', 40, 3, 7, 7);
INSERT INTO orders (id, order_number, date, total_price, status, mileage, member_id, shipping_id, payment_id) VALUES(null, '2018111060037518', NOW(), 10000, '구매확정', 100, 4, 8, 8);
INSERT INTO orders (id, order_number, date, total_price, status, mileage, member_id, shipping_id, payment_id) VALUES(null, '2018111050137519', NOW(), 14000, '구매확정', 140, 4, 9, 9);
INSERT INTO orders (id, order_number, date, total_price, status, mileage, member_id, shipping_id, payment_id) VALUES(null, '2018111050138510', NOW(), 4000, '구매확정', 40, 4, 10, 10);
INSERT INTO orders (id, order_number, date, total_price, status, mileage, member_id, shipping_id, payment_id) VALUES(null, '2018111750147511', '2018-11-30', 3000, '구매확정', 30, 5, 11, 11);
INSERT INTO orders (id, order_number, date, total_price, status, mileage, member_id, shipping_id, payment_id) VALUES(null, '2018111750137512', '2018-10-22', 3000, '구매확정', 30, 5, 12, 12);
INSERT INTO orders (id, order_number, date, total_price, status, mileage, member_id, shipping_id, payment_id) VALUES(null, '2018111950137513', '2018-11-11', 5500, '구매확정', 50, 18, 13, 13);
INSERT INTO orders (id, order_number, date, total_price, status, mileage, member_id, shipping_id, payment_id) VALUES(null, '2018111950137514', NOW(), 2500, '구매확정', 20, 6, 14, 14);
INSERT INTO orders (id, order_number, date, total_price, status, mileage, member_id, shipping_id, payment_id) VALUES(null, '2018112250137515', NOW(), 2500, '구매확정', 20, 6, 15, 15);
INSERT INTO orders (id, order_number, date, total_price, status, mileage, member_id, shipping_id, payment_id) VALUES(null, '2018112560137516', '2018-11-13', 1100, '구매확정', 10, 18, 16, 16);
INSERT INTO orders (id, order_number, date, total_price, status, mileage, member_id, shipping_id, payment_id) VALUES(null, '2018112560137517', '2018-12-05', 2200, '구매확정', 20, 18, 17, 17);
INSERT INTO orders (id, order_number, date, total_price, status, mileage, member_id, shipping_id, payment_id) VALUES(null, '2018112560137518', '2018-11-21', 5000, '구매확정', 50, 7, 18, 18);
INSERT INTO orders (id, order_number, date, total_price, status, mileage, member_id, shipping_id, payment_id) VALUES(null, '2018112560137519', '2018-11-01', 5000, '구매확정', 50, 9, 19, 19);
INSERT INTO orders (id, order_number, date, total_price, status, mileage, member_id, shipping_id, payment_id) VALUES(null, '2018112560137520', '2018-11-15', 3000, '구매확정', 30, 9, 20, 20);
INSERT INTO orders (id, order_number, date, total_price, status, mileage, member_id, shipping_id, payment_id) VALUES(null, '2018112560137521', '2018-09-01', 2000, '구매확정', 20, 11, 21, 21);
INSERT INTO orders (id, order_number, date, total_price, status, mileage, member_id, shipping_id, payment_id) VALUES(null, '2018113060137522', '2018-11-04', 3000, '구매확정', 30, 11, 22, 22);
INSERT INTO orders (id, order_number, date, total_price, status, mileage, member_id, shipping_id, payment_id) VALUES(null, '2018112560137523', '2016-10-10', 3000, '구매확정', 30, 22, 23, 23);
INSERT INTO orders (id, order_number, date, total_price, status, mileage, member_id, shipping_id, payment_id) VALUES(null, '2018112860137524', NOW(), 16000, '배송완료', 160, 15, 24, 24);
INSERT INTO orders (id, order_number, date, total_price, status, mileage, member_id, shipping_id, payment_id) VALUES(null, '2018112960137525', NOW(), 8000, '배송완료', 80, 17, 25, 25);
INSERT INTO orders (id, order_number, date, total_price, status, mileage, member_id, shipping_id, payment_id) VALUES(null, '2018112960137526', '2018-11-15', 3000, '배송완료', 30, 18, 26, 26);
INSERT INTO orders (id, order_number, date, total_price, status, mileage, member_id, shipping_id, payment_id) VALUES(null, '2018112960137527', NOW(), 3000, '배송완료', 30, 20, 27, 27);
INSERT INTO orders (id, order_number, date, total_price, status, mileage, member_id, shipping_id, payment_id) VALUES(null, '2018120360137528', '2018-11-11', 3000, '배송준비중', 30, 24, 28, 28);
INSERT INTO orders (id, order_number, date, total_price, status, mileage, member_id, shipping_id, payment_id) VALUES(null, '2018120360137529', '2018-09-11', 4500, '배송준비중', 40, 22, 29, 29);
INSERT INTO orders (id, order_number, date, total_price, status, mileage, member_id, shipping_id, payment_id) VALUES(null, '2018120360137530', '2018-10-29', 4500, '배송준비중', 40, 29, 22, 30);


-- INSERT INTO product_category (id,name,parent_id,orders) VALUES (1,'문구', 0 ,1);
-- INSERT INTO product_category (id,name,parent_id,orders) VALUES (2,'디자인', 0 ,2);
-- INSERT INTO product_category (id,name,parent_id,orders) VALUES (3,'다이어리/플래너',1,3);
-- INSERT INTO product_category (id,name,parent_id,orders) VALUES (4,'노트/메모지',1,4);
-- INSERT INTO product_category (id,name,parent_id,orders) VALUES (5,'데코레이션',1,5);
-- INSERT INTO product_category (id,name,parent_id,orders) VALUES (6,'포토앨범/레코드북',1,6);
-- INSERT INTO product_category (id,name,parent_id,orders) VALUES (7,'필기류/펜 케이스',1,7);
-- INSERT INTO product_category (id,name,parent_id,orders) VALUES (8,'카드/편지/봉투',1,8);
-- INSERT INTO product_category (id,name,parent_id,orders) VALUES (9,'파일링/바인더',1,9);
-- INSERT INTO product_category (id,name,parent_id,orders) VALUES (10,'오피스 용품',1,10);
-- INSERT INTO product_category (id,name,parent_id,orders) VALUES (11,'데스크 정리/보관',1,11);
-- INSERT INTO product_category (id,name,parent_id,orders) VALUES (12,'캐릭터문구',1,12);
-- INSERT INTO product_category (id,name,parent_id,orders) VALUES (13,'다이어리',2,13);
-- INSERT INTO product_category (id,name,parent_id,orders) VALUES (14,'오거나이저',2,14);
-- INSERT INTO product_category (id,name,parent_id,orders) VALUES (15,'스케쥴러/플래너',2,15);
-- INSERT INTO product_category (id,name,parent_id,orders) VALUES (16,'캘린더',2,16);
-- INSERT INTO product_category (id,name,parent_id,orders) VALUES (17,'베이직노트',3,17);
-- INSERT INTO product_category (id,name,parent_id,orders) VALUES (18,'하드커버 노트',3,18);
-- INSERT INTO product_category (id,name,parent_id,orders) VALUES (19,'바인더/6공 노트',3,19);
-- INSERT INTO product_category (id,name,parent_id,orders) VALUES (20,'스프링 노트',3,20);
-- INSERT INTO product_category (id,name,parent_id,orders) VALUES (21,'스탬프',4,21);
-- INSERT INTO product_category (id,name,parent_id,orders) VALUES (22,'스티커',4,22);
-- INSERT INTO product_category (id,name,parent_id,orders) VALUES (23,'앨범',5,23);
-- INSERT INTO product_category (id,name,parent_id,orders) VALUES (24,'미니앨범',5,24);
-- INSERT INTO product_category (id,name,parent_id,orders) VALUES (25,'필기구',6,25);
-- INSERT INTO product_category (id,name,parent_id,orders) VALUES (26,'고급필기류',6,26);
-- INSERT INTO product_category (id,name,parent_id,orders) VALUES (27,'카드',7,27);
-- INSERT INTO product_category (id,name,parent_id,orders) VALUES (28,'편지지',7,28);
-- INSERT INTO product_category (id,name,parent_id,orders) VALUES (29,'레이어 폴더/파일폴더',8,29);
-- INSERT INTO product_category (id,name,parent_id,orders) VALUES (30,'먼슬리플래너',14,30);
-- INSERT INTO product_category (id,name,parent_id,orders) VALUES (31,'위클리플래너',9,31);

INSERT INTO product_category (id,name,parent_id,orders) VALUES (NULL,'STATIONERY',0,1);
INSERT INTO product_category (id,name,parent_id,orders) VALUES (NULL,'TOY',0,2);
INSERT INTO product_category (id,name,parent_id,orders) VALUES (NULL,'필통/필기류',1,1);
INSERT INTO product_category (id,name,parent_id,orders) VALUES (NULL,'노트/메모',1,2);
INSERT INTO product_category (id,name,parent_id,orders) VALUES (NULL,'다이어리/캘린더',1,3);
INSERT INTO product_category (id,name,parent_id,orders) VALUES (NULL,'카드,엽서',1,4);
INSERT INTO product_category (id,name,parent_id,orders) VALUES (NULL,'ETC',1,5);
INSERT INTO product_category (id,name,parent_id,orders) VALUES (NULL,'HolidaySomething',2,1);
INSERT INTO product_category (id,name,parent_id,orders) VALUES (NULL,'HolidaySomething',3,2);
INSERT INTO product_category (id,name,parent_id,orders) VALUES (NULL,'HolidaySomething',4,2);
INSERT INTO product_category (id,name,parent_id,orders) VALUES (NULL,'HolidaySomething',5,2);
INSERT INTO product_category (id,name,parent_id,orders) VALUES (NULL,'오롤리데이',2,1);
INSERT INTO product_category (id,name,parent_id,orders) VALUES (NULL,'덴스',3,1);

INSERT INTO product_detail(id, description) VALUES (null, 'May가 추천하는 상점 공식 굿즈');
INSERT INTO product_detail(id, description) VALUES (null, 'Holii가 추천하는 상점 공식 굿즈');
INSERT INTO product_detail(id, description) VALUES (null, '‘훌리, 메이, 춘’ 세 사람이 추천하는 상점 공식 굿즈');
INSERT INTO product_detail(id, description) VALUES (null, '기념일 기쁘게 하다라는 뜻의 쥬빌레');
INSERT INTO product_detail(id, description) VALUES (null, '덴스만의 그래픽과 컬러감이 돋보이는 스프링 노트입니다. 귀엽고 키치한 그래픽과 비비드한 컬러감이 매력적인 아이템으로 150*210mm의 판형으로 필기나 드로잉 용도로 자유롭게 사용하기 좋은 사이즈며, 표지 외부는 반짝이는 유광 코팅으로 마감하였고 표지 내부는 산뜻한 그린 컬러로 한번 더 포인트를 주었습니다. 내지의 경우 4가지 컬러로 구성되어있어 더욱 재미있는 느낌을 주는 아이템입니다.');
INSERT INTO product_detail(id, description) VALUES (null, '글리터 다이어리의 새로운 컬러 버전 GLITTER DIARY_PINK 입니다. 영롱한 펄감과 개성있는 핑크 컬러의 매력이 돋보이는 제품으로, 나만의 특별한 다이어리로 간직하기에 좋습니다. 다이어리는 6공 링바인더와 내지 4종(YEARLY, MONTHLY, WEEKLY, GREEN), 반투명 PVC 파우치, 스티커로 구성되어 있습니다.');
INSERT INTO product_detail(id, description) VALUES (null, '매력적인 그라데이션 배색이 돋보이는 GRADATION DIARY_BLUE 입니다. 블루 컬러와 바이올렛, 민트가 조화롭게 그라데이션 된 제품으로, 스티커나 엽서를 더해 자신만의 느낌으로 꾸미기 좋고, 다이어리 그대로 간직하기도 좋습니다.  다이어리는 6공 링바인더와 내지 4종(YEARLY, MONTHLY, WEEKLY, GREEN), 반투명 PVC 파우치, 스티커로 구성되어 있습니다.');
INSERT INTO product_detail(id, description) VALUES (null, '핸디한 사이즈의 만년 플래너 입니다. PVC 커버 포켓에 사진을 넣으면 폴라로이드 사진처럼 연출되는 디자인으로 함께 구성된 삽지 또는 좋아하는 사진을 넣어 꾸며보세요. 동봉된 삽지는 양면 구성으로 넣는 방향에 따라 새로운 느낌을 줍니다.');
INSERT INTO product_detail(id, description) VALUES (null, '핸디한 사이즈감의 핑크색 하드커버 노트입니다. 군더더기 없는 디자인에 레드박 포인트가 인상적인 제품으로 총 128 페이지의 무선 노트로 구성되어 있습니다. 휴대하기 좋은 슬림한 형태의 하드커버 노트로 자유로운 노트로는 물론 매일을 기록하는 일기장으로 사용하기에도 좋습니다.');
INSERT INTO product_detail(id, description) VALUES (null, '핸디한 사이즈감의 개성적인 하드커버 노트입니다. 빈티지한 패턴 디자인에 블루 박 포인트가 인상적인 제품으로 총 128 페이지의 유선노트로 구성되어 있습니다. 휴대하기 좋은 슬림한 형태의 하트커버 노트로 자유로운 노트로는 물론 매일을 기록하는 일기장으로 사용하기도 좋습니다.');
INSERT INTO product_detail(id, description) VALUES (null, '덴스만의 컬러와 그래픽이 돋보이는 CAMPUS NOTE 시리즈 입니다. 유광 코팅 표지의 CAMPUS NOTE_PICKS는 총 48 페이지로 구성 되어 있으며, A5 정도의 사이즈 감으로 가볍게 휴대하기 편리합니다.');
INSERT INTO product_detail(id, description) VALUES (null, '덴스만의 컬러와 그래픽이 돋보이는 핸디 노트 MEMOBOOK 시리즈 입니다. 유광 코팅 된 표지와 주미의 미색 내지로 구성되어 형식의 구애 없이 사용하기 좋은 제품으로, 180도 펼칠 수 있는 사철 제본 방식을 사용해 튼튼하고 사용감이 좋으며 핸디한 사이즈로 휴대가 용이합니다.');
INSERT INTO product_detail(id, description) VALUES (null, '체킹리스트로 활용 할 수 있는 메모패드 입니다.  오늘 할일 정리, 준비물이나 쇼핑 목록을 확인할때 한 장씩 뜯어 요긴하게 사용할 수 있습니다.  10*14(CM)의 사이즈로 총 100장으로 구성되어 있으며  접착형이 아닌 비접착형으로 한 장씩 뜯어서 사용할 수 있도록 제작된 제품입니다. 구매에 참고해 주세요.');
INSERT INTO product_detail(id, description) VALUES (null, '꼭 필요한 아이템을 모아 하나로 구성하여 가벼운 필통으로 휴대할 수 있는 스테이셔너리 키트 입니다.  비비드한 색감의 컬러 라인 연필, 형광 컬러가 돋보이는 15cm 자, 하트 글리터 연필깎이,  간단히 메모할 수 있는 미니 사이즈의 메모패드가 핑크 컬러의 PVC 파우치와 함께 구성되어 있습니다.');
INSERT INTO product_detail(id, description) VALUES (null, '매력적인 그라데이션 배색이 돋보이는 GRADATION DIARY_ORANGE 입니다. 오렌지 컬러와 핑크, 그린이 조화롭게 그라데이션 된 제품으로, 스티커나 엽서를 더해 자신만의 느낌으로 꾸미기 좋고, 다이어리 그대로 간직하기도 좋습니다.  다이어리는 6공 링바인더와 내지 4종(YEARLY, MONTHLY, WEEKLY, GREEN), 반투명 PVC 파우치, 스티커로 구성되어 있습니다.');
INSERT INTO product_detail(id, description) VALUES (null, '펄감이 영롱한 글리터 PVC 커버와 내지 구성이 다양한 글리터 다이어리입니다. 심플한 글리터 PVC 커버로 나만의 다이어리로 다양하게 꾸밀 수 있어 재미있는 요소 중 하나입니다. 내부 구성은 링바인더와 내지 4종(YEARLY, MONTHLY, WEEKLY, COLOR PAPER(GREEN), 반투명 PVC파우치(SPECIAL STICKER)로 구성되어 있으며, 핸디한 사이즈 감으로 휴대가 용이합니다.');
INSERT INTO product_detail(id, description) VALUES (null, '덴스 6공 다이어리 전용으로 제작된 속지 세트입니다. 내지 구성은 총 4종으로 YEARLY, MONTHLY, WEEKLY, COLOR PAPER(GREEN) 구성되어 있습니다.');
INSERT INTO product_detail(id, description) VALUES (null, '덴스의 다이어리 리필 속지로 제작된 6공 노트 속지 입니다. 60 페이지 (30장) 1set으로 구성된 제품으로, 앞/뒷면 동일한 그리드로 인쇄되어 있습니다.');
INSERT INTO product_detail(id, description) VALUES (null, '16FW 시즌의 덴스 RING NOTE_WAY TO GO 전용 리필 속지 세트 입니다. 기존 링노트 속지와 동일한 수량의 내지 3종 1세트로 구성 되었습니다.');
INSERT INTO product_detail(id, description) VALUES (null, '시즌 테마 디자인이 담긴 홀로그램 스티커팩 VER.3 입니다. 14가지 디자인의 홀로그램 스티커로, 다양한 사이즈와 형태로 구성되어 나만의 공간과 사물에 특별함을 줍니다. 스티커가 담겨 있는 투명 지퍼백은 미니 파우치로 재사용이 가능합니다.');
INSERT INTO product_detail(id, description) VALUES (null, '덴스만의 그래픽과 다양한 사진으로 구성된 컨셉 스티커팩 VER.4 입니다. 13가지 스티커로 구성되어 있으며, 다양한 사이즈와 형태로 나만의 공간과 사물에 유쾌함을 줍니다. 스티커가 담겨있는 투명 지퍼백은 미니 파우치로 재사용이 가능합니다.');
INSERT INTO product_detail(id, description) VALUES (null, '스티커를 쉽게 붙였다 떼었다 할 수 있는 특수한 내지 종이로 만들어져 스티커 스크랩북으로 사용할 수 있는 노트입니다. 단품으로 사용하셔도 좋지만 직접 펀칭을 뚫어 덴스 링노트 또는 사용하고 있는 육공 다이어리의 내지로 활용 가능합니다.');
INSERT INTO product_detail(id, description) VALUES (null, '덴스만의 그래픽과 일러스트가 담긴 스티터팩 VER.7 입니다. 더욱 풍성해진 50가지 스티커로 구성되어 아낌없이 활용하실 수 있으며, 다양한 사이즈와 형태로 나만의 공간과 사물에 유쾌함을 줍니다. 스티커가 담겨 있는 투명 지퍼팩은 미니 파우치로 재사용이 가능합니다.');
INSERT INTO product_detail(id, description) VALUES (null, '움직이는 각도에 따라 보이는 면이 달라지는 렌티큘러 카드 입니다.  하트 그래픽과 문구가 돋보이는 렌티큘러 카드는 8X12(CM)의 사이즈로  특별한 날에 선물과 함께 전하기 좋으며, 노트를 꾸미거나 인테리어 소품 등으로 활용하기에도 좋습니다.');
INSERT INTO product_detail(id, description) VALUES (null, '크리스마스 분위기를 느낄 수 있는 유광코팅 엽서입니다. 특별한 날 사랑하는 사람에게 마음을 전하기에 좋으며, 엽서를 액자 속에 넣거나 벽에 스크랩해, 공간을 감각적으로 꾸밀 수 있습니다.');
INSERT INTO product_detail(id, description) VALUES (null, '덴스 로고가 인쇄된 실리콘 재질의 코인 파우치입니다. 코인이나 작은 악세서리 등을 담아 사용할 수 있으며, 키링으로 활용이 가능한 독특한 아이템입니다.');
INSERT INTO product_detail(id, description) VALUES (null, '부드럽고 보송보송한 후리스 재질의 미니 포켓입니다. 에어팟 등의 작은 소지품을 담아 다니기 좋은 아담한 사이즈로 컬러풀한 엘라스틱 밴드와 조이개로 오픈·클로징 되는 타입입니다. 오링이 함께 구성되어 있어서 키링을 달아주거나 넥스트링에 연결하여 다양하게 활용할 수 있습니다.');
INSERT INTO product_detail(id, description) VALUES (null, '귀여운 하트 팬던트와 글리터 스트랩으로 구성된 하트 금속 키홀더입니다. 체리와 슬로건, 레드컬러와 눈내리는 배경이 조화롭게 이루어진 하트 팬던트와 덴스 로고가 인쇄된 글리터 스트랩의 조합이 매력적인 아이템입니다. 다이어리나 가방, 포켓 등 다양한 곳에 매치하여 활용하기 좋은 제품입니다.');
INSERT INTO product_detail(id, description) VALUES (null, '덴스 로고 라벨과 어우러진 베레모입니다. 미니멀한 디자인으로 다양한 룩에 부담없이 어울리며, 안쪽의 리본으로 사이즈 조절이 가능한 아이템입니다.');
INSERT INTO product_detail(id, description) VALUES (null, '덴스 로고 라벨과 어우러진 장갑입니다. 깔끔하면서도 포인트가 되는 겨울 아이템으로 엄지, 검지, 중지 끝부분이 특수 전도 섬유로 제작되어 착용한 상태로 스마트폰이나 태블릿 PC 등의 조작이 가능해 실용적입니다.');


INSERT INTO product (id,code,manufacturer,name,optional_price_text,original_price,quantity,selling_price,shipping_price,product_category_id,product_detail_id,manufacturing_price, selling_quantity,safe_quantity,mileage,display,reg_date,manufacture_date,release_date)
VALUES (1,'2177670','서울 공장','스밋코구라시 데일리다이어리',NULL,1000,40,4000,2500,1,1,1, 0, 3, 0, true, '2018-12-25 14:22:00',  '2018-12-25 14:22:05',  '2018-12-25 14:22:05');
INSERT INTO product (id,code,manufacturer,name,optional_price_text,original_price,quantity,selling_price,shipping_price,product_category_id,product_detail_id,manufacturing_price, selling_quantity,safe_quantity,mileage,display,reg_date,manufacture_date,release_date)
VALUES (2,'2104689','경기도 공장','아이코닉 일상집 2019',NULL,1000,50,11800,2500,2,2,1, 0, 3, 0, false, '2018-12-25 14:22:05',  '2018-12-25 14:22:05',  '2018-12-25 14:22:05');
INSERT INTO product (id,code,manufacturer,name,optional_price_text,original_price,quantity,selling_price,shipping_price,product_category_id,product_detail_id,manufacturing_price, selling_quantity,safe_quantity,mileage,display,reg_date,manufacture_date,release_date)
VALUES (3,'2086287','인천 공장','바이풀디자인_세컨 플래너_미디움2019','오늘만공짜',2000,50,8500,2500,2,3,1, 0, 3, 0, true,  '2018-12-25 14:22:05',  '2018-12-25 14:22:05',  '2018-12-25 14:22:05' );
INSERT INTO product (id,code,manufacturer,name,optional_price_text,original_price,quantity,selling_price,shipping_price,product_category_id,product_detail_id,manufacturing_price, selling_quantity,safe_quantity,mileage,display,reg_date,manufacture_date,release_date)
VALUES (4,'2134984','강원도 공장','[루카랩]2019 플랜더 - 캘린더 겸 플래너',NULL,1000,40,15000,2500,3,4,1, 0, 3, 0, true,  '2018-12-25 14:22:05',  '2018-12-25 14:22:05',  '2018-12-25 14:22:05');
INSERT INTO product (id,code,manufacturer,name,optional_price_text,original_price,quantity,selling_price,shipping_price,product_category_id,product_detail_id,manufacturing_price, selling_quantity,safe_quantity,mileage,display,reg_date,manufacture_date,release_date)
VALUES (5,'2177678','서울 공장','스밋코구라시 좌철수첩',NULL,200,20,1000,2500,3,5,1, 0, 3, 0, true,  '2018-12-25 14:22:05',  '2018-12-25 14:22:05',  '2018-12-25 14:22:05');
INSERT INTO product (id,code,manufacturer,name,optional_price_text,original_price,quantity,selling_price,shipping_price,product_category_id,product_detail_id,manufacturing_price, selling_quantity,safe_quantity,mileage,display,reg_date,manufacture_date,release_date)
VALUES (6,'1846002','서울 공장','[디즈니] 빈티지 포스터 스티커 세트',NULL,50,10,6800,2500,4,6,1, 0, 3, 0, true,  '2018-12-25 14:22:05',  '2018-12-25 14:22:05',  '2018-12-25 14:22:05');
INSERT INTO product (id,code,manufacturer,name,optional_price_text,original_price,quantity,selling_price,shipping_price,product_category_id,product_detail_id,manufacturing_price, selling_quantity,safe_quantity,mileage,display,reg_date,manufacture_date,release_date)
VALUES (7,'279397','서울 공장','The Black-Photo album(ver.3.0)',NULL,2000,15,15800,3000,5,7,1, 0, 3, 0, true,  '2018-12-25 14:22:05',  '2018-12-25 14:22:05',  '2018-12-25 14:22:05');
INSERT INTO product (id,code,manufacturer,name,optional_price_text,original_price,quantity,selling_price,shipping_price,product_category_id,product_detail_id,manufacturing_price, selling_quantity,safe_quantity,mileage,display,reg_date,manufacture_date,release_date)
VALUES (8,'1904263','서울 공장','아이코닉 마일드 젤펜',NULL,100,10,1800,2500,2,8,1, 0, 3, 0, true,  '2018-12-25 14:22:05',  '2018-12-25 14:22:05',  '2018-12-25 14:22:05');
INSERT INTO product (id,code,manufacturer,name,optional_price_text,original_price,quantity,selling_price,shipping_price,product_category_id,product_detail_id,manufacturing_price, selling_quantity,safe_quantity,mileage,display,reg_date,manufacture_date,release_date)
VALUES (9,'974044','서울 공장','핸드메이드X-mas카드 (16종 중 택 1)',NULL,100,20,4000,2500,2,9,1, 0, 3, 0, true,  '2018-12-25 14:22:05',  '2018-12-25 14:22:05',  '2018-12-25 14:22:05');
INSERT INTO product (id,code,manufacturer,name,optional_price_text,original_price,quantity,selling_price,shipping_price,product_category_id,product_detail_id,manufacturing_price, selling_quantity,safe_quantity,mileage,display,reg_date,manufacture_date,release_date)
VALUES (10,'1916891','서울 공장','네모생활_클래식원고지',NULL,200,10,2500,2500,7,10,1, 0, 3, 0, true,  '2018-12-25 14:22:05',  '2018-12-25 14:22:05',  '2018-12-25 14:22:05');
INSERT INTO product (id,code,manufacturer,name,optional_price_text,original_price,quantity,selling_price,shipping_price,product_category_id,product_detail_id,manufacturing_price, selling_quantity,safe_quantity,mileage,display,reg_date,manufacture_date,release_date)
VALUES (11,'50709','경기도 공장','File F102(3ea)',NULL,2000,50,6600,2500,2,11,1, 0, 3, 0, true,  '2018-12-25 14:22:05',  '2018-12-25 14:22:05',  '2018-12-25 14:22:05');
INSERT INTO product (id,code,manufacturer,name,optional_price_text,original_price,quantity,selling_price,shipping_price,product_category_id,product_detail_id,manufacturing_price, selling_quantity,safe_quantity,mileage,display,reg_date,manufacture_date,release_date)
VALUES (12,'2102505','인천 공장','나의 색 나의 하루 스티커',NULL,50,50,1500,2500,1,12,1, 0, 3, 0, true,  '2018-12-25 14:22:05',  '2018-12-25 14:22:05',  '2018-12-25 14:22:05');
INSERT INTO product (id,code,manufacturer,name,optional_price_text,original_price,quantity,selling_price,shipping_price,product_category_id,product_detail_id,manufacturing_price, selling_quantity,safe_quantity,mileage,display,reg_date,manufacture_date,release_date)
VALUES (13,'2175906','인천 공장','러브이즈기빙 하트베어 광안리의 밤(2ea)',NULL,1000,50,6000,2500,6,13,1, 0, 3, 0, true,  '2018-12-25 14:22:05',  '2018-12-25 14:22:05',  '2018-12-25 14:22:05');
INSERT INTO product (id,code,manufacturer,name,optional_price_text,original_price,quantity,selling_price,shipping_price,product_category_id,product_detail_id,manufacturing_price, selling_quantity,safe_quantity,mileage,display,reg_date,manufacture_date,release_date)
VALUES (14,'2171036','인천 공장','꾸꾸 스티커',NULL,5,100,1500,2500,5,14,1, 0, 3, 0, true,  '2018-12-25 14:22:05',  '2018-12-25 14:22:05',  '2018-12-25 14:22:05');
INSERT INTO product (id,code,manufacturer,name,optional_price_text,original_price,quantity,selling_price,shipping_price,product_category_id,product_detail_id,manufacturing_price, selling_quantity,safe_quantity,mileage,display,reg_date,manufacture_date,release_date)
VALUES (15,'2160767','인천 공장','수바코_보석스티커',NULL,100,100,2500,2500,6,15,1, 0, 3, 0, true,  '2018-12-25 14:22:05',  '2018-12-25 14:22:05',  '2018-12-25 14:22:05');
INSERT INTO product (id,code,manufacturer,name,optional_price_text,original_price,quantity,selling_price,shipping_price,product_category_id,product_detail_id,manufacturing_price, selling_quantity,safe_quantity,mileage,display,reg_date,manufacture_date,release_date)
VALUES (16,'1792257','서울 공장','Hello, I am 내지노트 7종 -A5',NULL,500,20,3000,2500,6,16,1, 0, 3, 0, true,  '2018-12-25 14:22:05',  '2018-12-25 14:22:05',  '2018-12-25 14:22:05');
INSERT INTO product (id,code,manufacturer,name,optional_price_text,original_price,quantity,selling_price,shipping_price,product_category_id,product_detail_id,manufacturing_price, selling_quantity,safe_quantity,mileage,display,reg_date,manufacture_date,release_date)
VALUES (17,'2098234','서울 공장','버튼 오거나이저 V2 - A5 [커버+멀티파일]',NULL,1000,40,28000,2500,7,17,1, 0, 3, 0, true,  '2018-12-25 14:22:05',  '2018-12-25 14:22:05',  '2018-12-25 14:22:05');
INSERT INTO product (id,code,manufacturer,name,optional_price_text,original_price,quantity,selling_price,shipping_price,product_category_id,product_detail_id,manufacturing_price, selling_quantity,safe_quantity,mileage,display,reg_date,manufacture_date,release_date)
VALUES (18,'2102851','서울 공장','나의 색 나의 하루 노트',NULL,2000,200,9800,2500,7,18,1, 0, 3, 0, true,  '2018-12-25 14:22:05',  '2018-12-25 14:22:05',  '2018-12-25 14:22:05');
INSERT INTO product (id,code,manufacturer,name,optional_price_text,original_price,quantity,selling_price,shipping_price,product_category_id,product_detail_id,manufacturing_price, selling_quantity,safe_quantity,mileage,display,reg_date,manufacture_date,release_date)
VALUES (19,'2111083','서울 공장','[18루니툰]스케치북/컬렉터 에디션 L',NULL,10000,50,69300,2500,7,19,1, 0, 3, 0, true,  '2018-12-25 14:22:05',  '2018-12-25 14:22:05',  '2018-12-25 14:22:05');
INSERT INTO product (id,code,manufacturer,name,optional_price_text,original_price,quantity,selling_price,shipping_price,product_category_id,product_detail_id,manufacturing_price, selling_quantity,safe_quantity,mileage,display,reg_date,manufacture_date,release_date)
VALUES (20,'470057','강원도 공장','[주문제작] 퍼니맨 만년 원형 책도장',NULL,70,100,7800,2500,2,20,1, 0, 3, 0, true,  '2018-12-25 14:22:05',  '2018-12-25 14:22:05',  '2018-12-25 14:22:05');
INSERT INTO product (id,code,manufacturer,name,optional_price_text,original_price,quantity,selling_price,shipping_price,product_category_id,product_detail_id,manufacturing_price, selling_quantity,safe_quantity,mileage,display,reg_date,manufacture_date,release_date)
VALUES (21,'2154334','강원도 공장','하트 핑거 스탬프 잉크 스탬프패드 스탬프잉크 12색',NULL,1000,10,3000,2500,3,21,1, 0, 3, 0, true,  '2018-12-25 14:22:05',  '2018-12-25 14:22:05',  '2018-12-25 14:22:05');
INSERT INTO product (id,code,manufacturer,name,optional_price_text,original_price,quantity,selling_price,shipping_price,product_category_id,product_detail_id,manufacturing_price, selling_quantity,safe_quantity,mileage,display,reg_date,manufacture_date,release_date)
VALUES (22,'1901799','서울 공장','체크 수학 오답노트',NULL,100,10,2000,2500,4,22,1, 0, 3, 0, true,  '2018-12-25 14:22:05',  '2018-12-25 14:22:05',  '2018-12-25 14:22:05');
INSERT INTO product (id,code,manufacturer,name,optional_price_text,original_price,quantity,selling_price,shipping_price,product_category_id,product_detail_id,manufacturing_price, selling_quantity,safe_quantity,mileage,display,reg_date,manufacture_date,release_date)
VALUES (23,'2176209','서울 공장','위 베어 베어스 수학연습장 - 그리즐리',NULL,200,100,2500,2500,4,23,1, 0, 3, 0, true,  '2018-12-25 14:22:05',  '2018-12-25 14:22:05',  '2018-12-25 14:22:05');
INSERT INTO product (id,code,manufacturer,name,optional_price_text,original_price,quantity,selling_price,shipping_price,product_category_id,product_detail_id,manufacturing_price, selling_quantity,safe_quantity,mileage,display,reg_date,manufacture_date,release_date)
VALUES (24,'1889317','서울 공장','레트로 라이트 육공 모눈노트',NULL,4000,200,11000,2500,4,24,1, 0, 3, 0, true,  '2018-12-25 14:22:05',  '2018-12-25 14:22:05',  '2018-12-25 14:22:05');
INSERT INTO product (id,code,manufacturer,name,optional_price_text,original_price,quantity,selling_price,shipping_price,product_category_id,product_detail_id,manufacturing_price, selling_quantity,safe_quantity,mileage,display,reg_date,manufacture_date,release_date)
VALUES (25,'1621980','서울 공장','피키트 만년다이어리 커버 4종',NULL,4000,100,18000,2500,5,25,1, 0, 3, 0, true,  '2018-12-25 14:22:05',  '2018-12-25 14:22:05',  '2018-12-25 14:22:05');
INSERT INTO product (id,code,manufacturer,name,optional_price_text,original_price,quantity,selling_price,shipping_price,product_category_id,product_detail_id,manufacturing_price, selling_quantity,safe_quantity,mileage,display,reg_date,manufacture_date,release_date)
VALUES (26,'2123220','서울 공장','오거나이저 (중) 모던 버튼 3 Color',NULL,10000,100,58000,2500,6,26,1, 0, 3, 0, true,  '2018-12-25 14:22:05',  '2018-12-25 14:22:05',  '2018-12-25 14:22:05');
INSERT INTO product (id,code,manufacturer,name,optional_price_text,original_price,quantity,selling_price,shipping_price,product_category_id,product_detail_id,manufacturing_price, selling_quantity,safe_quantity,mileage,display,reg_date,manufacture_date,release_date)
VALUES (27,'2171171','경기도 공장','GROOVY DAYS DIARY - Sky Blue',NULL,2000,10,13500,2500,7,27,1, 0, 3, 0, true,  '2018-12-25 14:22:05',  '2018-12-25 14:22:05',  '2018-12-25 14:22:05');
INSERT INTO product (id,code,manufacturer,name,optional_price_text,original_price,quantity,selling_price,shipping_price,product_category_id,product_detail_id,manufacturing_price, selling_quantity,safe_quantity,mileage,display,reg_date,manufacture_date,release_date)
VALUES (28,'2170967','경기도 공장','정원 만년 다이어리',NULL,4000,20,15000,2500,6,28,1, 0, 3, 0, true,  '2018-12-25 14:22:05',  '2018-12-25 14:22:05',  '2018-12-25 14:22:05');
INSERT INTO product (id,code,manufacturer,name,optional_price_text,original_price,quantity,selling_price,shipping_price,product_category_id,product_detail_id,manufacturing_price, selling_quantity,safe_quantity,mileage,display,reg_date,manufacture_date,release_date)
VALUES (29,'2170965','경기도 공장','어두운숲 만년 다이어리',NULL,8000,50,15000,2500,5,29,1, 0, 3, 0, true,  '2018-12-25 14:22:05',  '2018-12-25 14:22:05',  '2018-12-25 14:22:05');
INSERT INTO product (id,code,manufacturer,name,optional_price_text,original_price,quantity,selling_price,shipping_price,product_category_id,product_detail_id,manufacturing_price, selling_quantity,safe_quantity,mileage,display,reg_date,manufacture_date,release_date)
VALUES (30,'2168986','경기도 공장','2019 럭스 Hologram 다이어리',NULL,10000,10,29800,2500,6,30,1, 0, 3, 0, true,  '2018-12-25 14:22:05',  '2018-12-25 14:22:05',  '2018-12-25 14:22:05');



INSERT INTO product_option (id,name,price,description,product_id) VALUES (1,'A타입',NULL,'뭐,,좋네요',1);
INSERT INTO product_option (id,name,price,description,product_id) VALUES (2,'B타입',NULL,'떨이',1);
INSERT INTO product_option (id,name,price,description,product_id) VALUES (3,'요가',NULL,'요가관련 상품',2);
INSERT INTO product_option (id,name,price,description,product_id) VALUES (4,'세탁실',NULL,NULL,2);
INSERT INTO product_option (id,name,price,description,product_id) VALUES (5,'꿈',NULL,NULL,2);
INSERT INTO product_option (id,name,price,description,product_id) VALUES (8,'저녁',NULL,NULL,2);
INSERT INTO product_option (id,name,price,description,product_id) VALUES (9,'카페',NULL,NULL,2);
INSERT INTO product_option (id,name,price,description,product_id) VALUES (10,'친구',NULL,'친구선물 용도',2);
INSERT INTO product_option (id,name,price,description,product_id) VALUES (16,'레드',NULL,NULL,4);
INSERT INTO product_option (id,name,price,description,product_id) VALUES (17,'블랙',NULL,NULL,4);
INSERT INTO product_option (id,name,price,description,product_id) VALUES (18,'옐로우',NULL,NULL,4);
INSERT INTO product_option (id,name,price,description,product_id) VALUES (19,'블루',NULL,NULL,4);
INSERT INTO product_option (id,name,price,description,product_id) VALUES (20,'그레이',NULL,NULL,4);
INSERT INTO product_option (id,name,price,description,product_id) VALUES (21,'스카이블루',200,NULL,4);
INSERT INTO product_option (id,name,price,description,product_id) VALUES (22,'그린',NULL,NULL,5);
INSERT INTO product_option (id,name,price,description,product_id) VALUES (23,'핑크',NULL,NULL,5);
INSERT INTO product_option (id,name,price,description,product_id) VALUES (24,'머스타드',NULL,'머스타드 ==> 겨자색',5);
INSERT INTO product_option (id,name,price,description,product_id) VALUES (25,'스카이블루',NULL,NULL,5);
INSERT INTO product_option (id,name,price,description,product_id) VALUES (26,'레드',NULL,NULL,12);
INSERT INTO product_option (id,name,price,description,product_id) VALUES (27,'블랙',NULL,NULL,12);
INSERT INTO product_option (id,name,price,description,product_id) VALUES (28,'그레이',2500,NULL,12);
INSERT INTO product_option (id,name,price,description,product_id) VALUES (29,'핑크',NULL,NULL,12);
INSERT INTO product_option (id,name,price,description,product_id) VALUES (30,'바이올렛',NULL,NULL,12);

INSERT INTO product_option (id,name,price,description,product_id) VALUES (31,'스카이블루',200,NULL,1);
INSERT INTO product_option (id,name,price,description,product_id) VALUES (32,'그린',NULL,NULL,1);
INSERT INTO product_option (id,name,price,description,product_id) VALUES (33,'핑크',NULL,NULL,1);
INSERT INTO product_option (id,name,price,description,product_id) VALUES (34,'머스타드',NULL,'머스타드 ==> 겨자색',1);
INSERT INTO product_option (id,name,price,description,product_id) VALUES (35,'블루',NULL,NULL,1);
INSERT INTO product_option (id,name,price,description,product_id) VALUES (36,'레드',NULL,NULL,1);
INSERT INTO product_option (id,name,price,description,product_id) VALUES (37,'블랙',NULL,NULL,1);
INSERT INTO product_option (id,name,price,description,product_id) VALUES (38,'그레이',2500,NULL,1);
INSERT INTO product_option (id,name,price,description,product_id) VALUES (39,'검정',NULL,NULL,1);
INSERT INTO product_option (id,name,price,description,product_id) VALUES (40,'바이올렛',NULL,NULL,1);


INSERT INTO ordered_product (order_price, quantity, mileage, personal_option, exchange_refund_id, order_id, product_id) VALUES(10000,1,100,NULL,NULL,1,1);
INSERT INTO ordered_product (order_price, quantity, mileage, personal_option, exchange_refund_id, order_id, product_id) VALUES(111000,2,300,NULL,NULL,21,1);
INSERT INTO ordered_product (order_price, quantity, mileage, personal_option, exchange_refund_id, order_id, product_id) VALUES(131000,3,400,NULL,NULL,3,1);
INSERT INTO ordered_product (order_price, quantity, mileage, personal_option, exchange_refund_id, order_id, product_id) VALUES(121000,4,2100,NULL,NULL,21,1);
INSERT INTO ordered_product (order_price, quantity, mileage, personal_option, exchange_refund_id, order_id, product_id) VALUES(151000,5,2300,NULL,NULL,11,5);
INSERT INTO ordered_product (order_price, quantity, mileage, personal_option, exchange_refund_id, order_id, product_id) VALUES(151000,6,2300,NULL,NULL,1,5);
INSERT INTO ordered_product (order_price, quantity, mileage, personal_option, exchange_refund_id, order_id, product_id) VALUES(141000,7,2100,NULL,NULL,21,5);
INSERT INTO ordered_product (order_price, quantity, mileage, personal_option, exchange_refund_id, order_id, product_id) VALUES(121000,8,2200,NULL,NULL,24,11);
INSERT INTO ordered_product (order_price, quantity, mileage, personal_option, exchange_refund_id, order_id, product_id) VALUES(112000,11,2100,NULL,11,21,21);
INSERT INTO ordered_product (order_price, quantity, mileage, personal_option, exchange_refund_id, order_id, product_id) VALUES(111000,1,2090,NULL,NULL,4,11);
INSERT INTO ordered_product (order_price, quantity, mileage, personal_option, exchange_refund_id, order_id, product_id) VALUES(11000,1,2000,NULL,NULL,7,2);
INSERT INTO ordered_product (order_price, quantity, mileage, personal_option, exchange_refund_id, order_id, product_id) VALUES(131000,1,2100,NULL,NULL,5,23);
INSERT INTO ordered_product (order_price, quantity, mileage, personal_option, exchange_refund_id, order_id, product_id) VALUES(1000,3,1200,NULL,NULL,11,9);
INSERT INTO ordered_product (order_price, quantity, mileage, personal_option, exchange_refund_id, order_id, product_id) VALUES(3000,88,3200,NULL,NULL,15,8);
INSERT INTO ordered_product (order_price, quantity, mileage, personal_option, exchange_refund_id, order_id, product_id) VALUES(18000,12,3200,NULL,NULL,19,1);
INSERT INTO ordered_product (order_price, quantity, mileage, personal_option, exchange_refund_id, order_id, product_id) VALUES(17000,23,2300,NULL,NULL,20,5);
INSERT INTO ordered_product (order_price, quantity, mileage, personal_option, exchange_refund_id, order_id, product_id) VALUES(61000,1,2500,NULL,NULL,21,30);
INSERT INTO ordered_product (order_price, quantity, mileage, personal_option, exchange_refund_id, order_id, product_id) VALUES(51000,2,2500,NULL,NULL,22,20);
INSERT INTO ordered_product (order_price, quantity, mileage, personal_option, exchange_refund_id, order_id, product_id) VALUES(81000,2,2500,NULL,NULL,12,10);
INSERT INTO ordered_product (order_price, quantity, mileage, personal_option, exchange_refund_id, order_id, product_id) VALUES(71000,3,2500,NULL,NULL,6,11);
INSERT INTO ordered_product (order_price, quantity, mileage, personal_option, exchange_refund_id, order_id, product_id) VALUES(91000,5,5200,NULL,NULL,2,23);
INSERT INTO ordered_product (order_price, quantity, mileage, personal_option, exchange_refund_id, order_id, product_id) VALUES(81000,7,1200,NULL,NULL,3,21);
INSERT INTO ordered_product (order_price, quantity, mileage, personal_option, exchange_refund_id, order_id, product_id) VALUES(71000,2,2200,NULL,NULL,7,22);
INSERT INTO ordered_product (order_price, quantity, mileage, personal_option, exchange_refund_id, order_id, product_id) VALUES(18000,21,3200,NULL,NULL,9,19);
INSERT INTO ordered_product (order_price, quantity, mileage, personal_option, exchange_refund_id, order_id, product_id) VALUES(23000,7,2400,NULL,NULL,10,21);
INSERT INTO ordered_product (order_price, quantity, mileage, personal_option, exchange_refund_id, order_id, product_id) VALUES(123000,9,2010,NULL,NULL,16,21);
INSERT INTO ordered_product (order_price, quantity, mileage, personal_option, exchange_refund_id, order_id, product_id) VALUES(14000,12,2100,NULL,NULL,12,15);
INSERT INTO ordered_product (order_price, quantity, mileage, personal_option, exchange_refund_id, order_id, product_id) VALUES(111000,12,2200,NULL,NULL,11,15);
INSERT INTO ordered_product (order_price, quantity, mileage, personal_option, exchange_refund_id, order_id, product_id) VALUES(119000,2,2300,NULL,NULL,20,24);
INSERT INTO ordered_product (order_price, quantity, mileage, personal_option, exchange_refund_id, order_id, product_id) VALUES(1100000,200,2400,NULL,NULL,23,11);

INSERT INTO product_image(id, category, file_type, original_file_name, path, reg_date, size, stored_file_name, update_date, product_id)
VALUES (null, 1, 'image/jpeg', 'KakaoTalk_Photo_2018-12-07-12-24-04-3.jpg', 'https://contents.sixshop.com/thumbnails/uploadedFiles/30497/product/image_1537526126133_2500.jpg', '2018-12-03 09:23:35', 13900.0, 'holidaymemopad', '2018-12-03 09:33:35', 1);
INSERT INTO product_image(id, category, file_type, original_file_name, path, reg_date, size, stored_file_name, update_date, product_id)
VALUES (null, 1, 'image/jpeg', 'KakaoTalk_Photo_2018-12-07-12-24-04-1.jpg', 'https://contents.sixshop.com/thumbnails/uploadedFiles/30497/product/image_1537526152021_2500.jpg', '2018-12-13 19:23:35', 23839, 'stickerpack', '2018-12-13 20:23:35', 2);
INSERT INTO product_image(id, category, file_type, original_file_name, path, reg_date, size, stored_file_name, update_date, product_id)
VALUES (null, 1, 'image/jpeg', 'KakaoTalk_Photo_2018-12-07-12-24-04-2.jpg', 'https://contents.sixshop.com/thumbnails/uploadedFiles/30497/product/image_1537526140470_2500.jpg', '2018-12-09 11:52:49', 23295, 'myownholiday', NULL, 3);
INSERT INTO product_image(id, category, file_type, original_file_name, path, reg_date, size, stored_file_name, update_date, product_id)
VALUES (null, 1, 'image/webp', '89734598-3598.webp', 'https://www.petitcolas.net/watermarking/image_database/waterfall.jpg', '2018-12-27 15:24:49', 23298, 'waterfall', NULL, 3);
INSERT INTO product_image(id, category, file_type, original_file_name, path, reg_date, size, stored_file_name, update_date, product_id)
VALUES (null, 1, 'image/jpeg', '86723953-9872.jpg', 'https://www.petitcolas.net/watermarking/image_database/water.jpg', '2017-03-31 17:34:09', 14529, 'water', '2017-04-02 11:24:52', 3);
INSERT INTO product_image(id, category, file_type, original_file_name, path, reg_date, size, stored_file_name, update_date, product_id)
VALUES (null, 1, 'image/gif', '34609583-3452.gif', 'https://www.petitcolas.net/watermarking/image_database/watch.jpg', '2018-08-07 11:52:49', 25389, 'watch', '2018-08-12 11:52:49', 4);
INSERT INTO product_image(id, category, file_type, original_file_name, path, reg_date, size, stored_file_name, update_date, product_id)
VALUES (null, 1, 'image/jpeg', '23865349-8346.jpg', 'https://www.petitcolas.net/watermarking/image_database/wildflowers.jpg', '2018-12-12 22:34:49', 7682, 'wildflowers', '2018-12-13 11:52:09', 5);
INSERT INTO product_image(id, category, file_type, original_file_name, path, reg_date, size, stored_file_name, update_date, product_id)
VALUES (null, 1, 'image/jpeg', '34689534-9734.jpg', 'https://www.petitcolas.net/watermarking/image_database/alu.jpg', '2018-04-22 07:52:49', 39872, 'alu', '2018-04-25 11:38:49', 6);
INSERT INTO product_image(id, category, file_type, original_file_name, path, reg_date, size, stored_file_name, update_date, product_id)
VALUES (null, 1, 'image/png', '27340985-3456.png', 'https://homepages.cae.wisc.edu/~ece533/images/tulips.png', '2018-11-11 11:52:49', 59872, 'tulips', '2018-12-09 11:52:49', 7);
INSERT INTO product_image(id, category, file_type, original_file_name, path, reg_date, size, stored_file_name, update_date, product_id)
VALUES (null, 1, 'image/jpeg', '68923545-7248.jpg', 'https://www.petitcolas.net/watermarking/image_database/bandon.jpg', '2018-12-25 19:34:49', 38972, 'bandon', '2018-12-26 11:52:49', 8);
INSERT INTO product_image(id, category, file_type, original_file_name, path, reg_date, size, stored_file_name, update_date, product_id)
VALUES (null, 2, 'image/webp', '38975343-2369.webp', 'https://www.petitcolas.net/watermarking/image_database/terraux.jpg', '2018-07-31 16:23:49', 23522, 'terraux', '2018-08-05 00:00:00', 9);
INSERT INTO product_image(id, category, file_type, original_file_name, path, reg_date, size, stored_file_name, update_date, product_id)
VALUES (null, 2, 'image/jpeg', '13068953-6389.jpg', 'https://www.petitcolas.net/watermarking/image_database/brandyrose.jpg', '2018-06-09 15:32:49', 135882, 'brandyrose', '2018-06-10 11:52:49', 10);
INSERT INTO product_image(id, category, file_type, original_file_name, path, reg_date, size, stored_file_name, update_date, product_id)
VALUES (null, 2, 'image/jpeg', '06892568-6980.jpg', 'https://www.petitcolas.net/watermarking/image_database/fourviere.jpg', '2018-04-09 10:52:49', 235892, 'fourviere', '2018-04-09 21:52:49', 11);
INSERT INTO product_image(id, category, file_type, original_file_name, path, reg_date, size, stored_file_name, update_date, product_id)
VALUES (null, 2, 'image/webp', '37489324-9383.webp', 'https://www.petitcolas.net/watermarking/image_database/bear.jpg', '2018-07-24 19:34:00', 63589, 'bear', '2018-07-26 14:52:34', 12);
INSERT INTO product_image(id, category, file_type, original_file_name, path, reg_date, size, stored_file_name, update_date, product_id)
VALUES (null, 2, 'image/jpeg', '36984323-3709.jpg', 'https://www.petitcolas.net/watermarking/image_database/kid.jpg', '2018-12-14 21:34:12', 89623, 'kid', NULL, 13);
INSERT INTO product_image(id, category, file_type, original_file_name, path, reg_date, size, stored_file_name, update_date, product_id)
VALUES (null, 2, 'image/gif', '62089452-6893.gif', 'https://www.petitcolas.net/watermarking/image_database/z1x25.jpg', '2018-12-19 11:52:49', 1983, 'z1x25', '2018-12-20 20:52:13', 14);
INSERT INTO product_image(id, category, file_type, original_file_name, path, reg_date, size, stored_file_name, update_date, product_id)
VALUES (null, 2, 'image/jpeg', '72364980-3679.jpg', 'https://www.petitcolas.net/watermarking/image_database/lochness.gif', '2018-11-01 10:52:33', 8962, 'lochness', '2018-11-10 11:52:50', 15);
INSERT INTO product_image(id, category, file_type, original_file_name, path, reg_date, size, stored_file_name, update_date, product_id)
VALUES (null, 2, 'image/jpeg', '27323476-7689.jpg', 'https://www.petitcolas.net/watermarking/image_database/papermachine.jpg', '2018-12-10 10:52:21', 7862, 'papermachine', '2018-12-10 09:52:49', 16);
INSERT INTO product_image(id, category, file_type, original_file_name, path, reg_date, size, stored_file_name, update_date, product_id)
VALUES (null, 2, 'image/jpeg', '23689542-7982.jpg', 'https://www.petitcolas.net/watermarking/image_database/skyline_arch.jpg', '2018-12-25 14:22:05', 49862, 'skyline_arch', '2019-01-03 11:24:14', 17);
INSERT INTO product_image(id, category, file_type, original_file_name, path, reg_date, size, stored_file_name, update_date, product_id)
VALUES (null, 2, 'image/webp', '28733452-9073.webp', 'https://www.petitcolas.net/watermarking/image_database/pueblo_bonito.jpg', '2018-12-24 10:52:42', 98763, 'pueblo_bonito', NULL, 18);
INSERT INTO product_image(id, category, file_type, original_file_name, path, reg_date, size, stored_file_name, update_date, product_id)
VALUES (null, 3, 'image/gif', '60893452-3638.gif', 'https://www.petitcolas.net/watermarking/image_database/newyork.gif', '2017-12-09 11:52:49', 308754, 'newyork', '2018-01-22 19:52:24', 19);
INSERT INTO product_image(id, category, file_type, original_file_name, path, reg_date, size, stored_file_name, update_date, product_id)
VALUES (null, 3, 'image/jpeg', '23465089-3790.jpg', 'https://www.petitcolas.net/watermarking/image_database/F14.jpg', '2018-12-11 18:24:04', 49762, 'F14', '2018-12-14 11:22:59', 20);
INSERT INTO product_image(id, category, file_type, original_file_name, path, reg_date, size, stored_file_name, update_date, product_id)
VALUES (null, 3, 'image/jpeg', '23764935-3698.jpg', 'https://www.petitcolas.net/watermarking/image_database/opera.jpg', '2018-12-18 11:54:34', 3498, 'opera', '2018-12-20 11:22:39', 21);
INSERT INTO product_image(id, category, file_type, original_file_name, path, reg_date, size, stored_file_name, update_date, product_id)
VALUES (null, 3, 'image/gif', '68235345-3456.gif', 'https://www.petitcolas.net/watermarking/image_database/arctic_hare.jpg', '2018-12-22 04:34:49', 8792, 'arctic_hare', '2018-12-23 20:52:34', 22);
INSERT INTO product_image(id, category, file_type, original_file_name, path, reg_date, size, stored_file_name, update_date, product_id)
VALUES (null, 3, 'image/jpeg', '06983645-2360.jpg', 'https://www.petitcolas.net/watermarking/image_database/baboon.jpg', '2018-10-09 17:22:42', 21984, 'baboon', '2018-10-11 12:52:22', 23);
INSERT INTO product_image(id, category, file_type, original_file_name, path, reg_date, size, stored_file_name, update_date, product_id)
VALUES (null, 3, 'image/gif', '60892345-6893.gif', 'https://www.petitcolas.net/watermarking/image_database/f16.jpg', '2018-12-29 14:52:49', 29843, 'f16', '2018-12-31 11:42:14', 24);
INSERT INTO product_image(id, category, file_type, original_file_name, path, reg_date, size, stored_file_name, update_date, product_id)
VALUES (null, 3, 'image/webp', '19874343-9834.webp', 'https://www.petitcolas.net/watermarking/image_database/fishingboat.jpg', '2018-02-08 11:22:23', 5983, 'fishingboat', '2018-02-11 09:54:29', 25);
INSERT INTO product_image(id, category, file_type, original_file_name, path, reg_date, size, stored_file_name, update_date, product_id)
VALUES (null, 3, 'image/jpeg', '63895234-3452.jpg', 'https://www.petitcolas.net/watermarking/image_database/lena.jpg', '2018-12-03 16:42:43', 49872, 'lena', NULL, 26);
INSERT INTO product_image(id, category, file_type, original_file_name, path, reg_date, size, stored_file_name, update_date, product_id)
VALUES (null, 3, 'image/jpeg', '23698423-5743.jpg', 'https://www.petitcolas.net/watermarking/image_database/peppers.jpg', '2018-12-21 12:22:42', 24983, 'peppers', '2018-12-23 18:52:42', 27);
INSERT INTO product_image(id, category, file_type, original_file_name, path, reg_date, size, stored_file_name, update_date, product_id)
VALUES (null, 3, 'image/jpeg', '68930523-4568.jpg', 'https://www.petitcolas.net/watermarking/image_database/pills.jpg', '2018-05-05 13:52:51', 13598, 'pills', '2018-05-14 11:52:49', 28);


INSERT INTO cart_product(price, quantity, member_id, product_id) VALUES (3000, 1, 1, 1);
INSERT INTO cart_product(price, quantity, member_id, product_id) VALUES (1000, 2, 2, 1);
INSERT INTO cart_product(price, quantity, member_id, product_id) VALUES (500, 1, 1, 2);
INSERT INTO cart_product(price, quantity, member_id, product_id) VALUES (2000, 4, 2, 1);
INSERT INTO cart_product(price, quantity, member_id, product_id) VALUES (1000, 5, 1, 2);
INSERT INTO cart_product(price, quantity, member_id, product_id) VALUES (1000, 7, 1, 1);
INSERT INTO cart_product(price, quantity, member_id, product_id) VALUES (1000, 4, 1, 2);
INSERT INTO cart_product(price, quantity, member_id, product_id) VALUES (1000, 5, 1, 1);
INSERT INTO cart_product(price, quantity, member_id, product_id) VALUES (1000, 9, 2, 1);
INSERT INTO cart_product(price, quantity, member_id, product_id) VALUES (1000, 10, 2, 2);
INSERT INTO cart_product(price, quantity, member_id, product_id) VALUES (1000, 4, 1, 1);
INSERT INTO cart_product(price, quantity, member_id, product_id) VALUES (1000, 2, 1, 1);
INSERT INTO cart_product(price, quantity, member_id, product_id) VALUES (1000, 5, 2, 2);
INSERT INTO cart_product(price, quantity, member_id, product_id) VALUES (1000, 1, 1, 1);
INSERT INTO cart_product(price, quantity, member_id, product_id) VALUES (1000, 1, 1, 1);
INSERT INTO cart_product(price, quantity, member_id, product_id) VALUES (1000, 2, 1, 3);
INSERT INTO cart_product(price, quantity, member_id, product_id) VALUES (1000, 1, 1, 1);
INSERT INTO cart_product(price, quantity, member_id, product_id) VALUES (1000, 1, 1, 1);
INSERT INTO cart_product(price, quantity, member_id, product_id) VALUES (1000, 14, 1, 1);
INSERT INTO cart_product(price, quantity, member_id, product_id) VALUES (1000, 3, 3, 1);
INSERT INTO cart_product(price, quantity, member_id, product_id) VALUES (1000, 2, 1, 1);
INSERT INTO cart_product(price, quantity, member_id, product_id) VALUES (1000, 1, 1, 1);
INSERT INTO cart_product(price, quantity, member_id, product_id) VALUES (1000, 5, 2, 1);
INSERT INTO cart_product(price, quantity, member_id, product_id) VALUES (1000, 2, 1, 1);
INSERT INTO cart_product(price, quantity, member_id, product_id) VALUES (1000, 3, 1, 1);
INSERT INTO cart_product(price, quantity, member_id, product_id) VALUES (1000, 1, 1, 1);
INSERT INTO cart_product(price, quantity, member_id, product_id) VALUES (1000, 1, 1, 1);
INSERT INTO cart_product(price, quantity, member_id, product_id) VALUES (1000, 2, 2, 1);
INSERT INTO cart_product(price, quantity, member_id, product_id) VALUES (1000, 2, 1, 1);
INSERT INTO cart_product(price, quantity, member_id, product_id) VALUES (1000, 1, 1, 1);
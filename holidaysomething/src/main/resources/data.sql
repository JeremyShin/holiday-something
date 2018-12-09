-- 12.07 insert OrderProduct, Payment
-- What is saved_money?


-- ORDERED_PRODUCTS insert 시 필요.
insert into EXCHANGE_REFUNDS(apply_date,approve,approve_date,price,type) values(now(),true,now(),1000,'what');

-- ORDERS insert 시 필요.
insert into MEMBERS(address1,address2,birthday,email,login_id,marketing,name,nickname,password,personal_info,phone,postcode,receive_email,receive_sms,recommender) values('seoul','seocho',now(),'koola976@gmail.com','koola',false,'choi','jdragon','pass1',false,'0102992929229','121313',false,false,'jeremy');
insert into PAYMENTS(amount,buyer_addr,buyer_email,buyer_name,buyer_postcode,buyer_tel,m_redirect_url,merchant_uid,msg,name,pay_method,pg) values(10,'abc','afa@gmail.com','haha','qwer','0101010101010','http://suunyvale.com','koo','good','what','whatmethod','pg1');
insert into SHIPPINGS(address,address_detail,arrival_date,message,phone,postcode,recipient,shipping_number,shipping_price,start_date,status) values('seoul','bangbae',now(),'message','010102912','postcode1','recipient1','shippingnum1',12131,now(),'Destroy');

-- ORDERED_PRODUCTS insert 시 필요.
insert into ORDERS(date,order_number,saved_money,status,total_price,member_id,payment_id,shipping_id) values(now(),'202020121',10000,'ststst',100000,1,1,1);

-- PRODUCTS insert 시 필요.
insert into PRODUCT_CATEGORIES(name,parent_id) values('category1',1);
insert into PRODUCT_DETAILS(description) values('하하하하하하하하하하');

-- ORDERED_PRODUCTS insert 시 필요.
insert into PRODUCTS(code,manufacturer,name,optional_price_text,original_price,quantity,selling_price,shipping_price,product_category_id,product_detail_id) values('code1','manu1','name1','free',1231,12,1231,232,1,1);


-- insert OrderedProduct (table = ORDERED_PRODUCTS)

insert into ORDERED_PRODUCTS(order_price,quantity,saved_money,exchange_refund_id, order_id, product_id)
  values(10000,1,100,null,1,1);
insert into ORDERED_PRODUCTS(order_price,quantity,saved_money,exchange_refund_id, order_id, product_id)
  values(111000,2,300,null,21,21);
insert into ORDERED_PRODUCTS(order_price,quantity,saved_money,exchange_refund_id, order_id, product_id)
  values(131000,3,400,null,3,4);
insert into ORDERED_PRODUCTS(order_price,quantity,saved_money,exchange_refund_id, order_id, product_id)
  values(121000,4,2100,null,21,3);
insert into ORDERED_PRODUCTS(order_price,quantity,saved_money,exchange_refund_id, order_id, product_id)
  values(151000,5,2300,null,11,24);
insert into ORDERED_PRODUCTS(order_price,quantity,saved_money,exchange_refund_id, order_id, product_id)
  values(151000,6,2300,null,1,12);
insert into ORDERED_PRODUCTS(order_price,quantity,saved_money,exchange_refund_id, order_id, product_id)
  values(141000,7,2100,null,21,29);
insert into ORDERED_PRODUCTS(order_price,quantity,saved_money,exchange_refund_id, order_id, product_id)
  values(121000,8,2200,null,24,11);
insert into ORDERED_PRODUCTS(order_price,quantity,saved_money,exchange_refund_id, order_id, product_id)
  values(112000,11,2100,11,21,21);
insert into ORDERED_PRODUCTS(order_price,quantity,saved_money,exchange_refund_id, order_id, product_id)
  values(111000,1,2090,null,4,11);






insert into ORDERED_PRODUCTS(order_price,quantity,saved_money,exchange_refund_id, order_id, product_id)
  values(11000,1,2000,null,7,2);
insert into ORDERED_PRODUCTS(order_price,quantity,saved_money,exchange_refund_id, order_id, product_id)
  values(131000,1,2100,null,5,1);
insert into ORDERED_PRODUCTS(order_price,quantity,saved_money,exchange_refund_id, order_id, product_id)
  values(1000,3,1200,null,11,9);
insert into ORDERED_PRODUCTS(order_price,quantity,saved_money,exchange_refund_id, order_id, product_id)
  values(3000,88,3200,null,15,8);
insert into ORDERED_PRODUCTS(order_price,quantity,saved_money,exchange_refund_id, order_id, product_id)
  values(18000,12,3200,null,19,17);
insert into ORDERED_PRODUCTS(order_price,quantity,saved_money,exchange_refund_id, order_id, product_id)
  values(17000,23,2300,null,20,11);
insert into ORDERED_PRODUCTS(order_price,quantity,saved_money,exchange_refund_id, order_id, product_id)
  values(61000,1,2500,null,21,30);
insert into ORDERED_PRODUCTS(order_price,quantity,saved_money,exchange_refund_id, order_id, product_id)
  values(51000,2,2500,null,22,20);
insert into ORDERED_PRODUCTS(order_price,quantity,saved_money,exchange_refund_id, order_id, product_id)
  values(81000,2,2500,null,12,10);
insert into ORDERED_PRODUCTS(order_price,quantity,saved_money,exchange_refund_id, order_id, product_id)
  values(71000,3,2500,null,6,11);





insert into ORDERED_PRODUCTS(order_price,quantity,saved_money,exchange_refund_id, order_id, product_id)
  values(91000,5,5200,null,2,23);
insert into ORDERED_PRODUCTS(order_price,quantity,saved_money,exchange_refund_id, order_id, product_id)
  values(81000,7,1200,null,3,21);
insert into ORDERED_PRODUCTS(order_price,quantity,saved_money,exchange_refund_id, order_id, product_id)
  values(71000,2,2200,null,7,22);
insert into ORDERED_PRODUCTS(order_price,quantity,saved_money,exchange_refund_id, order_id, product_id)
  values(18000,21,3200,null,9,19);
insert into ORDERED_PRODUCTS(order_price,quantity,saved_money,exchange_refund_id, order_id, product_id)
  values(23000,7,2400,null,10,17);
insert into ORDERED_PRODUCTS(order_price,quantity,saved_money,exchange_refund_id, order_id, product_id)
  values(123000,9,2010,null,16,13);
insert into ORDERED_PRODUCTS(order_price,quantity,saved_money,exchange_refund_id, order_id, product_id)
  values(14000,12,2100,null,12,11);
insert into ORDERED_PRODUCTS(order_price,quantity,saved_money,exchange_refund_id, order_id, product_id)
  values(111000,12,2200,null,11,8);
insert into ORDERED_PRODUCTS(order_price,quantity,saved_money,exchange_refund_id, order_id, product_id)
  values(119000,2,2300,null,20,7);
insert into ORDERED_PRODUCTS(order_price,quantity,saved_money,exchange_refund_id, order_id, product_id)
  values(1100000,200,2400,null,23,5);




-- insert Payment (table = PAYMENTS)

insert into PAYMENTS(amount,buyer_addr,buyer_email,buyer_name,buyer_postcode,buyer_tel,m_redirect_url,merchant_uid,msg,name,pay_method,pg)
  values(1,'buyeraddr1','afa1@gmail.com','buyer1','postcode1','01099233293','http://suunyvale.com/1','merchant1','msg1','name1','whatmethod1','pg1');
insert into PAYMENTS(amount,buyer_addr,buyer_email,buyer_name,buyer_postcode,buyer_tel,m_redirect_url,merchant_uid,msg,name,pay_method,pg)
  values(2,'buyeraddr2','afa2@gmail.com','buyer2','postcode2','01099233291','http://suunyvale.com/2','merchant2','msg2','name2','whatmethod2','pg1');
insert into PAYMENTS(amount,buyer_addr,buyer_email,buyer_name,buyer_postcode,buyer_tel,m_redirect_url,merchant_uid,msg,name,pay_method,pg)
  values(3,'buyeraddr3','afa3@gmail.com','buyer3','postcode3','01099233292','http://suunyvale.com/3','merchant3','msg3','name3','whatmethod3','pg1');
insert into PAYMENTS(amount,buyer_addr,buyer_email,buyer_name,buyer_postcode,buyer_tel,m_redirect_url,merchant_uid,msg,name,pay_method,pg)
  values(4,'buyeraddr4','afa4@gmail.com','buyer4','postcode4','01099233294','http://suunyvale.com/4','merchant4','msg4','name4','whatmethod4','pg1');
insert into PAYMENTS(amount,buyer_addr,buyer_email,buyer_name,buyer_postcode,buyer_tel,m_redirect_url,merchant_uid,msg,name,pay_method,pg)
  values(5,'buyeraddr5','afa5@gmail.com','buyer5','postcode5','01099233295','http://suunyvale.com/5','merchant5','msg5','name5','whatmethod5','pg1');
insert into PAYMENTS(amount,buyer_addr,buyer_email,buyer_name,buyer_postcode,buyer_tel,m_redirect_url,merchant_uid,msg,name,pay_method,pg)
  values(6,'buyeraddr6','afa6@gmail.com','buyer6','postcode6','01099233296','http://suunyvale.com/6','merchant6','msg6','name6','whatmethod6','pg1');
insert into PAYMENTS(amount,buyer_addr,buyer_email,buyer_name,buyer_postcode,buyer_tel,m_redirect_url,merchant_uid,msg,name,pay_method,pg)
  values(7,'buyeraddr7','afa7@gmail.com','buyer7','postcode7','01099233297','http://suunyvale.com/7','merchant7','msg7','name7','whatmethod7','pg1');
insert into PAYMENTS(amount,buyer_addr,buyer_email,buyer_name,buyer_postcode,buyer_tel,m_redirect_url,merchant_uid,msg,name,pay_method,pg)
  values(8,'buyeraddr8','afa8@gmail.com','buyer8','postcode8','01099233298','http://suunyvale.com/8','merchant8','msg8','name8','whatmethod8','pg1');
insert into PAYMENTS(amount,buyer_addr,buyer_email,buyer_name,buyer_postcode,buyer_tel,m_redirect_url,merchant_uid,msg,name,pay_method,pg)
  values(9,'buyeraddr9','afa9@gmail.com','buyer9','postcode9','01099233299','http://suunyvale.com/9','merchant9','msg9','name9','whatmethod9','pg1');
insert into PAYMENTS(amount,buyer_addr,buyer_email,buyer_name,buyer_postcode,buyer_tel,m_redirect_url,merchant_uid,msg,name,pay_method,pg)
  values(10,'buyeraddr10','afa10@gmail.com','buyer10','postcode10','01099233212','http://suunyvale.com/10','merchant10','msg10','name10','whatmethod10','pg1');



insert into PAYMENTS(amount,buyer_addr,buyer_email,buyer_name,buyer_postcode,buyer_tel,m_redirect_url,merchant_uid,msg,name,pay_method,pg)
  values(11,'buyeraddr11','afa11@gmail.com','buyer11','postcode11','01099233231','http://suunyvale.com/11','merchant11','msg11','name11','whatmethod11','pg1');
insert into PAYMENTS(amount,buyer_addr,buyer_email,buyer_name,buyer_postcode,buyer_tel,m_redirect_url,merchant_uid,msg,name,pay_method,pg)
  values(12,'buyeraddr12','afa12@gmail.com','buyer12','postcode12','01099233232','http://suunyvale.com/12','merchant12','msg12','name12','whatmethod12','pg1');
insert into PAYMENTS(amount,buyer_addr,buyer_email,buyer_name,buyer_postcode,buyer_tel,m_redirect_url,merchant_uid,msg,name,pay_method,pg)
  values(13,'buyeraddr13','afa13@gmail.com','buyer13','postcode13','01099233233','http://suunyvale.com/13','merchant13','msg13','name13','whatmethod13','pg1');
insert into PAYMENTS(amount,buyer_addr,buyer_email,buyer_name,buyer_postcode,buyer_tel,m_redirect_url,merchant_uid,msg,name,pay_method,pg)
  values(14,'buyeraddr14','afa14@gmail.com','buyer14','postcode14','01099233234','http://suunyvale.com/14','merchant14','msg14','name14','whatmethod14','pg1');
insert into PAYMENTS(amount,buyer_addr,buyer_email,buyer_name,buyer_postcode,buyer_tel,m_redirect_url,merchant_uid,msg,name,pay_method,pg)
  values(15,'buyeraddr15','afa15@gmail.com','buyer15','postcode15','01099233234','http://suunyvale.com/15','merchant15','msg15','name15','whatmethod15','pg1');
insert into PAYMENTS(amount,buyer_addr,buyer_email,buyer_name,buyer_postcode,buyer_tel,m_redirect_url,merchant_uid,msg,name,pay_method,pg)
  values(16,'buyeraddr16','afa16@gmail.com','buyer16','postcode16','01099233236','http://suunyvale.com/16','merchant16','msg16','name16','whatmethod16','pg1');
insert into PAYMENTS(amount,buyer_addr,buyer_email,buyer_name,buyer_postcode,buyer_tel,m_redirect_url,merchant_uid,msg,name,pay_method,pg)
  values(17,'buyeraddr17','afa17@gmail.com','buyer17','postcode17','01099233237','http://suunyvale.com/17','merchant17','msg17','name17','whatmethod17','pg1');
insert into PAYMENTS(amount,buyer_addr,buyer_email,buyer_name,buyer_postcode,buyer_tel,m_redirect_url,merchant_uid,msg,name,pay_method,pg)
  values(18,'buyeraddr18','afa18@gmail.com','buyer18','postcode18','01099233238','http://suunyvale.com/18','merchant18','msg18','name18','whatmethod18','pg1');
insert into PAYMENTS(amount,buyer_addr,buyer_email,buyer_name,buyer_postcode,buyer_tel,m_redirect_url,merchant_uid,msg,name,pay_method,pg)
  values(19,'buyeraddr19','afa19@gmail.com','buyer19','postcode19','01099233239','http://suunyvale.com/19','merchant19','msg19','name19','whatmethod19','pg1');
insert into PAYMENTS(amount,buyer_addr,buyer_email,buyer_name,buyer_postcode,buyer_tel,m_redirect_url,merchant_uid,msg,name,pay_method,pg)
  values(20,'buyeraddr20','afa20@gmail.com','buyer20','postcode20','01099233240','http://suunyvale.com/20','merchant20','msg20','name20','whatmethod20','pg1');






insert into PAYMENTS(amount,buyer_addr,buyer_email,buyer_name,buyer_postcode,buyer_tel,m_redirect_url,merchant_uid,msg,name,pay_method,pg)
  values(21,'buyeraddr21','afa21@gmail.com','buyer21','postcode21','01099233251','http://suunyvale.com/21','merchant21','msg21','name21','whatmethod21','pg1');
insert into PAYMENTS(amount,buyer_addr,buyer_email,buyer_name,buyer_postcode,buyer_tel,m_redirect_url,merchant_uid,msg,name,pay_method,pg)
  values(22,'buyeraddr22','afa22@gmail.com','buyer22','postcode22','01099233252','http://suunyvale.com/22','merchant22','msg22','name22','whatmethod22','pg1');
insert into PAYMENTS(amount,buyer_addr,buyer_email,buyer_name,buyer_postcode,buyer_tel,m_redirect_url,merchant_uid,msg,name,pay_method,pg)
  values(23,'buyeraddr23','afa23@gmail.com','buyer23','postcode23','01099233256','http://suunyvale.com/23','merchant23','msg23','name23','whatmethod23','pg1');
insert into PAYMENTS(amount,buyer_addr,buyer_email,buyer_name,buyer_postcode,buyer_tel,m_redirect_url,merchant_uid,msg,name,pay_method,pg)
  values(24,'buyeraddr24','afa24@gmail.com','buyer24','postcode24','01099233267','http://suunyvale.com/24','merchant24','msg24','name24','whatmethod24','pg1');
insert into PAYMENTS(amount,buyer_addr,buyer_email,buyer_name,buyer_postcode,buyer_tel,m_redirect_url,merchant_uid,msg,name,pay_method,pg)
  values(25,'buyeraddr25','afa25@gmail.com','buyer25','postcode25','01099233298','http://suunyvale.com/25','merchant25','msg25','name25','whatmethod25','pg1');
insert into PAYMENTS(amount,buyer_addr,buyer_email,buyer_name,buyer_postcode,buyer_tel,m_redirect_url,merchant_uid,msg,name,pay_method,pg)
  values(26,'buyeraddr26','afa26@gmail.com','buyer26','postcode26','01099233277','http://suunyvale.com/26','merchant26','msg26','name26','whatmethod26','pg1');
insert into PAYMENTS(amount,buyer_addr,buyer_email,buyer_name,buyer_postcode,buyer_tel,m_redirect_url,merchant_uid,msg,name,pay_method,pg)
  values(27,'buyeraddr27','afa27@gmail.com','buyer27','postcode27','01099233266','http://suunyvale.com/27','merchant27','msg27','name27','whatmethod27','pg1');
insert into PAYMENTS(amount,buyer_addr,buyer_email,buyer_name,buyer_postcode,buyer_tel,m_redirect_url,merchant_uid,msg,name,pay_method,pg)
  values(28,'buyeraddr28','afa28@gmail.com','buyer28','postcode28','01099233296','http://suunyvale.com/28','merchant28','msg28','name28','whatmethod28','pg1');
insert into PAYMENTS(amount,buyer_addr,buyer_email,buyer_name,buyer_postcode,buyer_tel,m_redirect_url,merchant_uid,msg,name,pay_method,pg)
  values(29,'buyeraddr29','afa29@gmail.com','buyer29','postcode29','01099233263','http://suunyvale.com/29','merchant29','msg29','name29','whatmethod29','pg1');
insert into PAYMENTS(amount,buyer_addr,buyer_email,buyer_name,buyer_postcode,buyer_tel,m_redirect_url,merchant_uid,msg,name,pay_method,pg)
  values(30,'buyeraddr30','afa30@gmail.com','buyer30','postcode30','01099233267','http://suunyvale.com/30','merchant30','msg30','name30','whatmethod30','pg1');



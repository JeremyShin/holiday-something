-- 12.07 insert OrderProduct, Payment

-- insert OrderedProduct (table = ORDERED_PRODUCTS)
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



insert into ORDERED_PRODUCTS(order_price,quantity,saved_money,exchange_refund_id, order_id, product_id)
  values(10000,1,100,null,1,1);
insert into ORDERED_PRODUCTS(order_price,quantity,saved_money,exchange_refund_id, order_id, product_id)
  values(11000,2,200,11,21,21);
insert into ORDERED_PRODUCTS(order_price,quantity,saved_money,exchange_refund_id, order_id, product_id)
  values(11000,2,200,12,3,4);
insert into ORDERED_PRODUCTS(order_price,quantity,saved_money,exchange_refund_id, order_id, product_id)
  values(11000,2,200,14,21,3);
insert into ORDERED_PRODUCTS(order_price,quantity,saved_money,exchange_refund_id, order_id, product_id)
  values(11000,2,200,13,11,24);
insert into ORDERED_PRODUCTS(order_price,quantity,saved_money,exchange_refund_id, order_id, product_id)
  values(11000,2,200,12,1,12);
insert into ORDERED_PRODUCTS(order_price,quantity,saved_money,exchange_refund_id, order_id, product_id)
  values(11000,2,200,17,21,29);
insert into ORDERED_PRODUCTS(order_price,quantity,saved_money,exchange_refund_id, order_id, product_id)
  values(11000,2,200,19,24,11);
insert into ORDERED_PRODUCTS(order_price,quantity,saved_money,exchange_refund_id, order_id, product_id)
  values(11000,2,200,11,21,21);










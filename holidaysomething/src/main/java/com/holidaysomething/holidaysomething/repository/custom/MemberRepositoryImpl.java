package com.holidaysomething.holidaysomething.repository.custom;

import com.holidaysomething.holidaysomething.domain.Member;
import com.holidaysomething.holidaysomething.domain.Order;
import com.holidaysomething.holidaysomething.domain.QMember;
import com.holidaysomething.holidaysomething.domain.QOrder;
import com.holidaysomething.holidaysomething.domain.QOrderedProduct;
import com.holidaysomething.holidaysomething.domain.QProduct;
import com.holidaysomething.holidaysomething.dto.SearchOrderMemberDto;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.dsl.Wildcard;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.hibernate.criterion.AggregateProjection;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import static com.querydsl.core.alias.Alias.*;




public class MemberRepositoryImpl extends QuerydslRepositorySupport implements
    MemberRepositoryCustom {

  // 반드시 지정해줘야 하는 생성자! QuerydslRepositorySupport 는 기본 생성자가 없기에
  // 여기서 지정해줘야한다??
  public MemberRepositoryImpl() {
    super(Member.class);
  }

  @PersistenceContext
  private EntityManager entityManager;

  // QMember 는 target/generated-sources 에 있음!
  // pom.xml 에 querydsl 관련 설정 해주고 mvn clean install 해줘야 생김.
  // 지금 repository에 만들어 놓은 검색쿼리3개를 여기서 다시 만들어주는건가??
  // 가져다 쓰는건가?? 다시 만들어줘야하는거 같은데???
  // if 문으로 경우에 따라 적용될 쿼리를 만들어주는건가...? 일단 자자.
  @Override
  public Member getMemberByDsl(Long id) {
    QMember qMember = QMember.member;  // querydsl plugin exec
    JPQLQuery<Member> jpqlQuery = from(qMember); // select m from Member m
    return jpqlQuery.where(qMember.id.eq(id)).fetchOne();
  }

  @Override
  public List<Member> getMembersByDsl(SearchOrderMemberDto searchOrderMemberDto,
      Pageable pageable) {
    QMember member = QMember.member;
    JPQLQuery query = from(member);

    if (searchOrderMemberDto.getLoginId() != null || !searchOrderMemberDto.getLoginId()
        .equals("")) {
      query.where(member.loginId.eq(searchOrderMemberDto.getLoginId()));
    }

    if (searchOrderMemberDto.getName() != null || !searchOrderMemberDto.getName().equals("")) {
      query.where(member.name.eq(searchOrderMemberDto.getName()));
    }

    return getQuerydsl().applyPagination(pageable, query).fetch();
  }

  @Override
  public List<Tuple> findMembersByLoginIdInOrdersByDsl(String loginId) {
    QMember member = QMember.member;
    //QMember member2 = QMember.member;
    QOrder order = QOrder.order;
    //QOrder order2 = new QOrder("order2");

    JPQLQuery query = from(member);
    //JPQLQuery<Member> query = from(member1);

    //JPAQueryFactory factory = new JPAQueryFactory(this.getEntityManager());

    //JPAQuery<Tuple> query = factory.select()

    /*
    select m1.*,k1.order_date,k1.order_number from member as m1
      inner join
	      (select o1.date as order_date, o1.order_number, o1.member_id from orders as o1
	        inner join
		        (select m2.id as member_id, max(o2.date) as date from orders as o2 inner join
			        member as m2 on o2.member_id=m2.id  where m2.login_id like '%sky%' group by m2.id) as k2
				on k2.member_id=o1.member_id and k2.date = o1.date) as k1
		on k1.member_id=m1.id;
     */

    //query.innerJoin(JPAExpressions.select(order1.date,order1.orderNumber,order1.member.id).from(order1)));
//    query.innerJoin((JPAExpressions.select(order1.date,order1.orderNumber,order1.member.id).from(order1)),"k");
    //query.innerJoin(order1,order1);
    //query.where(member1.id.eq(JPAExpressions.select(order.id.max()).from(order)));

//    1 단계 출력.
//    query.select(member.id,order.date.max())
//        .from(order)
//        .innerJoin(order.member, member).groupBy(member.id).where(member.loginId.contains(loginId));

    query.select(member.id, order.date, order.orderNumber)
        .from(member)
        .innerJoin(member.orders, order)
        .where(
            //member.loginId.contains(loginId),
            order.date
                .in(JPAExpressions.select(order.date.max())
                    .from(order).innerJoin(order.member, member)
                    .where(member.loginId.contains(loginId)).groupBy(member.id)));

    return query.fetch();
  }

  @Override
  public List<Tuple> findMembersByNameInOrdersByDsl(String name) {
    QMember member = QMember.member;
//    QMember member2 = new QMember("member2");
    QOrder order = QOrder.order;
//    QOrder order2 = new QOrder("order2");
//    QOrder order3 = new QOrder("order3");
//    Member qMember = alias(Member.class, "c");

    JPQLQuery query = from(member);

//    -- 회원 이름으로 검색하기.
//    select m1.*,k1.order_date,k1.order_number from member as m1 inner join
//    (select o1.date as order_date, o1.order_number, o1.member_id from orders as o1 inner join
//    (select m2.id as member_id, max(o2.date) as date from orders o2 inner join
//    member as m2 on o2.member_id=m2.id where m2.name like '%김하늘%' group by m2.id) as k2
//    on k2.member_id=o1.member_id and k2.date = o1.date) as k1 on k1.member_id=m1.id;

//    query.select(member1.id,order1.date,order1.orderNumber).from(member1,order1)
//        .innerJoin(member1.orders, order1)
//          .select(order2.date,order2.orderNumber,order2.member.id).from(order2)
//        .select(member2.id, order2.date.eq(JPAExpressions.select(order2.date.max()))).from(order3)
//        .innerJoin(member2.orders,order3).groupBy(member2.id).where(member2.name.contains(name))
//        .where(member1.loginId.contains(name));

    JPAQueryFactory factory = new JPAQueryFactory(this.getEntityManager());

//    JPQLQuery query = factory.select(member1.id,order1.id).from(member1,order1)
//        .innerJoin(order1.member, member1).from(member1).where(member1.name.contains(name));

    query.select(member.id, order.date, order.orderNumber)
        .from(member)
        .innerJoin(member.orders, order)
        .where(
            //member.loginId.contains(loginId),
            order.date
                .in(JPAExpressions.select(order.date.max())
                    .from(order).innerJoin(order.member, member)
                    .where(member.name.contains(name)).groupBy(member.id)));

//    query.select(order1.date,order1.orderNumber,order1.member.id)
//        .from(order1)
//          .select(query2).on(order1.member.id.eq(query2.member_id),order1.date.eq(query2.date));
//
//    JPQLQuery query3 = factory.select(member1,query.order_date,query.orderNumber)
//        .from(member1)
//          .select(query).on(member1.id.eq(query.member.id));

//    query.innerJoin(member.orders,order)
//        .select(order.date,order.orderNumber,order.id).innerJoin(order.member,member)

    //query.where(member.loginId.contains(loginId));
    return query.fetch();
  }


  @Override
  public List<Tuple> findMembersByProductNameInOrdersByDsl(String productName) {
    QMember member = QMember.member;
    QOrder order = QOrder.order;
    QProduct product = QProduct.product;
    QOrderedProduct orderedProduct = QOrderedProduct.orderedProduct;

    JPQLQuery query = from(member);


    /*
    select m.*, k.order_date,k.order_number from member as m inner join
	(select o.member_id,o.date as order_date,o.order_number from orders as o inner join
		(select max(o.date) as date,o.member_id from orders as o inner join
			(select distinct op.order_id from ordered_product as op inner join
			product as p on op.product_id in (select p.id from product as p where p.name like '%스밋코구라시%')) as op
		on op.order_id = o.id group by o.member_id) as k
	on k.date=o.date and k.member_id=o.member_id) as k
on k.member_id = m.id;
     */

    query.select(member.id, order.date, order.orderNumber).from(member)
        .innerJoin(member.orders, order)
        .where(
            //member.loginId.contains(loginId),
//            order.date
//                .in(JPAExpressions.select(order.date.max())
//                    .from(order).innerJoin(order.member, member)
//                    .groupBy(member.id)),
            order.date
                .in(JPAExpressions.select(orderedProduct.order.date.max())
                    .from(orderedProduct)
                    .innerJoin(orderedProduct.product, product)
                    .groupBy(orderedProduct.order.member.id)
                    .where(orderedProduct.product.id
                        .in(JPAExpressions.select(product.id)
                            .from(product)
                            .where(product.name.contains(productName))))),
            order.id
                .in(JPAExpressions.select(orderedProduct.order.id)
                    .from(orderedProduct)
                    .innerJoin(orderedProduct.product, product)
                    .groupBy(orderedProduct.order.id)
                    .where(orderedProduct.product.id
                        .in(JPAExpressions.select(product.id)
                            .from(product)
                            .where(product.name.contains(productName)))))

        );

    /* QueryDsl 에서 서브쿼리 인라인뷰는 불가능하다
      SELECT 문에 있는 서브쿼리 : 스칼라 서브쿼리
      FROM 절에 있는 서브쿼리 :  인라인 뷰
      WHERE 절에 있는 서브쿼리: 서브쿼리. 책에 나온 서브 쿼리 방식은 이제 사용 안한다.
      JPAExpressions 로 서브쿼리 사용하는 거 같은데... in 메소드에서만 사용해봤다.
      in 에서는 한가지 컬럼만 리턴 가능하다. 그래서 위 와 같은 개 똥 쿼리문이 나오는거다.
      네이티브 였으면 order.id, order.date 을 한번의 select 구문으로 받아올텐데
      in 으로 사용하다보니 위와같이 똑같은 구문을 두번 해줬다........
    */

//    query.select(orderedProduct.order.id).from(orderedProduct)
//        .innerJoin(orderedProduct.product , product).groupBy(orderedProduct.order.id)
//        .where(orderedProduct.product.id
//            .in(JPAExpressions.select(product.id)
//              .from(product)
//                .where(product.name.contains(productName))));

    return query.fetch();
  }


}




/*

28,29,30 일동안 만든 쿼리문인데... 개똥같다. 효율적인 코드는 아니라고 본다.
(ERD 구조가 잘못 되었을 수도... 여튼 출력은 성공함)

회원만 출력하는 거는 진~~즉에 끝났는데
최근 주문 날짜, 최근 주문한 주문 코드? 를 출력하게 만드느라고 엄청 오래 걸렸다.
이제 이걸 QueryDsl 로 만들면 되는데...........

-- 회원 로그인 아이디로 검색하기.
select m.*,k.order_date,k.order_number from member as m inner join
	(select o.date as order_date, o.order_number, o.member_id from orders as o inner join
		(select m.id as member_id, max(o.date) as date from orders o inner join
			member as m on o.member_id=m.id  where m.login_id like '%sky%' group by m.id) as k
				on k.member_id=o.member_id and k.date = o.date) as k on k.member_id=m.id;


-- 회원 이름으로 검색하기.
select m.*,k.order_date,k.order_number from member as m inner join
	(select o.date as order_date, o.order_number, o.member_id from orders as o inner join
		(select m.id as member_id, max(o.date) as date from orders o inner join
			member as m on o.member_id=m.id where m.name like '%김하늘%' group by m.id) as k
				on k.member_id=o.member_id and k.date = o.date) as k on k.member_id=m.id;

-- 주문기간 사이에 주문한 회원 검색하기.
select m.*,k.order_date,k.order_number from member as m inner join
	(select o.member_id,o.date as order_date,o.order_number from orders as o inner join
		(select o.member_id, max(o.date) as order_date from orders as o where o.date between '2018-11-01' and '2018-11-25' group by o.member_id) as k
	on o.member_id=k.member_id and o.date=k.order_date) as k
on k.member_id=m.id;


-- 주문번호에 해당하는 주문회원 검색하기.
select m.*,k.order_date,k.order_number from member as m inner join
	(select o.member_id,o.date as order_date,o.order_number from orders as o inner join
		(select o.member_id, max(o.date) as order_date from orders as o where o.order_number like '%2018111750147511%' group by o.member_id) as k
	on o.member_id=k.member_id and o.date=k.order_date) as k
on k.member_id=m.id;


-- 상품이름으로 해당 상품을 주문한 회원 검색하기.
select m.*, k.order_date,k.order_number from member as m inner join
	(select o.member_id,o.date as order_date,o.order_number from orders as o inner join
		(select max(o.date) as date,o.member_id from orders as o inner join
			(select distinct op.order_id from ordered_product as op inner join
			product as p on op.product_id in (select p.id from product as p where p.name like '%스밋코구라시%')) as op
		on op.order_id = o.id group by o.member_id) as k
	on k.date=o.date and k.member_id=o.member_id) as k
on k.member_id = m.id;


 */
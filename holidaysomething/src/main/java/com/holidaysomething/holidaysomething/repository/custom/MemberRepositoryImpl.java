package com.holidaysomething.holidaysomething.repository.custom;

import com.holidaysomething.holidaysomething.domain.Member;
import com.holidaysomething.holidaysomething.domain.QMember;
import com.holidaysomething.holidaysomething.domain.QOrder;
import com.holidaysomething.holidaysomething.dto.SearchOrderMemberDto;
import com.holidaysomething.holidaysomething.dto.SearchSexMemberDto;
import com.querydsl.jpa.JPQLQuery;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class MemberRepositoryImpl extends QuerydslRepositorySupport implements
    MemberRepositoryCustom {

  // 반드시 지정해줘야 하는 생성자! QuerydslRepositorySupport 는 기본 생성자가 없기에
  // 여기서 지정해줘야한다??
  public MemberRepositoryImpl() {
    super(Member.class);
  }

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
  public List<Member> findMembersByLoginIdInOrdersByDsl(String loginId) {
    QMember member = QMember.member;
    QOrder order = QOrder.order;

    JPQLQuery query = from(member);

    /*
    select m.*,k.order_date,k.order_number from member as m inner join
	(select o.date as order_date, o.order_number, o.member_id from orders as o inner join
		(select m.id as member_id, max(o.date) as date from orders o inner join
			member as m on o.member_id=m.id  where m.login_id like '%sky%' group by m.id) as k
				on k.member_id=o.member_id and k.date = o.date) as k on k.member_id=m.id;
     */





    return null;
  }


  @Override
  public List<Member> findMemberBySexInSearchByDsl(SearchSexMemberDto searchSexMemberDto, Pageable pageable) {
    QMember member = QMember.member;
    JPQLQuery query = from(member);

    if(searchSexMemberDto.getSex() != null || !searchSexMemberDto.getSex().equals("")) {
      query.where(member.sex.eq(searchSexMemberDto.getSex()));
    }

    return getQuerydsl().applyPagination(pageable, query).fetch();
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
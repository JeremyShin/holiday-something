package com.holidaysomething.holidaysomething.repository.custom;

import com.holidaysomething.holidaysomething.domain.Member;
import com.holidaysomething.holidaysomething.domain.Order;
import com.holidaysomething.holidaysomething.domain.Product;
import com.holidaysomething.holidaysomething.domain.QMember;
import com.holidaysomething.holidaysomething.domain.QOrder;
import com.holidaysomething.holidaysomething.dto.MemberSearchDto;
import com.holidaysomething.holidaysomething.dto.SearchOrderMemberDto;
import com.querydsl.core.types.SubQueryExpressionImpl;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.swing.text.DateFormatter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import sun.util.calendar.CalendarUtils;

@Slf4j
public class MemberRepositoryImpl extends QuerydslRepositorySupport implements
    MemberRepositoryCustom {

  JPAQueryFactory queryFactory;

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
  public Page<Member> searchMembers(MemberSearchDto memberSearchDto, Pageable pageable) {
    QMember qMember = QMember.member;
    QOrder qOrder = QOrder.order;

    JPQLQuery<Member> jpqlQuery = from(qMember);

    /* 검색 옵션 설정 : 아이디, 이메일, 전화번호, 닉네임, 주소 */
    String searchClassificationValue = memberSearchDto.getMemberSearchClassificationValue();
    String searchClassificationInput = memberSearchDto.getMemberSearchClassificationInput();

    if(searchClassificationValue != null){
      switch (searchClassificationValue){
        case "memberId" : jpqlQuery.from(qMember).where(qMember.loginId.like("%" + searchClassificationInput + "%")); break;
        case "memberName" : jpqlQuery.from(qMember).where(qMember.name.like("%" + searchClassificationInput + "%")); break;
        case "memberEmail" : jpqlQuery.from(qMember).where(qMember.email.like("%" + searchClassificationInput + "%")); break;
        case "memberPhone" : jpqlQuery.from(qMember).where(qMember.phone.like("%" + searchClassificationInput + "%")); break;
        case "memberNickname" : jpqlQuery.from(qMember).where(qMember.nickname.like("%" + searchClassificationInput + "%")); break;
        case "memberAddress" : jpqlQuery.from(qMember).where(qMember.address1.like("%" + searchClassificationInput + "%")
            .or(qMember.address2.like("%" + searchClassificationInput + "%"))); break;
      }
    } else {
      log.info("검색할 옵션을 선택하여주세요.");
    }

    /* 성별 */
    List<String> sexCheck = memberSearchDto.getMemberSexCheck();



//    if(sexCheck.size() != 0) {
    if(sexCheck != null) {
      log.info("성별배열의 사이즈는" + sexCheck.size());
      switch (sexCheck.size()) {
        case 1:
          jpqlQuery.where(qMember.sex.eq(sexCheck.get(0)));
          break;
        case 2:
          jpqlQuery.where(qMember.sex.eq(sexCheck.get(0))
                    .or(qMember.sex.eq(sexCheck.get(1))));
          break;
        case 3:
          jpqlQuery.where(qMember.sex.eq(sexCheck.get(0))
                    .or(qMember.sex.eq(sexCheck.get(1)))
                    .or(qMember.sex.eq(sexCheck.get(2))));
          break;
          default:
            break;
      }
    }

    /* 생일 */
//    String birthdayStart = memberSearchDto.getMemberBirthdayStart();
//    String birthdayEnd = memberSearchDto.getMemberBirthdayEnd();

//    if (!birthdayStart.equals("") && !birthdayEnd.equals("")) {
    if ((memberSearchDto.getMemberBirthdayStart() != null && memberSearchDto.getMemberBirthdayEnd() != null) &&
        (memberSearchDto.getMemberBirthdayStart().length() != 0 && memberSearchDto.getMemberBirthdayEnd().length() != 0 )) {
      SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd", Locale.KOREA);
      formatter.setTimeZone(TimeZone.getTimeZone("UTC"));

          String birthdayStart = memberSearchDto.getMemberBirthdayStart();
    String birthdayEnd = memberSearchDto.getMemberBirthdayEnd();

    log.info("제발그만...생일은 어떤값?" + memberSearchDto.getMemberBirthdayStart());
    log.info("String으로 받아준 후에는?" + birthdayStart);

    if(memberSearchDto.getMemberBirthdayStart() != null){
      log.info("널이아님");
      log.info("그래서 값은" + memberSearchDto.getMemberBirthdayStart());
    }else
      log.info("널임");


      try {
        Date startDate = formatter.parse(birthdayStart);
        Date endDate = formatter.parse(birthdayEnd);

        jpqlQuery.where(qMember.birthday.between(startDate, endDate));
      }catch (Exception e){
        e.printStackTrace();
      }
    }

    /* 가입일 */
    String regDateStart = memberSearchDto.getMemberRegDateStart();
    String regDateEnd = memberSearchDto.getMemberRegDateEnd();

    if ((regDateStart != null && regDateEnd != null) && (regDateStart.length() != 0  && regDateEnd.length() != 0)) {
      LocalDateTime startRegDateTime = LocalDateTime
          .parse(regDateStart, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));
       LocalDateTime endRegDateTime = LocalDateTime
          .parse(regDateEnd, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));

        jpqlQuery.where(qMember.regDate.between(startRegDateTime, endRegDateTime));
    }

    /* 주문일 */
    String orderDateStart = memberSearchDto.getMemberOrderDateStart();
    String orderDateEnd = memberSearchDto.getMemberOrderDateEnd();

    if ((orderDateStart != null && orderDateEnd != null) && (orderDateStart.length() != 0 && orderDateEnd.length() != 0)) {
      LocalDateTime startOrderDateTime = LocalDateTime
          .parse(orderDateStart, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));
      LocalDateTime endOrderDateTime = LocalDateTime
          .parse(orderDateEnd, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));

      jpqlQuery
          .where(qMember.id.in(
              JPAExpressions.select(qOrder.member.id)
                  .from(qOrder)
                  .where(qOrder.date.between(startOrderDateTime, endOrderDateTime))));
    }

    List<Member> members = getQuerydsl().applyPagination(pageable, jpqlQuery).fetch();
    long totalCount = jpqlQuery.fetchCount();

    return new PageImpl<>(members, pageable, totalCount);
  }


  //      // 특정 기간 사이에 있는 주문의 정보를 검색한다.
//      SELECT id, `date`, mileage, order_number, status, total_price, member_id
//      FROM orders
//      WHERE DATE(`date`) BETWEEN ‘2018-11-22 00:00:00’ AND ‘2018-12-31 00:00:00’
//      ORDER BY member_id;
//
//// 특정 기간에 주문한 회원의 정보를 검색한다.
//      SELECT id, address1, address2, birthday, email, login_id, marketing, mileage, name, nickname, password, personal_info, phone, post code, receive_email, receive_sms, recommender, reg_date, sex
//      FROM member
//      WHERE id = ANY(SELECT member_id FROM orders WHERE DATE(`date`) BETWEEN ‘2018-11-22 00:00:00’ AND ‘2018-12-31 00:00:00’);


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
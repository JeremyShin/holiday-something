package com.holidaysomething.holidaysomething.repository.custom;

import com.holidaysomething.holidaysomething.domain.Member;
import com.holidaysomething.holidaysomething.domain.QMember;
import com.holidaysomething.holidaysomething.domain.QOrder;
import com.holidaysomething.holidaysomething.domain.QOrderedProduct;
import com.holidaysomething.holidaysomething.domain.QProduct;
import com.holidaysomething.holidaysomething.dto.MemberSearchDto;
import com.holidaysomething.holidaysomething.dto.SearchOrderMemberDto;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.JPQLQuery;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

@Slf4j
public class MemberRepositoryImpl extends QuerydslRepositorySupport implements
    MemberRepositoryCustom {

  // 반드시 지정해줘야 하는 생성자! QuerydslRepositorySupport는 기본 생성자가 없기에
  // 여기서 지정해줘야한다??
  public MemberRepositoryImpl() {
    super(Member.class);
  }

  // QMember 는 target/generated-sources 에 있음!
  // pom.xml 에 querydsl 관련 설정 해주고 mvn clean install 해줘야 생김.
  // 지금 repository에 만들어 놓은 검색쿼리 3개를 여기서 다시 만들어주는건가??
  // 가져다 쓰는건가?? 다시 만들어줘야하는거 같은데???
  // if 문으로 경우에 따라 적용될 쿼리를 만들어주는건가...?

  @Override
  public Page<Member> searchMembers(MemberSearchDto memberSearchDto, Pageable pageable) {
    QMember qMember = QMember.member;
    QOrder qOrder = QOrder.order;

    JPQLQuery<Member> jpqlQuery = from(qMember);

    /* 검색 옵션 설정 : 아이디, 이메일, 전화번호, 닉네임, 주소 */
    String searchClassificationValue = memberSearchDto.getMemberSearchClassificationValue();
    String searchClassificationInput = memberSearchDto.getMemberSearchClassificationInput();

    if (searchClassificationValue != null) {
      switch (searchClassificationValue) {
        case "memberId":
          jpqlQuery.from(qMember)
              .where(qMember.loginId.like("%" + searchClassificationInput + "%"));
          break;
        case "memberName":
          jpqlQuery.from(qMember).where(qMember.name.like("%" + searchClassificationInput + "%"));
          break;
        case "memberEmail":
          jpqlQuery.from(qMember).where(qMember.email.like("%" + searchClassificationInput + "%"));
          break;
        case "memberPhone":
          jpqlQuery.from(qMember).where(qMember.phone.like("%" + searchClassificationInput + "%"));
          break;
        case "memberNickname":
          jpqlQuery.from(qMember)
              .where(qMember.nickname.like("%" + searchClassificationInput + "%"));
          break;
        case "memberAddress":
          jpqlQuery.from(qMember).where(qMember.address1.like("%" + searchClassificationInput + "%")
              .or(qMember.address2.like("%" + searchClassificationInput + "%")));
          break;
      }
    }

    /* 성별 */
    List<String> sexCheck = memberSearchDto.getMemberSexCheck();

    if (sexCheck != null) {
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

    if ((memberSearchDto.getMemberBirthdayStart() != null
        && memberSearchDto.getMemberBirthdayEnd() != null) &&
        (memberSearchDto.getMemberBirthdayStart().length() != 0
            && memberSearchDto.getMemberBirthdayEnd().length() != 0)) {

      String birthdayStart = memberSearchDto.getMemberBirthdayStart();
      String birthdayEnd = memberSearchDto.getMemberBirthdayEnd();

      try {
        LocalDate startDate = LocalDate.parse(birthdayStart);
        LocalDate endDate = LocalDate.parse(birthdayEnd);
        jpqlQuery.where(qMember.birthday.between(startDate, endDate));
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    /* 가입일 */
    String regDateStart = memberSearchDto.getMemberRegDateStart();
    String regDateEnd = memberSearchDto.getMemberRegDateEnd();

    if ((regDateStart != null && regDateEnd != null) && (regDateStart.length() != 0
        && regDateEnd.length() != 0)) {
      LocalDateTime startRegDateTime = LocalDateTime
          .parse(regDateStart, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));
      LocalDateTime endRegDateTime = LocalDateTime
          .parse(regDateEnd, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));

      jpqlQuery.where(qMember.regDate.between(startRegDateTime, endRegDateTime));
    }

    /* 주문일 */
    String orderDateStart = memberSearchDto.getMemberOrderDateStart();
    String orderDateEnd = memberSearchDto.getMemberOrderDateEnd();

    if ((orderDateStart != null && orderDateEnd != null) && (orderDateStart.length() != 0
        && orderDateEnd.length() != 0)) {
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

  /* QueryDsl 에서 서브쿼리 인라인뷰는 불가능하다
      SELECT 문에 있는 서브쿼리 : 스칼라 서브쿼리
      FROM 절에 있는 서브쿼리 :  인라인 뷰
      WHERE 절에 있는 서브쿼리: 서브쿼리. 책에 나온 서브 쿼리 방식은 이제 사용 안한다.
      JPAExpressions 로 서브쿼리 사용하는 거 같은데... in 메소드에서만 사용해봤다.
      in 에서는 한가지 컬럼만 리턴 가능하다. 그래서 위 와 같은 개 똥 쿼리문이 나오는거다.
      네이티브 였으면 order.id, order.date 을 한번의 select 구문으로 받아올텐데
      in 으로 사용하다보니 위와같이 똑같은 구문을 두번 해줬다........
    */
  /**
   * @author JDragon
   * member/order.html 에서 입력받은 데이터들을 ( Member.loginId, Member.name, Order.startDate
   * ~ Order.endDate, Order.orderNumber, Product.name ) 을 검색조건으로 해서 회원객체,최근주문날짜,최근주문번호를 검색하는
   * method.
   */
  @Override
  public Page<Tuple> getMembersByDsl(SearchOrderMemberDto searchOrderMemberDto,
      Pageable pageable) {

    QMember member = QMember.member;
    QOrder order = QOrder.order;
    QProduct product = QProduct.product;
    QOrderedProduct orderedProduct = QOrderedProduct.orderedProduct;

    // 공통적으로 쓰이는 innerjoin을 여기에 써주니까
    // 상품과, 기간 선택시 나타나는 1+n?? n+1?? 문제가 해결되었다...
    JPQLQuery query = from(member).innerJoin(member.orders, order);

    if (searchOrderMemberDto.getLoginId() != null
        && searchOrderMemberDto.getLoginId().length() != 0) {
      query.select(member, order.date, order.orderNumber)
          .where(
              order.date
                  .in(JPAExpressions.select(order.date.max())
                      .from(order)
                      .where(order.member.loginId.contains(searchOrderMemberDto.getLoginId()),
                          order.member.id.eq(member.id))
                      .groupBy(order.member.id)));
    }

    if (searchOrderMemberDto.getName() != null && searchOrderMemberDto.getName().length() != 0) {
      query.select(order.member, order.date, order.orderNumber)
          .where(
              order.date
                  .in(JPAExpressions.select(order.date.max())
                      .from(order)
                      .where(order.member.name.contains(searchOrderMemberDto.getName()))
                      .groupBy(order.member.id)));
    }

    if (searchOrderMemberDto.getOrderNumber() != null
        && searchOrderMemberDto.getOrderNumber().length() != 0) {
      query.select(member, order.date, order.orderNumber)
          .where(
              // in 안에 있는 select 만 하면 6개 로우가 나와야 하는데
              // in 이라서 로우가 8개 나온다.
              order.date
                  .in(JPAExpressions.select(order.date.max())
                      .from(order)
                      .where(order.orderNumber.contains(searchOrderMemberDto.getOrderNumber()),
                          order.member.id.eq(member.id))
                      .groupBy(order.member.id)
                  ));
    }

    if ((searchOrderMemberDto.getOrderStartDate() != null
        && searchOrderMemberDto.getOrderEndDate() != null) &&
        (searchOrderMemberDto.getOrderStartDate().length() != 0
            && searchOrderMemberDto.getOrderEndDate().length() != 0)) {

      String startRegDateTimeString = searchOrderMemberDto.getOrderStartDate() + "T00:00:00";
      String endRegDateTimeString = searchOrderMemberDto.getOrderEndDate() + "T23:59:59";

      LocalDateTime startRegDateTime = LocalDateTime
          .parse(startRegDateTimeString, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
      LocalDateTime endRegDateTime = LocalDateTime
          .parse(endRegDateTimeString, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));

      query.select(member, order.date, order.orderNumber)
          .where(
              // in 안에 있는 select 만 하면 6개 로우가 나와야 하는데
              // in 이라서 로우가 8개 나온다.
              order.date
                  .in(JPAExpressions.select(order.date.max())
                      .from(order)
                      .where(order.date.between(startRegDateTime,
                          endRegDateTime), order.member.id.eq(member.id))
                      .groupBy(order.member.id)
                  ));
    }

    if (searchOrderMemberDto.getProductName() != null
        && searchOrderMemberDto.getProductName().length() != 0) {
      query.select(member, order.date, order.orderNumber)
          .where(
              order.date
                  .in(JPAExpressions.select(orderedProduct.order.date.max())
                      .from(orderedProduct)
                      .innerJoin(orderedProduct.product, product)
                      .groupBy(orderedProduct.order.member.id)
                      .where(orderedProduct.product.id
                              .in(JPAExpressions.select(product.id)
                                  .from(product)
                                  .where(product.name.contains(searchOrderMemberDto.getProductName())))
                          ,orderedProduct.order.member.id.eq(member.id)))
          );
    }

    List<Tuple> tuples = super.getQuerydsl().applyPagination(pageable, query).fetch();
    long totalCount = query.fetchCount();

    return new PageImpl<>(tuples, pageable, totalCount);
  }
}
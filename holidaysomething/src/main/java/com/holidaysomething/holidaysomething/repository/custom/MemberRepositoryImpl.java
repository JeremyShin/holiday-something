package com.holidaysomething.holidaysomething.repository.custom;

import com.holidaysomething.holidaysomething.domain.Member;
import com.holidaysomething.holidaysomething.domain.QMember;
import com.holidaysomething.holidaysomething.domain.QOrder;
import com.holidaysomething.holidaysomething.dto.SearchOrderMember;
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
  public List<Member> getMembersByDsl(SearchOrderMember searchOrderMember, Pageable pageable) {
    QMember member = QMember.member;
    QOrder order = QOrder.order;

    JPQLQuery query = from(member);

    if (searchOrderMember.getLoginId() != null || !searchOrderMember.getLoginId().equals("")) {
      query.where(member.loginId.eq(searchOrderMember.getLoginId()));
    }

    if (searchOrderMember.getName() != null || !searchOrderMember.getName().equals("")) {
      query.where(member.name.eq(searchOrderMember.getName()));
    }

    return getQuerydsl().applyPagination(pageable, query).fetch();
  }

}

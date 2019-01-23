package com.holidaysomething.holidaysomething.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = 1027506999L;

    public static final QMember member = new QMember("member1");

    public final StringPath address1 = createString("address1");

    public final StringPath address2 = createString("address2");

    public final DatePath<java.time.LocalDate> birthday = createDate("birthday", java.time.LocalDate.class);

    public final SetPath<CartProduct, QCartProduct> cartProducts = this.<CartProduct, QCartProduct>createSet("cartProducts", CartProduct.class, QCartProduct.class, PathInits.DIRECT2);

    public final StringPath email = createString("email");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.time.LocalDateTime> lastLogin = createDateTime("lastLogin", java.time.LocalDateTime.class);

    public final StringPath loginId = createString("loginId");

    public final BooleanPath marketing = createBoolean("marketing");

    public final NumberPath<Integer> mileage = createNumber("mileage", Integer.class);

    public final StringPath name = createString("name");

    public final StringPath nickname = createString("nickname");

    public final ListPath<Order, QOrder> orders = this.<Order, QOrder>createList("orders", Order.class, QOrder.class, PathInits.DIRECT2);

    public final StringPath password = createString("password");

    public final BooleanPath personalInfo = createBoolean("personalInfo");

    public final StringPath phone = createString("phone");

    public final StringPath postcode = createString("postcode");

    public final BooleanPath receiveEmail = createBoolean("receiveEmail");

    public final BooleanPath receiveSms = createBoolean("receiveSms");

    public final StringPath recommender = createString("recommender");

    public final DateTimePath<java.time.LocalDateTime> regDate = createDateTime("regDate", java.time.LocalDateTime.class);

    public final SetPath<Role, QRole> roles = this.<Role, QRole>createSet("roles", Role.class, QRole.class, PathInits.DIRECT2);

    public final StringPath sex = createString("sex");

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QMember(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}


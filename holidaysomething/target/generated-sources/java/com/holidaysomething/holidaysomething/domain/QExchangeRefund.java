package com.holidaysomething.holidaysomething.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QExchangeRefund is a Querydsl query type for ExchangeRefund
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QExchangeRefund extends EntityPathBase<ExchangeRefund> {

    private static final long serialVersionUID = -304480488L;

    public static final QExchangeRefund exchangeRefund = new QExchangeRefund("exchangeRefund");

    public final DateTimePath<java.time.LocalDateTime> applyDate = createDateTime("applyDate", java.time.LocalDateTime.class);

    public final BooleanPath approve = createBoolean("approve");

    public final DateTimePath<java.time.LocalDateTime> approveDate = createDateTime("approveDate", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> price = createNumber("price", Integer.class);

    public final StringPath type = createString("type");

    public QExchangeRefund(String variable) {
        super(ExchangeRefund.class, forVariable(variable));
    }

    public QExchangeRefund(Path<? extends ExchangeRefund> path) {
        super(path.getType(), path.getMetadata());
    }

    public QExchangeRefund(PathMetadata metadata) {
        super(ExchangeRefund.class, metadata);
    }

}


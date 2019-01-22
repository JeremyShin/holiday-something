package com.holidaysomething.holidaysomething.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QShipping is a Querydsl query type for Shipping
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QShipping extends EntityPathBase<Shipping> {

    private static final long serialVersionUID = -275045621L;

    public static final QShipping shipping = new QShipping("shipping");

    public final StringPath address = createString("address");

    public final StringPath addressDetail = createString("addressDetail");

    public final DateTimePath<java.time.LocalDateTime> arrivalDate = createDateTime("arrivalDate", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath message = createString("message");

    public final StringPath phone = createString("phone");

    public final StringPath postcode = createString("postcode");

    public final StringPath recipient = createString("recipient");

    public final StringPath shippingNumber = createString("shippingNumber");

    public final NumberPath<Integer> shippingPrice = createNumber("shippingPrice", Integer.class);

    public final DateTimePath<java.time.LocalDateTime> startDate = createDateTime("startDate", java.time.LocalDateTime.class);

    public final StringPath status = createString("status");

    public QShipping(String variable) {
        super(Shipping.class, forVariable(variable));
    }

    public QShipping(Path<? extends Shipping> path) {
        super(path.getType(), path.getMetadata());
    }

    public QShipping(PathMetadata metadata) {
        super(Shipping.class, metadata);
    }

}


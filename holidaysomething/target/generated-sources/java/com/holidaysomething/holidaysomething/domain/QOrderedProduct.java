package com.holidaysomething.holidaysomething.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QOrderedProduct is a Querydsl query type for OrderedProduct
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QOrderedProduct extends EntityPathBase<OrderedProduct> {

    private static final long serialVersionUID = 495883103L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QOrderedProduct orderedProduct = new QOrderedProduct("orderedProduct");

    public final QExchangeRefund exchangeRefund;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> mileage = createNumber("mileage", Integer.class);

    public final QOrder order;

    public final NumberPath<Integer> orderPrice = createNumber("orderPrice", Integer.class);

    public final StringPath personalOption = createString("personalOption");

    public final QProduct product;

    public final NumberPath<Integer> quantity = createNumber("quantity", Integer.class);

    public QOrderedProduct(String variable) {
        this(OrderedProduct.class, forVariable(variable), INITS);
    }

    public QOrderedProduct(Path<? extends OrderedProduct> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QOrderedProduct(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QOrderedProduct(PathMetadata metadata, PathInits inits) {
        this(OrderedProduct.class, metadata, inits);
    }

    public QOrderedProduct(Class<? extends OrderedProduct> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.exchangeRefund = inits.isInitialized("exchangeRefund") ? new QExchangeRefund(forProperty("exchangeRefund")) : null;
        this.order = inits.isInitialized("order") ? new QOrder(forProperty("order"), inits.get("order")) : null;
        this.product = inits.isInitialized("product") ? new QProduct(forProperty("product"), inits.get("product")) : null;
    }

}


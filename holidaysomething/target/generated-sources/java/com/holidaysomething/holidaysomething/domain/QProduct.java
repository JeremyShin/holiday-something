package com.holidaysomething.holidaysomething.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProduct is a Querydsl query type for Product
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProduct extends EntityPathBase<Product> {

    private static final long serialVersionUID = 529590258L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProduct product = new QProduct("product");

    public final StringPath code = createString("code");

    public final BooleanPath display = createBoolean("display");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.time.LocalDateTime> manufactureDate = createDateTime("manufactureDate", java.time.LocalDateTime.class);

    public final StringPath manufacturer = createString("manufacturer");

    public final NumberPath<Integer> manufacturingPrice = createNumber("manufacturingPrice", Integer.class);

    public final NumberPath<Integer> mileage = createNumber("mileage", Integer.class);

    public final StringPath name = createString("name");

    public final StringPath optionalPriceText = createString("optionalPriceText");

    public final NumberPath<Integer> originalPrice = createNumber("originalPrice", Integer.class);

    public final QProductCategory productCategory;

    public final QProductDetail productDetail;

    public final SetPath<ProductImage, QProductImage> productImages = this.<ProductImage, QProductImage>createSet("productImages", ProductImage.class, QProductImage.class, PathInits.DIRECT2);

    public final SetPath<ProductOption, QProductOption> productOptions = this.<ProductOption, QProductOption>createSet("productOptions", ProductOption.class, QProductOption.class, PathInits.DIRECT2);

    public final NumberPath<Integer> quantity = createNumber("quantity", Integer.class);

    public final DateTimePath<java.time.LocalDateTime> regDate = createDateTime("regDate", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> releaseDate = createDateTime("releaseDate", java.time.LocalDateTime.class);

    public final NumberPath<Integer> safeQuantity = createNumber("safeQuantity", Integer.class);

    public final NumberPath<Integer> sellingPrice = createNumber("sellingPrice", Integer.class);

    public final NumberPath<Integer> sellingQuantity = createNumber("sellingQuantity", Integer.class);

    public final NumberPath<Integer> shippingPrice = createNumber("shippingPrice", Integer.class);

    public QProduct(String variable) {
        this(Product.class, forVariable(variable), INITS);
    }

    public QProduct(Path<? extends Product> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProduct(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProduct(PathMetadata metadata, PathInits inits) {
        this(Product.class, metadata, inits);
    }

    public QProduct(Class<? extends Product> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.productCategory = inits.isInitialized("productCategory") ? new QProductCategory(forProperty("productCategory")) : null;
        this.productDetail = inits.isInitialized("productDetail") ? new QProductDetail(forProperty("productDetail")) : null;
    }

}


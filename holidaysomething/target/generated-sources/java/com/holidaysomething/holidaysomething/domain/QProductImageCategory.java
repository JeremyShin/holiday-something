package com.holidaysomething.holidaysomething.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QProductImageCategory is a Querydsl query type for ProductImageCategory
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProductImageCategory extends EntityPathBase<ProductImageCategory> {

    private static final long serialVersionUID = -753368921L;

    public static final QProductImageCategory productImageCategory = new QProductImageCategory("productImageCategory");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public QProductImageCategory(String variable) {
        super(ProductImageCategory.class, forVariable(variable));
    }

    public QProductImageCategory(Path<? extends ProductImageCategory> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProductImageCategory(PathMetadata metadata) {
        super(ProductImageCategory.class, metadata);
    }

}


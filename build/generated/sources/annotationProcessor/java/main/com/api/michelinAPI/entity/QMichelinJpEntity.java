package com.api.michelinAPI.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMichelinJpEntity is a Querydsl query type for MichelinJpEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMichelinJpEntity extends EntityPathBase<MichelinJpEntity> {

    private static final long serialVersionUID = -1127041697L;

    public static final QMichelinJpEntity michelinJpEntity = new QMichelinJpEntity("michelinJpEntity");

    public final StringPath ctprvnEngNm = createString("ctprvnEngNm");

    public final NumberPath<Double> fcltyLa = createNumber("fcltyLa", Double.class);

    public final NumberPath<Double> fcltyLo = createNumber("fcltyLo", Double.class);

    public final StringPath fcltyNm = createString("fcltyNm");

    public final StringPath foodCatg = createString("foodCatg");

    public final StringPath michelinNm = createString("michelinNm");

    public final StringPath rdnmadrNm = createString("rdnmadrNm");

    public final NumberPath<Integer> seq = createNumber("seq", Integer.class);

    public final NumberPath<Integer> starCnt = createNumber("starCnt", Integer.class);

    public final NumberPath<Integer> year = createNumber("year", Integer.class);

    public QMichelinJpEntity(String variable) {
        super(MichelinJpEntity.class, forVariable(variable));
    }

    public QMichelinJpEntity(Path<? extends MichelinJpEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMichelinJpEntity(PathMetadata metadata) {
        super(MichelinJpEntity.class, metadata);
    }

}


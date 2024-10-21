package com.api.michelinAPI.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMichelinKrEntity is a Querydsl query type for MichelinKrEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMichelinKrEntity extends EntityPathBase<MichelinKrEntity> {

    private static final long serialVersionUID = -1904191296L;

    public static final QMichelinKrEntity michelinKrEntity = new QMichelinKrEntity("michelinKrEntity");

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

    public QMichelinKrEntity(String variable) {
        super(MichelinKrEntity.class, forVariable(variable));
    }

    public QMichelinKrEntity(Path<? extends MichelinKrEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMichelinKrEntity(PathMetadata metadata) {
        super(MichelinKrEntity.class, metadata);
    }

}


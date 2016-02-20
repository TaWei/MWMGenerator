package mwm.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import mwm.entity.helpers.StockDailyRecordId;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(StockDailyRecord.class)
public abstract class StockDailyRecord_ {

	public static volatile SingularAttribute<StockDailyRecord, Float> highestPrice;
	public static volatile SingularAttribute<StockDailyRecord, Float> lowestPrice;
	public static volatile SingularAttribute<StockDailyRecord, Float> closingPrice;
	public static volatile SingularAttribute<StockDailyRecord, StockDailyRecordId> stockDailyRecordId;

}


package mwm.entity.helpers;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import mwm.entity.Stock;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(StockDailyRecordId.class)
public abstract class StockDailyRecordId_ {

	public static volatile SingularAttribute<StockDailyRecordId, Date> date;
	public static volatile SingularAttribute<StockDailyRecordId, Stock> stock;

}


package mwm.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Stock.class)
public abstract class Stock_ {

	public static volatile SingularAttribute<Stock, String> name;
	public static volatile SingularAttribute<Stock, String> tickerName;
	public static volatile SingularAttribute<Stock, Long> id;
	public static volatile SingularAttribute<Stock, String> classification;

}


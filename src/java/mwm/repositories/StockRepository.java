package mwm.repositories;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import mwm.entity.Stock;
import mwm.entity.Stock_;
import mwm.hibernate.HibernateUtil;

public class StockRepository {
	public StockRepository(){
		
	}
	
	public Stock get(Stock stock){
		EntityManager entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Stock> criteria = builder.createQuery(Stock.class);
		Root<Stock> root = criteria.from(Stock.class);
		criteria.select(root);
		criteria.where(builder.equal(root.get(Stock_.tickerName), "TSX:AAR.asddN"));
		Stock myStock = entityManager.createQuery(criteria).getSingleResult();
		return myStock;
		
	}
	
	public void insert(Stock stock){
		EntityManager entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(stock);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
}

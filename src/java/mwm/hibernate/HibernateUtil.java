package mwm.hibernate;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {
	private static final EntityManagerFactory entityManagerFactory = buildEntityManagerFactory();
	
	private static EntityManagerFactory buildEntityManagerFactory(){
		try {
			return Persistence.createEntityManagerFactory( "mwm" );
		}
		catch (Exception e) {
			System.err.println("Initial EntityManagerFactory creation failed.");
			e.printStackTrace();
			System.exit(0);
		}
		return null;
	}
	
	public static EntityManagerFactory getEntityManagerFactory(){
		return entityManagerFactory;
	}
}

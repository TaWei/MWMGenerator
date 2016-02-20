package mwm.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	private static final SessionFactory sessionFactory = buildSessionFactory();
	
	private static SessionFactory buildSessionFactory(){
		// A SessionFactory is set up once for an application!
		try {
			StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
					.configure("mwm/hibernate/hibernate.cfg.xml") // configures settings from hibernate.cfg.xml
					.build();
			return new MetadataSources( registry ).buildMetadata().buildSessionFactory();
		}
		catch (Exception e) {
			// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
			// so destroy it manually.
			System.err.println("Initial SessionFactory creation failed.");
			e.printStackTrace();
			System.exit(0);
		}
		return null;
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
}
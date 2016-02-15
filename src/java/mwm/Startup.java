package mwm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Startup {
	private static SessionFactory sessionFactory;
	
	protected static void initSession() throws Exception {
		// A SessionFactory is set up once for an application!
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure("mwm/hibernate/hibernate.cfg.xml") // configures settings from hibernate.cfg.xml
				.build();
		try {
			sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
		}
		catch (Exception e) {
			// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
			// so destroy it manually.
			StandardServiceRegistryBuilder.destroy( registry );
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	public static void main(String[] args) throws Exception {
		initSession();
		
		// create a couple of events...
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.getTransaction().commit();
		session.close();
	}
	
	protected void tearDown() throws Exception {
		if ( sessionFactory != null ) {
			sessionFactory.close();
		}
	}

}

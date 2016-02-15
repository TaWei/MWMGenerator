package mwm;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import mwm.entities.Report;

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
		}
	}
	
	public static void main(String[] args) throws Exception {
		initSession();
		// create a couple of events...
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.getTransaction().commit();
		session.close();

		// now lets pull events from the database and list them
		session = sessionFactory.openSession();
        session.beginTransaction();
        List result = session.createQuery( "from Report" ).list();
		for ( Report report : (List<Report>) result ) {
			System.out.println( "Report (" + report.getDate() + ") : " + report.getInstance() );
		}
        session.getTransaction().commit();
        session.close();
	}
	
	protected void tearDown() throws Exception {
		if ( sessionFactory != null ) {
			sessionFactory.close();
		}
	}

}

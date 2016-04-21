package com.mycompany.hibernate;


import mytld.mycompany.myapp.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import com.mycompany.model.*;

public class HibernateUtil {

	public HibernateUtil()
	{
		
	}
// A SessionFactory is set up once for an application!
    final static StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure() // configures settings from hibernate.cfg.xml
            .build();
    private static SessionFactory sessionFactory=null;

private static SessionFactory buildSessionFactory() {

    try {
        sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
        return sessionFactory;
    }
    catch (Exception e) {
        // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
        // so destroy it manually.
        StandardServiceRegistryBuilder.destroy( registry );
        throw new ExceptionInInitializerError(e);
    }

}

public static SessionFactory getSessionFactory() {
    if(sessionFactory==null){
        buildSessionFactory();
    }
    return sessionFactory;
}
}

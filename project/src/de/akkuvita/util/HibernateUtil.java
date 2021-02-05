package de.akkuvita.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static {
        try {
            System.out.println(new java.io.File("").getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError( ex.toString());
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}

package com.mateusbkps.util;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {
	
	public static EntityManagerFactory emf;
	private HibernateUtil() {
    }
    public static EntityManagerFactory geteEntityManagerFactory() {
        if (emf == null) {
            try {
                emf = Persistence
                        .createEntityManagerFactory("exemplohibernate");
            } catch (Exception ex) {
                System.err.println("Initial SessionFactory creation failed."
                        + ex);
            }
        }
        return emf;
    }
}

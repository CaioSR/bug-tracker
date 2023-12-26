package com.shimada.application.configuration;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate connection service that provides the session to use hibernate
 * 
 * @author Caio Shimada
 */
public class HibernateConnector {

	private static final SessionFactory sessionFactory = buildSessionFactory();
	private static final String CONFIG_PATH = "application/configuration/hibernate.cfg.xml";

	/**
	 * Loads the Hibernate configuration file
	 * 
	 * @return a SessionFactory object
	 */
	private static SessionFactory buildSessionFactory() {
		try {
			return new Configuration().configure(CONFIG_PATH).buildSessionFactory();

		} catch (Throwable e) {
			System.err.println("Initial SessionFactory creation failed: " + e);
			throw new ExceptionInInitializerError(e);
		}
	}

	/**
	 * Retrieve the session factory
	 * 
	 * @return {@link SessionFactory}
	 */
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * Shuts down the sessions factory
	 */
	public static void shutdown() {
		getSessionFactory().close();
	}
}

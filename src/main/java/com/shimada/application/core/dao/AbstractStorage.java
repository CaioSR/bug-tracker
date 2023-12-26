package com.shimada.application.core.dao;

import org.hibernate.Session;

import com.shimada.application.configuration.HibernateConnector;
import com.shimada.application.core.model.BasicEntity;

/**
 * Abstract storage service for storing and retrieving data
 *
 * @author Caio Shimada
 */
public abstract class AbstractStorage<T extends BasicEntity> {

	private Session session;
	
	/**
	 * Retrieves the Hibernate Session
	 * 
	 * @return
	 */
	protected Session getSession() {
		if (session == null || !session.isOpen()) {
			session = HibernateConnector.getSessionFactory().openSession();
		}
		return session;
	}
	
	/**
	 * Gets the Type of the class being managed
	 * 
	 * @return
	 */
	protected abstract Class<T> getType();
	
	/**
	 * Finds an entity in the database by its Id
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public T find(Long id) throws Exception {
		T entity = null;
		
		try {
			Session session = getSession();
			
			entity = session.find(getType(), id);
			
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return entity;
	}
	
	/**
	 * Saves an entity in the database
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public T save(T entity) throws Exception {
		try {
			// validate(entity);
			
			Session session = getSession();
			
			session.beginTransaction();
			
			session.merge(entity);
			
			session.getTransaction().commit();
			
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return entity;
	}
	
	/**
	 * Deletes an entity from the database
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void delete(T entity) throws Exception {
		try {
			// validate(entity);
			
			Session session = getSession();
			
			session.beginTransaction();
			
			session.remove(entity);
			
			session.getTransaction().commit();
			
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Deletes an entity from the database identifying it by its Id
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public void delete(Long id) throws Exception {
		try {
			T entity = find(id);
			
			delete(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

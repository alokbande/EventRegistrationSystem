package com.event.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author M1021173
 *
 */
@Repository
public abstract class AbstractDao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3998136891832430215L;

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public <F> F findById(Class<F> clazz, Integer id) {
		return clazz.cast(getSession().get(clazz, id));
	}
	
	public <F> F findById(Class<F> clazz, String id) {
		return clazz.cast(getSession().get(clazz, id));
	}
}

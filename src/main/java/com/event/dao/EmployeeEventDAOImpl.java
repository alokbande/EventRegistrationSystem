package com.event.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.event.domain.Employees;
import com.event.domain.EmployeeEvent;
import com.event.domain.Events;

/**
 * @author M1021173
 *
 */
@Repository
public class EmployeeEventDAOImpl extends AbstractDao implements EmployeeEventDAO {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeEventDAOImpl.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * getListEmployee returns list of Employees
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Employees> getListEmployee() throws HibernateException {

		try {
			StringBuilder queryString = new StringBuilder(" from Employees ev");
			return getSession().createQuery(queryString.toString()).list();
		} catch (HibernateException re) {
			throw re;
		}

	}

	/**
	 * getListEvent returns list of Events
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Events> getListEvent() throws HibernateException {

		try {
			StringBuilder queryString = new StringBuilder(" from Events ev");
			return getSession().createQuery(queryString.toString()).list();
		} catch (HibernateException re) {
			throw re;
		}
	}

	/**
	 * getListEmployeeEvent returns list of EmployeeEvent
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeEvent> getListEmployeeEvent() {
		try {
			StringBuilder queryString = new StringBuilder(" from EmployeeEvent ev");
			return getSession().createQuery(queryString.toString()).list();
		} catch (HibernateException re) {
			throw re;
		}
	}

	/**
	 * registerEmployeeEvent add record EmployeeEvent
	 * 
	 * 
	 */
	public void registerEmployeeEvent(EmployeeEvent employeeEvent) {
		try {
			getSession().saveOrUpdate(employeeEvent);
		} catch (HibernateException e) {
			logger.error("addPropertyTaxDetails {}", e);
		}

	}
}

package com.event.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.event.dao.EmployeeEventDAOImpl;
import com.event.domain.Employees;
import com.event.domain.EmployeeEvent;
import com.event.domain.EmployeeEventId;
import com.event.domain.Events;
import com.event.form.RegisterEmployeeEventForm;

/**
 * @author M1021173
 *
 */
@Service
@Transactional
public class EmployeeEventServiceImpl implements EmployeeEventService {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeEventServiceImpl.class);
	@Autowired
	private EmployeeEventDAOImpl employeeEventDAOImpl;

	/**
	 * getListEmployee returns list of Employees
	 * 
	 * @return
	 */
	@Override
	public List<Employees> getListEmployee() {
		logger.debug("getListEmployee ::::: {}");
		return employeeEventDAOImpl.getListEmployee();
	}

	/**
	 * getListEvent returns list of Events
	 * 
	 * @return
	 */
	@Override
	public List<Events> getListEvent() {
		logger.debug("getListEvent ::::: {}");
		return employeeEventDAOImpl.getListEvent();
	}

	/**
	 * getListEmployeeEvent returns list of EmployeeEvent
	 * 
	 * @return
	 */
	@Override
	public List<EmployeeEvent> getListEmployeeEvent() {
		return employeeEventDAOImpl.getListEmployeeEvent();
	}

	/**
	 * registerEmployeeEvent add record EmployeeEvent
	 * 
	 * 
	 */
	@Override
	public void registerEmployeeEvent(RegisterEmployeeEventForm registerEmployeeEventForm) throws Exception {
		EmployeeEvent employeeEvent = new EmployeeEvent();
		EmployeeEventId employeeEventId = new EmployeeEventId();
		employeeEventId.setEmployee(employeeEventDAOImpl.findById(Employees.class, registerEmployeeEventForm.getMid()));
		employeeEventId.setEvent(employeeEventDAOImpl.findById(Events.class, registerEmployeeEventForm.getEventId()));
		employeeEvent.setPk(employeeEventId);
		employeeEventDAOImpl.registerEmployeeEvent(employeeEvent);

	}

	@Override
	public <F> F findById(Class<F> clazz, Integer id) throws Exception {
		return employeeEventDAOImpl.findById(clazz, id);
	}

	@Override
	public <F> F findById(Class<F> clazz, String id) throws Exception {
		return employeeEventDAOImpl.findById(clazz, id);
	}
}

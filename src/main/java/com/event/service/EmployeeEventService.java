package com.event.service;

import java.util.List;

import com.event.domain.EmployeeEvent;
import com.event.domain.Employees;
import com.event.domain.Events;
import com.event.form.RegisterEmployeeEventForm;

/**
 * @author M1021173
 *
 */
public interface EmployeeEventService {
	List<Employees> getListEmployee();

	List<Events> getListEvent();

	List<EmployeeEvent> getListEmployeeEvent();

	void registerEmployeeEvent(RegisterEmployeeEventForm registerEmployeeEventForm) throws Exception;

	<F> F findById(Class<F> clazz, Integer id) throws Exception;

	<F> F findById(Class<F> clazz, String id) throws Exception;
}

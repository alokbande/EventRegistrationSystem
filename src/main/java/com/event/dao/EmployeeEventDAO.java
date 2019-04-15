package com.event.dao;

import java.util.List;

import com.event.domain.Employees;
import com.event.domain.EmployeeEvent;
import com.event.domain.Events;

/**
 * @author M1021173
 *
 */
public interface EmployeeEventDAO {

	List<Employees> getListEmployee();

	List<Events> getListEvent();

	List<EmployeeEvent> getListEmployeeEvent();
}

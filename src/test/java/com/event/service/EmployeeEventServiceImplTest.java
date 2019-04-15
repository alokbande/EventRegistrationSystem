package com.event.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.event.dao.EmployeeEventDAOImpl;
import com.event.domain.Employees;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeEventServiceImplTest {

	@InjectMocks
	private EmployeeEventServiceImpl employeeEventServiceImpl;

	@Mock
	private EmployeeEventDAOImpl employeeEventDAOImpl;

	@Test
	public void testGetListEmployee() throws Exception {
		List<Employees> employees = new ArrayList<>();
		Employees employee = new Employees();
		employee.setEmail("sss@sss.com");
		employees.add(employee);
		when(employeeEventDAOImpl.getListEmployee()).thenReturn(employees);
		List<Employees> retEmployees = employeeEventServiceImpl.getListEmployee();
		assertEquals(1, retEmployees.size());
	}
}

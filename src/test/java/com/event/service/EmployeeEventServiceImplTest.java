package com.event.service;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.event.dao.EmployeeEventDAOImpl;
import com.event.domain.Employees;

/**
 * @author M1021173
 *
 */
public class EmployeeEventServiceImplTest {

	@BeforeClass
	public void setUp() {
		MockitoAnnotations.initMocks(this);

	}

	@InjectMocks
	private EmployeeEventServiceImpl employeeEventServiceImpl;

	@Mock
	private EmployeeEventDAOImpl employeeEventDAOImpl;

	@Test
	public void testListPropertyDescription() throws Exception {
		List<Employees> empListRet = new ArrayList<Employees>();
		Employees description = new Employees();

		empListRet.add(description);
		when(employeeEventDAOImpl.getListEmployee()).thenReturn(empListRet);
		List<Employees> empList = employeeEventServiceImpl.getListEmployee();
		org.testng.Assert.assertEquals(1, empList.size());
	}
}

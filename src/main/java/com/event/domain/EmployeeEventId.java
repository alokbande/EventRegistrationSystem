package com.event.domain;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class EmployeeEventId implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Employees employees;
	private Events events;

	@ManyToOne
	public Employees getEmployee() {
		return employees;
	}

	public void setEmployee(Employees employees) {
		this.employees = employees;
	}

	@ManyToOne
	public Events getEvent() {
		return events;
	}

	public void setEvent(Events events) {
		this.events = events;
	}

}

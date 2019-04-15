package com.event.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * @author M1021173
 *
 */
@Entity
@Table(name = "events")
public class Events implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer eventId;
	private String eventTitle;
	private String description;
	private List<Employees> employees = new ArrayList<>();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EVENT_ID", unique = true, nullable = false)
	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	@Size(min = 3, max = 100)
	@Column(name = "EVENT_TITLE", nullable = false, insertable = false, updatable = false)
	public String getEventTitle() {
		return eventTitle;
	}

	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}

	@Size(min = 3, max = 100)
	@Column(name = "DESCRIPTION", nullable = false, insertable = false, updatable = false)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "EMPLOYEE_EVENT", joinColumns = @JoinColumn(name = "EVENT_ID"), inverseJoinColumns = @JoinColumn(name = "MID"))
	public List<Employees> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employees> employees) {
		this.employees = employees;
	}
}

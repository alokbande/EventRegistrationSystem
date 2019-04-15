package com.event.domain;

import java.io.Serializable;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

/**
 * @author M1021173
 *
 */
@Entity
@Table(name = "employee_event")
@AssociationOverrides({ @AssociationOverride(name = "pk.employee", joinColumns = @JoinColumn(name = "MID")),
		@AssociationOverride(name = "pk.event", joinColumns = @JoinColumn(name = "EVENT_ID")) })
public class EmployeeEvent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private EmployeeEventId pk = new EmployeeEventId();

	@EmbeddedId
	public EmployeeEventId getPk() {
		return pk;
	}

	public void setPk(EmployeeEventId pk) {
		this.pk = pk;
	}

}

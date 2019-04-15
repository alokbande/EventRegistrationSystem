package com.event.form;

import java.io.Serializable;

/**
 * @author M1021173
 *
 */
public class RegisterEmployeeEventForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String mid;

	private Integer eventId;

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

}

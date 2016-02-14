package mwm.entities;

import java.util.Date;

public class Report {
	private Long id;

	private int instance;
	private Date date;
	

	public Report() {
		// this form used by Hibernate
	}

	public Report(int instance, Date date) {
		// for application use, to create new events
		this.instance = instance;
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	private void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getInstance() {
		return instance;
	}

	public void setInstance(int instance) {
		this.instance = instance;
	}
}
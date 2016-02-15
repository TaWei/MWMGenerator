package mwm.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Report {
	private Long id;

	private Date date;
	private int instance;
	private Date timestamp;

	public Report() {
		// this form used by Hibernate
	}

	public Report(int instance, Date date, Date timestamp) {
		// for application use, to create new events
		this.date = date;
		this.instance = instance;
		this.timestamp = timestamp;
	}

	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	public Long getId() {
		return id;
	}

	private void setId(Long id) {
		this.id = id;
	}

	@Temporal(TemporalType.DATE)
	public Date getDate() {
		return date;
	}
	
	public int getInstance() {
		return instance;
	}

	public void setInstance(int instance) {
		this.instance = instance;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

}
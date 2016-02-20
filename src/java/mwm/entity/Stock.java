package mwm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Stock {
	public enum Classifications {
		US,
		CAD,
		ADR,
		INDEX
	}
	
	private Long id;

	private String name;
	private String tickerName;
	private String classification;

	public Stock() {
		// this form used by Hibernate
	}

	public Stock(String name, String tickerName, String classification) {
		// for application use, to create new events
		this.name = name;
		this.tickerName = tickerName;
		this.classification = classification;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Column(unique = true, nullable = false)
	public String getTickerName() {
		return tickerName;
	}

	public void setTickerName(String tickerName) {
		this.tickerName = tickerName;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}
	
}
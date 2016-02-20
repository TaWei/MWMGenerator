package mwm.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;

import mwm.entity.helpers.StockDailyRecordId;

@Entity
public class StockDailyRecord {
	
	@EmbeddedId
	private StockDailyRecordId stockDailyRecordId;
	private float closingPrice;
	private float lowestPrice;
	private float highestPrice;

	public StockDailyRecord() {
		// this form used by Hibernate
	}

	public StockDailyRecord(StockDailyRecordId stockDailyRecordId, Date date) {
		// for application use, to create new events
		this.stockDailyRecordId = stockDailyRecordId;
	}
	
	public StockDailyRecord(StockDailyRecordId stockDailyRecordId, float closingPrice, float lowestPrice, float highestPrice) {
		// for application use, to create new events
		this.stockDailyRecordId = stockDailyRecordId;
		this.closingPrice = closingPrice;
		this.lowestPrice = lowestPrice;
		this.highestPrice = highestPrice;
	}
	
	public float getClosingPrice() {
		return closingPrice;
	}

	public void setClosingPrice(float closingPrice) {
		this.closingPrice = closingPrice;
	}
	
	public float getLowestPrice() {
		return lowestPrice;
	}

	public void setLowestPrice(float lowestPrice) {
		this.lowestPrice = lowestPrice;
	}
	
	public float getHighestPrice() {
		return highestPrice;
	}

	public void setHighestPrice(float highestPrice) {
		this.highestPrice = highestPrice;
	}
	
}
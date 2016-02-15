package mwm.entities.helpers;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.ForeignKey;

import mwm.entities.Stock;

@Embeddable
public class StockDailyRecordId implements Serializable {
	
	@ManyToOne
	@JoinColumn(name = "stockId", foreignKey = @ForeignKey(name = "DAILY_RECORD_STOCK_ID_FK"))
	private Stock stock;
	private Date date;
	
	public Stock getStock(){
		return stock;
	}
	
	public Stock setStock(Stock stock){
		return this.stock = stock;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getDate(){
		return date;
	}
	
	public void setDate(Date date){
		this.date = date;
	}
	
}

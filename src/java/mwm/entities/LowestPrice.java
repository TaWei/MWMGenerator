package mwm.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import mwm.entities.helpers.PriceId;

@Entity
public class LowestPrice {
	
	@EmbeddedId
	private PriceId priceId;
	private float price; 

	public LowestPrice() {
		// this form used by Hibernate
	}

	public LowestPrice(PriceId priceId, float price) {
		// for application use, to create new events
		this.priceId = priceId;
		this.price = price;
	}

	public float getPriceId() {
		return price;
	}

	public void setPriceId(PriceId priceId) {
		this.priceId = priceId;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}
	
}
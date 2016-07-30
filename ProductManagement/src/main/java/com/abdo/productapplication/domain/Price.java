package com.abdo.productapplication.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Price {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long priceId;
	
	/** it is better to move this to another entity that maps to a lookup table that contains all currencies.
	 * I have just decided to add it here as a string for simplicity. */
	private String currency;
	
	private BigDecimal price;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PRODUCTID", nullable=false)
	@JsonIgnore
	private Product product;

	
	
	public long getPriceId() {
		return priceId;
	}

	public void setPriceId(long priceId) {
		this.priceId = priceId;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
		product.getPriceList().add(this);
	}
	
	
	
	
}

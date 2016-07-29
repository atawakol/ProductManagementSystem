package com.abdo.productapplication.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long productId;
	
	private String name;
	private String description;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	private Set<Tag> tagList = new HashSet<Tag>();
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	private Set<Price> priceList = new HashSet<Price>();

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Tag> getTagList() {
		return tagList;
	}

	public void setTagList(Set<Tag> tagList) {
		this.tagList = tagList;
	}

	public Set<Price> getPriceList() {
		return priceList;
	}

	public void setPriceList(Set<Price> priceList) {
		this.priceList = priceList;
	}

	
	
}

package com.abdo.productapplication.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long productId;
	
	//@Column(length=100)
	@Size(min=3, max=255, message="The length of the product name has to be between 3 and 255")
	@NotNull
	private String name;
	//@Column(length=255)
	@Size(min=3, max=255, message="The length of the product description has to be between 3 and 255")
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
		// add this product to the tags, so we are sure that they will persist & relations are correct
		tagList.forEach(t->t.setProduct(this));
	}

	public Set<Price> getPriceList() {
		return priceList;
	}

	public void setPriceList(Set<Price> priceList) {
		this.priceList = priceList;
		// add this product to the prcies, so we are sure that they will persist & relations are correct
		priceList.forEach(p->p.setProduct(this));
	}

	
	
}

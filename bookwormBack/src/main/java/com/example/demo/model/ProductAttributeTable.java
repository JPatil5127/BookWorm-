package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class ProductAttributeTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prodAttId;
    
    private String attributeValue;

    @ManyToOne
    @JoinColumn(name = "attributeId")
    private AttributeMaster attribute;

    @ManyToOne
    @JoinColumn(name = "productId")
    private ProductMaster product;

	public int getProdAttId() {
		return prodAttId;
	}

	public void setProdAttId(int prodAttId) {
		this.prodAttId = prodAttId;
	}

	public String getAttributeValue() {
		return attributeValue;
	}

	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
	}

	public AttributeMaster getAttribute() {
		return attribute;
	}

	public void setAttribute(AttributeMaster attribute) {
		this.attribute = attribute;
	}

	public ProductMaster getProduct() {
		return product;
	}

	public void setProduct(ProductMaster product) {
		this.product = product;
	}

    // Getters and Setters
    
}

package com.example.demo.model;

import java.util.Date;

import jakarta.persistence.*;

@Entity
public class MyShelfTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int shelfId;
    
    private String tranType;
    private Date productExpiryDate;
    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private CustomerMaster customer;

    @ManyToOne
    @JoinColumn(name = "productId")
    private ProductMaster product;
// Getters and Setters
	public int getShelfId() {
		return shelfId;
	}

	public void setShelfId(int shelfId) {
		this.shelfId = shelfId;
	}

	public String getTranType() {
		return tranType;
	}

	public void setTranType(String tranType) {
		this.tranType = tranType;
	}

	public Date getProductExpiryDate() {
		return productExpiryDate;
	}

	public void setProductExpiryDate(Date productExpiryDate) {
		this.productExpiryDate = productExpiryDate;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public CustomerMaster getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerMaster customer) {
		this.customer = customer;
	}

	public ProductMaster getProduct() {
		return product;
	}

	public void setProduct(ProductMaster product) {
		this.product = product;
	}

    
    
    
}

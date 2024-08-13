package com.example.demo.model;

import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity
public class ProductBenMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prodBenId;
    
    private BigDecimal prodBenPercentage;

    @ManyToOne
    @JoinColumn(name = "prodBenBenId")
    private BeneficiaryMaster beneficiary;

    @ManyToOne
    @JoinColumn(name = "prodBenProductId")
    private ProductMaster product;

	public int getProdBenId() {
		return prodBenId;
	}

	public void setProdBenId(int prodBenId) {
		this.prodBenId = prodBenId;
	}

	public BigDecimal getProdBenPercentage() {
		return prodBenPercentage;
	}

	public void setProdBenPercentage(BigDecimal prodBenPercentage) {
		this.prodBenPercentage = prodBenPercentage;
	}

	public BeneficiaryMaster getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(BeneficiaryMaster beneficiary) {
		this.beneficiary = beneficiary;
	}

	public ProductMaster getProduct() {
		return product;
	}

	public void setProduct(ProductMaster product) {
		this.product = product;
	}

    // Getters and Setters
    
    
}


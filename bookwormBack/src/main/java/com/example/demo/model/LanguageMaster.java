package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="LanguageMaster")
public class LanguageMaster {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name = "languageId") // Explicitly specifying the column name
private Integer languageId;
@Column(name = "languageDesc")
private String languageDesc;

@ManyToOne
@JoinColumn(name = "TypeId" )
private ProductType productType;
//constructors 

public LanguageMaster(){}
public LanguageMaster(String languageDesc) {
	this.languageDesc = languageDesc;
}


//Getters and setters

public Integer getLanguageId() {
	return languageId;
}


public void setLanguageId(Integer languageId) {
	this.languageId = languageId;
}


public String getLanguageDesc() {
	return languageDesc;
}


public void setLanguageDesc(String languageDesc) {
	this.languageDesc = languageDesc;
}


public ProductType getProductType() {
	return productType;
}


public void setProductType(ProductType productType) {
	this.productType = productType;
}




}

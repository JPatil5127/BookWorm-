package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ProductTypeMaster")
public class ProductType {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer typeId;

@Enumerated(EnumType.STRING)  // Use STRING to store the enum name
private ProductTypeEnum typeDesc;
//Default constructor 
public ProductType() {}

//Parameterized constructor
public ProductType(ProductTypeEnum typeDesc) {
    this.typeDesc = typeDesc;
}

// Getters and setters

public Integer getTypeId() {
	return typeId;
}


public void setTypeId(Integer typeId) {
	this.typeId = typeId;
}


public ProductTypeEnum getTypeDesc() {
	return typeDesc;
}


public void setTypeDesc(ProductTypeEnum typeDesc) {
	this.typeDesc = typeDesc;
}

public enum ProductTypeEnum {
    EBOOK,
    AUDIOBOOK,
    VIDEO
     
}
}

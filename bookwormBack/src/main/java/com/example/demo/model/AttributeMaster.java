package com.example.demo.model;

import jakarta.persistence.*;


@Entity
public class AttributeMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int attributeId;
    
    
    private String attributeDesc;

	public int getAttributeId() {
		return attributeId;
	}

	public void setAttributeId(int attributeId) {
		this.attributeId = attributeId;
	}

	public String getAttributeDesc() {
		return attributeDesc;
	}

	public void setAttributeDesc(String attributeDesc) {
		this.attributeDesc = attributeDesc;
	}

    
    
    
}


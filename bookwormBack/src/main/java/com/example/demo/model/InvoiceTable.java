package com.example.demo.model;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.*;

@Entity
public class InvoiceTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int invoiceId;
    
    private Date invoiceDate;
    private BigDecimal invoiceAmount;

    @ManyToOne
    @JoinColumn(name = "custId")
    private CustomerMaster customer;
// Getters and Setters
	public int getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public BigDecimal getInvoiceAmount() {
		return invoiceAmount;
	}

	public void setInvoiceAmount(BigDecimal invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}

	public CustomerMaster getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerMaster customer) {
		this.customer = customer;
	}

    
    
}


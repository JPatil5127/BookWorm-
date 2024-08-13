package com.example.demo.model;

import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity
public class InvoiceDetailTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int invDtlId;
    
    private BigDecimal basePrice;
    private String tranType;
    private int rentNoOfDays;

    @ManyToOne
    @JoinColumn(name = "invoiceId")
    private InvoiceTable invoice;

    @ManyToOne
    @JoinColumn(name = "productId")
    private ProductMaster product;

	public int getInvDtlId() {
		return invDtlId;
	}

	public void setInvDtlId(int invDtlId) {
		this.invDtlId = invDtlId;
	}

	public BigDecimal getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(BigDecimal basePrice) {
		this.basePrice = basePrice;
	}

	public String getTranType() {
		return tranType;
	}

	public void setTranType(String tranType) {
		this.tranType = tranType;
	}

	public int getRentNoOfDays() {
		return rentNoOfDays;
	}

	public void setRentNoOfDays(int rentNoOfDays) {
		this.rentNoOfDays = rentNoOfDays;
	}

	public InvoiceTable getInvoice() {
		return invoice;
	}

	public void setInvoice(InvoiceTable invoice) {
		this.invoice = invoice;
	}

	public ProductMaster getProduct() {
		return product;
	}

	public void setProduct(ProductMaster product) {
		this.product = product;
	}

   
    
    
    
}

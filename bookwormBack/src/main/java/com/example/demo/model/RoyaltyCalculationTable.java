package com.example.demo.model;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.*;

@Entity
public class RoyaltyCalculationTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int royCalId;
    
    private Date royCalTranDate;
    private int qty;
    private String tranType;
    private BigDecimal salePrice;
    private BigDecimal basePrice;
    private BigDecimal royaltyOnBasePrice;

    @ManyToOne
    @JoinColumn(name = "invoiceId")
    private InvoiceTable invoice;

    @ManyToOne
    @JoinColumn(name = "benId")
    private BeneficiaryMaster beneficiary;

    @ManyToOne
    @JoinColumn(name = "prodId")
    private ProductMaster product;

	public int getRoyCalId() {
		return royCalId;
	}

	public void setRoyCalId(int royCalId) {
		this.royCalId = royCalId;
	}

	public Date getRoyCalTranDate() {
		return royCalTranDate;
	}

	public void setRoyCalTranDate(Date royCalTranDate) {
		this.royCalTranDate = royCalTranDate;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getTranType() {
		return tranType;
	}

	public void setTranType(String tranType) {
		this.tranType = tranType;
	}

	public BigDecimal getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}

	public BigDecimal getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(BigDecimal basePrice) {
		this.basePrice = basePrice;
	}

	public BigDecimal getRoyaltyOnBasePrice() {
		return royaltyOnBasePrice;
	}

	public void setRoyaltyOnBasePrice(BigDecimal royaltyOnBasePrice) {
		this.royaltyOnBasePrice = royaltyOnBasePrice;
	}

	public InvoiceTable getInvoice() {
		return invoice;
	}

	public void setInvoice(InvoiceTable invoice) {
		this.invoice = invoice;
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

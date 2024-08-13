package com.example.demo.model;

import java.math.*;
import java.util.Date;

import jakarta.persistence.*;

@Entity
public class ProductMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    
    private String productName;
    private String productEnglishName;
    private BigDecimal productBasePrice;
    private BigDecimal productSpCost;
    private BigDecimal productOfferPrice;
    private Date productOfferPriceExpiryDate;
    private String productDescriptionShort;
    @Column(length=1000)
    private String productDescriptionLong;
    private String productIsbn;
    private String productAuthor;
    private boolean isRentable;
    private boolean isLibrary;
    private BigDecimal rentPerDay;
    private int minRentDays;
    private String productImg;

    @ManyToOne
    @JoinColumn(name = "productType")
    private ProductType productType;

    public String getProductImg() {
		return productImg;
	}

	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}

	@ManyToOne
    @JoinColumn(name = "productPublisher")
    private PublisherMaster publisher;

    @ManyToOne
    @JoinColumn(name = "productLang")
    private LanguageMaster language;

    @ManyToOne()
    @JoinColumn(name = "productGenre")
    private GenreMaster genre;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductEnglishName() {
		return productEnglishName;
	}

	public void setProductEnglishName(String productEnglishName) {
		this.productEnglishName = productEnglishName;
	}

	public BigDecimal getProductBasePrice() {
		return productBasePrice;
	}

	public void setProductBasePrice(BigDecimal productBasePrice) {
		this.productBasePrice = productBasePrice;
	}

	public BigDecimal getProductSpCost() {
		return productSpCost;
	}

	public void setProductSpCost(BigDecimal productSpCost) {
		this.productSpCost = productSpCost;
	}

	public BigDecimal getProductOfferPrice() {
		return productOfferPrice;
	}

	public void setProductOfferPrice(BigDecimal productOfferPrice) {
		this.productOfferPrice = productOfferPrice;
	}

	public Date getProductOfferPriceExpiryDate() {
		return productOfferPriceExpiryDate;
	}

	public void setProductOfferPriceExpiryDate(Date productOfferPriceExpiryDate) {
		this.productOfferPriceExpiryDate = productOfferPriceExpiryDate;
	}

	public String getProductDescriptionShort() {
		return productDescriptionShort;
	}

	public void setProductDescriptionShort(String productDescriptionShort) {
		this.productDescriptionShort = productDescriptionShort;
	}

	public String getProductDescriptionLong() {
		return productDescriptionLong;
	}

	public void setProductDescriptionLong(String productDescriptionLong) {
		this.productDescriptionLong = productDescriptionLong;
	}

	public String getProductIsbn() {
		return productIsbn;
	}

	public void setProductIsbn(String productIsbn) {
		this.productIsbn = productIsbn;
	}

	public String getProductAuthor() {
		return productAuthor;
	}

	public void setProductAuthor(String productAuthor) {
		this.productAuthor = productAuthor;
	}

	public boolean isRentable() {
		return isRentable;
	}

	public void setRentable(boolean isRentable) {
		this.isRentable = isRentable;
	}

	public boolean isLibrary() {
		return isLibrary;
	}

	public void setLibrary(boolean isLibrary) {
		this.isLibrary = isLibrary;
	}

	public BigDecimal getRentPerDay() {
		return rentPerDay;
	}

	public void setRentPerDay(BigDecimal rentPerDay) {
		this.rentPerDay = rentPerDay;
	}

	public int getMinRentDays() {
		return minRentDays;
	}

	public void setMinRentDays(int minRentDays) {
		this.minRentDays = minRentDays;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public PublisherMaster getPublisher() {
		return publisher;
	}

	public void setPublisher(PublisherMaster publisher) {
		this.publisher = publisher;
	}

	public LanguageMaster getLanguage() {
		return language;
	}

	public void setLanguage(LanguageMaster language) {
		this.language = language;
	}

	public GenreMaster getGenre() {
		return genre;
	}

	public void setGenre(GenreMaster genre) {
		this.genre = genre;
	}

    // Getters and Setters
    
}

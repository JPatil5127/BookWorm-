package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class CustomerMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    
    private String customerName;
    @Column(unique = true, nullable = false)
    private String customerEmail;
    private String customerPhone;
    private String customerAddress;
    private String customerOccupation;
    @Column(name = "customer_password", nullable = false,length=1000)
    private String customerPassword;
    @OneToOne(optional = true)
    @JoinColumn(name = "library_package_id")
    private LibraryPackages libraryPackage;
    
    public LibraryPackages getLibraryPackage() {
        return libraryPackage;
    }

    public void setLibraryPackage(LibraryPackages libraryPackage) {
        this.libraryPackage = libraryPackage;
    }
    // Getters and Setters
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerOccupation() {
        return customerOccupation;
    }

    public void setCustomerOccupation(String customerOccupation) {
        this.customerOccupation = customerOccupation;
    }

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
}

package com.example.demo.JWT;

import com.example.demo.model.CustomerMaster;

public class JwtResponse 
{
	private String token;
	private CustomerMaster customer;

	public CustomerMaster getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerMaster customer) {
		this.customer = customer;
	}

	public JwtResponse(String token,CustomerMaster customer) {
		super();
		this.token = token;
		this.customer=customer;
	}

	@Override
	public String toString() {
		return "JwtResponse [token=" + token + "]";
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public JwtResponse() {
		super();
	
	}
	
}

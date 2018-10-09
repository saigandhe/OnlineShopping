package com.capgemini.customer.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "address")
public class Address{
	
	private String streetNum;
	private String locality;
	private String state;
	private String country;
	private int pincode;
	
	public Address() {
		super();

	}
	public Address(String streetNum, String locality, String state, String country, int pincode) {
		super();
		this.streetNum = streetNum;
		this.locality = locality;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
	}
	public String getStreetNum() {
		return streetNum;
	}
	public void setStreetNum(String streetNum) {
		this.streetNum = streetNum;
	}
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "Address [streetNum=" + streetNum + ", locality=" + locality + ", state=" + state + ", country="
				+ country + ", pincode=" + pincode + "]";
	}
	
	
}

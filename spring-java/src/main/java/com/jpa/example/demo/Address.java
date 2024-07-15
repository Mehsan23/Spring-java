package com.jpa.example.demo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long addressId;
	private int streetNum;
	private String streetName;
	private String city;
	private String country;
	
	/*@OneToOne(mappedBy="address",fetch = FetchType.LAZY)
	@JoinColumn(name="customerId")
	@JsonIgnoreProperties("address")
	private Customer customer;*/
	
	public Address() {
			
	}
	public Address(int streetNum, String streetName, String city, String country) {
		super();
		this.streetNum = streetNum;
		this.streetName = streetName;
		this.city = city;
		this.country = country;
	}
	
	
	public int getStreetNum() {
		return streetNum;
	}
	public String getStreetName() {
		return streetName;
	}
	public String getCity() {
		return city;
	}
	public String getCountry() {
		return country;
	}
	public void setStreetNum(int streetNum) {
		this.streetNum = streetNum;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	
	public long getAddressId() {
		return addressId;
	}
	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}
	@Override
	public String toString() {
		return "Address [id=" + addressId + ", streetNum=" + streetNum + ", streetName=" + streetName + ", city=" + city
				+ ", country=" + country + "]";
	}
	
	
	
}

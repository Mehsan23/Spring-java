package com.jpa.example.demo;

public class AddressDTO {
	private int streetNumber;
	private String streetName;
	private String city;
	private String country;
	
	public AddressDTO() {
		
	}
	public AddressDTO(int streetNumber, String streetName, String city, String country) {
		super();
		this.streetNumber = streetNumber;
		this.streetName = streetName;
		this.city = city;
		this.country = country;
	}


	@Override
	public String toString() {
		return "AddressDTO [streetNumber=" + streetNumber + ", streetName=" + streetName + ", city=" + city
				+ ", country=" + country + "]";
	}


	public int getStreetNumber() {
		return streetNumber;
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

	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
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

}

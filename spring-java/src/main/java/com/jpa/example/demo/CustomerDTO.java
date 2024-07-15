package com.jpa.example.demo;

import java.util.ArrayList;
import java.util.List;

public class CustomerDTO {
	private String name; // = customer.firstname+customer.fullname
	private AddressDTO addressDTO;
	private List<AccountDTO> accountsDTO=new ArrayList<AccountDTO>();
	
	public CustomerDTO() {
		
	}
	public CustomerDTO(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public AddressDTO getAddressDTO() {
		return addressDTO;
	}
	public List<AccountDTO> getAccountsDTO() {
		return accountsDTO;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAddressDTO(AddressDTO addressDTO) {
		this.addressDTO = addressDTO;
	}
	public void setAccountsDTO(List<AccountDTO> accountsDTO) {
		this.accountsDTO = accountsDTO;
	}
	
	
}

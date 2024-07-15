package com.jpa.example.demo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long transactionId;
	private double amount;
	private String date;
	
	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name="customerId")
	private Customer customer;
	
	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name="accountId")
	@JsonIgnoreProperties({"customer"})
	private Account account;

	protected Transaction() {
	}

	public Transaction(double amount, String date) {
		super();
		this.amount = amount;
		this.date = date;
	}

	public long getId() {
		return transactionId;
	}
	
	public double getAmount() {
		return amount;
	}

	public String getDate() {
		return date;
	}

	public void setId(long id) {
		this.transactionId = id;
	}



	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public long getTransactionId() {
		return transactionId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Account getAccount() {
		return account;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setAccount(Account account) {
		this.account = account;
	}



}

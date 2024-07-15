package com.jpa.example.demo;

import java.util.ArrayList;
import java.util.List;

public class AccountDTO {
	private int accountNumber;
	private String name;
	private int balance;
	private List<TransactionDTO> transactionsDTO = new ArrayList<TransactionDTO>();

	
public AccountDTO() {
	
}
	public AccountDTO(int accountNumber, String name, int balance) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "AccountDTO [accountNumber=" + accountNumber + ", name=" + name + ", balance=" + balance + "]";
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public String getName() {
		return name;
	}

	public int getBalance() {
		return balance;
	}

	public List<TransactionDTO> getTransactionsDTO() {
		return transactionsDTO;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public void setTransactionsDTO(List<TransactionDTO> transactionsDTO) {
		this.transactionsDTO = transactionsDTO;
	}
}

package com.jpa.example.demo;

public class TransactionDTO {
private double amount;
private String date;

public TransactionDTO() {
	
}
public TransactionDTO(double amount, String date) {
	super();
	this.amount = amount;
	this.date = date;
}
@Override
public String toString() {
	return "TransactionDTO [amount=" + amount + ", date=" + date + "]";
}
public double getAmount() {
	return amount;
}
public String getDate() {
	return date;
}
public void setAmount(double amount) {
	this.amount = amount;
}
public void setDate(String date) {
	this.date = date;
}


}

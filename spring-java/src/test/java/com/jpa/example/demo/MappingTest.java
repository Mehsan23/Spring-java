package com.jpa.example.demo;

import static org.assertj.core.api.Assertions.*;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class MappingTest {
	CustomerMapper customerMapper = Mappers.getMapper(CustomerMapper.class);
	AddressMapper addressMapper = Mappers.getMapper(AddressMapper.class);
	AccountMapper accountMapper = Mappers.getMapper(AccountMapper.class);
	TransactionMapper transactionMapper = Mappers.getMapper(TransactionMapper.class);

	static Customer customer = new Customer("Ehsan", "Shah");
	static Address address = new Address(11, "Adama", "Wroclaw", "Poland");
	static Account account = new Account(2104832, "Ehsan", 132);
	static Transaction transaction1 = new Transaction(12, "5th July");
	static Transaction transaction2 = new Transaction(65, "8th July");
	
	static CustomerDTO customerDTOExpected = new CustomerDTO("Ehsan");
	static AddressDTO addressDTOExpected = new AddressDTO(11, "Adama", "Wroclaw", "Poland");
	static AccountDTO accountDTOExpected = new AccountDTO(2104832, "Ehsan", 132);
	static TransactionDTO transaction1DTOExpected = new TransactionDTO(12, "5th July");
	static TransactionDTO transaction2DTOExpected = new TransactionDTO(65, "8th July");

	@BeforeAll
	static void init() {
		customer.setAddress(address);
		account.getTransactions().add(transaction1);
		account.getTransactions().add(transaction2);
		customer.getAccounts().add(account);

		customerDTOExpected.setAddressDTO(addressDTOExpected);
		accountDTOExpected.getTransactionsDTO().add(transaction1DTOExpected);
		accountDTOExpected.getTransactionsDTO().add(transaction2DTOExpected);
		customerDTOExpected.getAccountsDTO().add(accountDTOExpected);
	}


	@Test
	void addressMapperTest() {
		AddressDTO addressDTOActual = addressMapper.toDTO(address);
		assertThat(addressDTOActual).usingRecursiveComparison().isEqualTo(addressDTOExpected);
	}

	@Test
	void customerMapperTest() {
		CustomerDTO customerDTOActual = customerMapper.toDTO(customer);
		assertThat(customerDTOActual).usingRecursiveComparison().isEqualTo(customerDTOExpected);
	}

	@Test
	void accountMapperTest() {
		AccountDTO accountDTOActual = accountMapper.toDTO(account);
		assertThat(accountDTOActual).usingRecursiveComparison().isEqualTo(accountDTOExpected);
	}

	@Test
	void transactionMapperTest() {
		TransactionDTO transaction1DTOActual = transactionMapper.toDTO(transaction1);
		assertThat(transaction1DTOActual).usingRecursiveComparison().isEqualTo(transaction1DTOExpected);
	}
}

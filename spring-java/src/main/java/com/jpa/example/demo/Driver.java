package com.jpa.example.demo;

import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Driver {

	private static final Logger log = LoggerFactory.getLogger(Driver.class);

	public static void main(String[] args) {
		 SpringApplication.run(Driver.class);		
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository customerRepository, AccountRepository accountRepository,
			TransactionRepository transactionRepository, AddressRepository addressRepository) {
		return (args) -> {
			// sample data
			Customer customer1 = new Customer("Hieu", "Hieu");
			Customer customer2 = new Customer("Harry", "Harry");
			customerRepository.save(customer1);
			customerRepository.save(customer2);

			Address address1 = new Address(11, "street1", "city1", "country1");
			Address address2 = new Address(22, "street2", "city2", "country2");
			addressRepository.save(address1);
			addressRepository.save(address2);

			customer1.setAddress(address1);
			customer2.setAddress(address2);
			customerRepository.save(customer1);
			customerRepository.save(customer2);

			Account account1 = new Account(2104832, "Hieu", 132);
			Account account2 = new Account(2918293, "Harry", 430);
			accountRepository.save(account1);
			accountRepository.save(account2);

			customer1.getAccounts().add(account1);
			customer2.getAccounts().add(account2);

			Transaction transaction1 = new Transaction(12, "5th June");
			Transaction transaction2 = new Transaction(65, "8th June");
			Transaction transaction3 = new Transaction(99, "9th June");

			account1.getTransactions().add(transaction1);
			account1.getTransactions().add(transaction2);
			account2.getTransactions().add(transaction3);

			transaction1.setCustomer(customer1);
			transaction2.setCustomer(customer1);
			transaction3.setCustomer(customer2);

			transaction1.setAccount(account1);
			transaction2.setAccount(account1);
			transaction3.setAccount(account2);

			transactionRepository.save(transaction1);
			transactionRepository.save(transaction2);
			transactionRepository.save(transaction3);

			account1.setCustomer(customer1);
			account2.setCustomer(customer2);
			accountRepository.save(account1);
			accountRepository.save(account2);

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Customer customer : customerRepository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// fetch all address
			log.info("Address found with findAll():");
			log.info("-------------------------------");
			for (Address address : addressRepository.findAll()) {
				log.info(address.toString());
			}
			log.info("");

			// fetch all transactions
			log.info("Transactions found with findAll():");
			log.info("-------------------------------");
			for (Transaction transaction : transactionRepository.findAll()) {
				log.info(transaction.toString());
			}
			log.info("");

			// fetch all accounts
			log.info("Accounts found with findAll():");
			log.info("-------------------------------");
			for (Account account : accountRepository.findAll()) {
				log.info(account.toString());
			}
			log.info("");

			// fetch accounts by balances
			log.info("Account(s) found with findByBalanceBetween(100,500)");
			log.info("--------------------------------");
			for (Account account : accountRepository.findByBalanceBetween(100, 500)) {
				log.info(account.toString());
			}
			log.info("");

			// fetch account by last name
			log.info("Account found with findByNameStartingWith(\"acc\")");
			log.info("--------------------------------------------");
			accountRepository.findByNameStartingWith("acc").forEach(result -> {
				log.info(result.toString());
			});
			log.info("");

			// fetch an individual customer by ID
			Customer customer = customerRepository.findById(1L);
			log.info("Customer found with findById(1L):");
			log.info("--------------------------------");
			log.info(customer.toString());
			log.info("");

			// fetch customers by last name
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			customerRepository.findByLastName("Bauer").forEach(bauer -> {
				log.info(bauer.toString());
			});
			// for (Customer bauer : repository.findByLastName("Bauer")) {
			// log.info(bauer.toString());
			// }
			log.info("");
		};
	}

}
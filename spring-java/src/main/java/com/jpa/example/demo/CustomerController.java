package com.jpa.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;

	@GetMapping()
	public Iterable<Customer> findAll() {
		return customerRepository.findAll();
	}
	
//	@GetMapping("/viewAll")
//	public String viewCustomers(Model model) {
//		model.addAttribute("customerList", customerRepository.findAll());
//		return "customers";
//	}

	@GetMapping("/lastname/{name}")
	public List<Customer> findByLastName(@PathVariable String name) {
		return customerRepository.findByLastName(name);
	}

	@GetMapping("/{id}")
	public Customer findById(@PathVariable Long id) {
		return customerRepository.findById(id).orElseThrow(IllegalArgumentException::new);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Customer create(@RequestBody Customer customer) {
		return customerRepository.save(customer);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		customerRepository.findById(id).orElseThrow(IllegalArgumentException::new);
		customerRepository.deleteById(id);
	}

	@PutMapping("/{id}")
	public Customer updateCustomer(@RequestBody Customer customer, @PathVariable Long id) {
		if (customer.getId() != id) {
			throw new IllegalArgumentException();
		}
		customerRepository.findById(id).orElseThrow(IllegalArgumentException::new);
		return customerRepository.save(customer);
	}
}

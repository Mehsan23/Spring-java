package com.jpa.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/addresses")
public class AddressController {

	@Autowired
	private AddressRepository addressRepository;

	@GetMapping
	public Iterable<Address> findAll() {
		return addressRepository.findAll();
	}
	
	@GetMapping("/viewAll")
	public String viewAddresses(Model model) {
		model.addAttribute("addressList", addressRepository.findAll());
		return "addresses";
	}
	
	@GetMapping("/viewOne")
	public String viewAddress(@RequestParam(name="id") long id, Model model) {
		//System.out.println(addressRepository.findById(id).getId());
		model.addAttribute("address", addressRepository.findById(id));
		return "address";

	}

	@GetMapping("/{id}")
	public Address findById(@PathVariable Long id) {
		return addressRepository.findById(id).orElseThrow(IllegalArgumentException::new);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Address create(@RequestBody Address address) {
		return addressRepository.save(address);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		addressRepository.findById(id).orElseThrow(IllegalArgumentException::new);
		addressRepository.deleteById(id);
	}

	@PutMapping("/{id}")
	public Address updateAddress(@RequestBody Address address, @PathVariable Long id) {
		if (address.getAddressId() != id) {
			throw new IllegalArgumentException();
		}
		addressRepository.findById(id).orElseThrow(IllegalArgumentException::new);
		return addressRepository.save(address);
	}
}

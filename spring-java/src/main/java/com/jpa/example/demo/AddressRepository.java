package com.jpa.example.demo;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
  Address findById(long id);
}


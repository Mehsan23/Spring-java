package com.jpa.example.demo;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {

  List<Account> findByNameStartingWith(String name);

  Account findById(long id);
  
  List<Account> findByBalanceBetween(int low, int high);
}


package com.jpa.example.demo;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {
  Transaction findById(long id);
  List<Transaction> findByAmount(int amount);
  List<Transaction> findByDate(String date);
}


package com.jpa.example.demo;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
	TransactionDTO toDTO(Transaction transaction);
	Transaction toDAO(TransactionDTO transactionDTO);
}

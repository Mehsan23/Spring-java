package com.jpa.example.demo;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { TransactionMapper.class })
public interface AccountMapper {

	@Mapping(source="account.transactions", target="transactionsDTO")
	AccountDTO toDTO(Account account);
	
	@Mapping(source="accountDTO.transactionsDTO", target="transactions")
	Account toDAO(AccountDTO accountDTO);
}

package com.jpa.example.demo;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AddressMapper {

	@Mapping(source = "address.streetNum", target = "streetNumber") // map difference field names
	AddressDTO toDTO(Address address);
	
	@Mapping(source = "addressDTO.streetNumber", target = "streetNum")
	Address toDAO(AddressDTO addressDTO);
}

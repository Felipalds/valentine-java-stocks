package com.valentinejavastocks.Converters;

import com.valentinejavastocks.DTOs.CustomerDTO;
import com.valentinejavastocks.Domains.Customer;

public class CustomerConverter {
    public static CustomerDTO toDTO(Customer customer) {
        return CustomerDTO.builder()
                .id(customer.getId())
                .name(customer.getName())
                .password(customer.getPassword())
                .email(customer.getEmail())
                .build();
    }

    public static Customer toEntity(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setId(customerDTO.getId());
        customer.setName(customerDTO.getName());
        customer.setPassword(customerDTO.getPassword());
        customer.setEmail(customerDTO.getEmail());
        return customer;
    }
}

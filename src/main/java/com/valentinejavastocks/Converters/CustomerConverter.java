package com.valentinejavastocks.Converters;

import com.valentinejavastocks.Domains.Customer;
import com.valentinejavastocks.DTOs.CustomerDTO;
import com.valentinejavastocks.Exceptions.CustomerNotFoundException;
import com.valentinejavastocks.Repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CustomerConverter {

    private final CustomerRepository customerRepository;

    public CustomerDTO toDTO(Customer customer) {
        return CustomerDTO.builder()
                .id(customer.getId())
                .name(customer.getName())
                .password(customer.getPassword())
                .email(customer.getEmail())
                .build();
    }

    public  Customer toEntity(Long customerId) {
        return customerRepository.findById(customerId).orElseThrow(CustomerNotFoundException::new);
    }

    public Customer toEntity (CustomerDTO dto) {
        return Customer.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .build();
    }
}

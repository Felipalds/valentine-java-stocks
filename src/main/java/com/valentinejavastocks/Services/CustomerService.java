package com.valentinejavastocks.Services;

import com.valentinejavastocks.DTOs.SignInDTO;
import com.valentinejavastocks.Domains.Customer;
import com.valentinejavastocks.Exceptions.CustomerAlreadyExistsException;
import com.valentinejavastocks.Exceptions.CustomerNotFoundException;
import com.valentinejavastocks.Exceptions.InvalidPasswordException;
import com.valentinejavastocks.Repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CustomerService {

    private final CustomerRepository repository;

    public Customer auth (SignInDTO signInDTO) {
        Optional<Customer> customer = repository.findCustomerByEmail(signInDTO.getEmail());

        if(customer.isEmpty()) {
            throw new CustomerNotFoundException();
        }

        if (!signInDTO.getPassword().equals(customer.get().getPassword())) {
            throw new InvalidPasswordException();
        }

        return customer.get();
    }

    public Customer createNewCustomer (Customer customer) {
        try {
            return repository.save(customer);
        } catch (DataIntegrityViolationException e) {
            throw new CustomerAlreadyExistsException();
        }
    }

}

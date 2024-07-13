package com.valentinejavastocks.Services;

import com.valentinejavastocks.Domains.Customer;
import com.valentinejavastocks.Exceptions.CustomerAlreadyExistsException;
import com.valentinejavastocks.Repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomerService {

    private final CustomerRepository repository;

    public Customer createNewCustomer (Customer customer) {
        try {
            return repository.save(customer);
        } catch (DataIntegrityViolationException e) {
            throw new CustomerAlreadyExistsException();
        }
    }

}

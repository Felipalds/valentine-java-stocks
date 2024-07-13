package com.valentinejavastocks.Controllers;

import com.valentinejavastocks.Converters.CustomerConverter;
import com.valentinejavastocks.DTOs.CustomerDTO;
import com.valentinejavastocks.Exceptions.CustomerAlreadyExistsException;
import com.valentinejavastocks.Services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService service;
    private final CustomerConverter converter;

    @PostMapping("/sign-up")
    public ResponseEntity<?> signUp (@RequestBody CustomerDTO customerDTO) {
        try {
            CustomerDTO createdCustomer = converter.toDTO(service.createNewCustomer(converter.toEntity(customerDTO)));
            return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
        } catch (CustomerAlreadyExistsException e) {
           return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }


}

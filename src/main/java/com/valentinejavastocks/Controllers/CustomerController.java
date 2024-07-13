package com.valentinejavastocks.Controllers;

import com.valentinejavastocks.Converters.CustomerConverter;
import com.valentinejavastocks.DTOs.CustomerDTO;
import com.valentinejavastocks.DTOs.SignInDTO;
import com.valentinejavastocks.Exceptions.CustomerAlreadyExistsException;
import com.valentinejavastocks.Exceptions.CustomerNotFoundException;
import com.valentinejavastocks.Exceptions.InvalidPasswordException;
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

    @PostMapping("/sign-in")
    public ResponseEntity<?> signIn (@RequestBody SignInDTO signInDTO) {
        try {
            CustomerDTO customerDTO = converter.toDTO(service.auth(signInDTO));
            return new ResponseEntity<>(customerDTO, HttpStatus.OK);
        } catch (CustomerNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (InvalidPasswordException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }

}

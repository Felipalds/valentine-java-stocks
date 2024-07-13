package com.valentinejavastocks.DTOs;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class CustomerDTO implements Serializable {
    private Long id;
    private String name;
    private String username;
    private String password;
    private String email;
}
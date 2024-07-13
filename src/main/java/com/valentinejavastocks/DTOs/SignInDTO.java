package com.valentinejavastocks.DTOs;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class SignInDTO implements Serializable {

    private String email;
    private String password;
}

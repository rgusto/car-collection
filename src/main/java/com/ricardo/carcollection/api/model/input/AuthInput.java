package com.ricardo.carcollection.api.model.input;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthInput {

    @NotBlank
    private String login;
    @NotBlank
    private String password;

}
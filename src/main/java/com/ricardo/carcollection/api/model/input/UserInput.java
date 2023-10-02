package com.ricardo.carcollection.api.model.input;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class UserInput {

    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String email;
    @NotNull
    private Date birthday;
    @NotBlank
    private String login;
    @NotBlank
    private String password;
    @NotBlank
    private String phone;
    @NotNull
    private List<CarInput> cars;

}

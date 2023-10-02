package com.ricardo.carcollection.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
public class UserInputUpdate {

    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotNull
    private Date birthday;
    @NotBlank
    private String phone;

}

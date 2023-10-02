package com.ricardo.carcollection.api.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class UserModel {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Date birthday;
    private String login;
    private String phone;
    private List<CarModel> cars;

}

package com.ricardo.carcollection.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class UserModel {

    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private Date birthday;
    private String login;
    private String phone;
    private String createdAt;
    private String lastLoginAt;
    private List<CarModel> cars;

}

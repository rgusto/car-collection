package com.ricardo.carcollection.domain.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private Date birthday;
    private String login;
    private String password;
    private String phone;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Car> cars;

}

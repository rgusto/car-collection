package com.ricardo.carcollection.api.controller;

import com.ricardo.carcollection.api.contract.UserAPI;
import com.ricardo.carcollection.api.converter.UserConverter;
import com.ricardo.carcollection.api.model.UserModel;
import com.ricardo.carcollection.api.model.input.UserInput;
import com.ricardo.carcollection.api.model.input.UserInputUpdate;
import com.ricardo.carcollection.domain.entity.User;
import com.ricardo.carcollection.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class UserController implements UserAPI {

    @Autowired
    private UserService userService;

    @Autowired
    private UserConverter userConverter;

    @Override
    public List<UserModel> findAll() {
        return userConverter.toCollectionModel(userService.findAll());
    }

    @Override
    public ResponseEntity<UserModel> findById(UUID id) {
        User user = userService.findById(id);
        return ResponseEntity.ok(userConverter.toModel(user));
    }

    @Override
    @Transactional
    public UserModel create(UserInput input) {
        User user = userConverter.toDomainObject(input);
        userService.create(user);
        return userConverter.toModel(user);
    }

    @Override
    @Transactional
    public ResponseEntity<?> delete(UUID id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public UserModel update(UUID id, UserInputUpdate input) {
        User user = userConverter.toDomainObject(input);
        user.setId(id);
        User userDb = userService.update(user);
        return userConverter.toModel(userDb);
    }
}

package com.ricardo.carcollection.api.converter;

import com.ricardo.carcollection.api.model.UserModel;
import com.ricardo.carcollection.api.model.input.UserInput;
import com.ricardo.carcollection.api.model.input.UserInputUpdate;
import com.ricardo.carcollection.domain.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserConverter {
    @Autowired
    private ModelMapper modelMapper;

    public UserModel toModel(User user) {
        return modelMapper.map(user, UserModel.class);
    }

    public List<UserModel> toCollectionModel(List<User> users) {
        return users.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    public User toDomainObject(UserInput input) {
        return modelMapper.map(input, User.class);
    }

    public User toDomainObject(UserInputUpdate input) {
        return modelMapper.map(input, User.class);
    }
}

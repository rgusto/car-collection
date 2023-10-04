package com.ricardo.carcollection.api.converter;

import com.ricardo.carcollection.api.model.UserModel;
import com.ricardo.carcollection.api.model.input.UserInput;
import com.ricardo.carcollection.api.model.input.UserInputUpdate;
import com.ricardo.carcollection.domain.entity.Car;
import com.ricardo.carcollection.domain.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;

@SpringBootTest
public class UserConverterTest {

    @Autowired
    private UserConverter userConverter;

    @Test
    public void validate_domainObjectToModel() throws ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        User user = User.builder()
                .firstName("Hello")
                .lastName("World")
                .email("hello@world.com")
                .birthday(dateFormat.parse("1990-05-01"))
                .login("hello.world")
                .password("123")
                .phone("988888888")
                .cars(Collections.singletonList(
                        Car.builder()
                                .year(2018)
                                .licensePlate("PDV-0251")
                                .model("Audi")
                                .color("White")
                                .build()
                )).build();

        UserModel userModel = userConverter.toModel(user);

        Assertions.assertNotNull(userModel);
        Assertions.assertEquals("Hello", userModel.getFirstName());

    }

    @Test
    public void validate_inputToDomainObject() {

        UserInput userInput = new UserInput();
        userInput.setFirstName("Hello");
        userInput.setLastName("World");

        User user = userConverter.toDomainObject(userInput);

        Assertions.assertNotNull(user);
        Assertions.assertEquals("Hello", user.getFirstName());

    }

    @Test
    public void validate_inputUpdateToDomainObject() {

        UserInputUpdate userInputUpdate = new UserInputUpdate();
        userInputUpdate.setFirstName("Hello");
        userInputUpdate.setLastName("World");

        User user = userConverter.toDomainObject(userInputUpdate);

        Assertions.assertNotNull(user);
        Assertions.assertEquals("Hello", user.getFirstName());

    }

}

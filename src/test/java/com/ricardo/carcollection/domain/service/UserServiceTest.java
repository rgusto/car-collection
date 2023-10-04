package com.ricardo.carcollection.domain.service;

import com.ricardo.carcollection.domain.entity.Car;
import com.ricardo.carcollection.domain.entity.User;
import com.ricardo.carcollection.domain.exception.EntityInUseException;
import com.ricardo.carcollection.domain.exception.UserEmailAlreadyExistsException;
import com.ricardo.carcollection.domain.exception.UserLoginAlreadyExistsException;
import com.ricardo.carcollection.domain.exception.UserNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.UUID;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;


    @Test
    public void shouldGetSuccess_whenCreatingUser() throws ParseException {
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
        User userCreated = userService.create(user);
        Assertions.assertEquals("Hello", userCreated.getFirstName());
    }

    @Test
    public void shouldFail_whenCreatingUser_withInvalidLoginOrPassword() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            userService.create(new User());
        });
    }

    @Test
    public void shouldFail_whenCreatingUser_withExistentLogin() {
        Assertions.assertThrows(UserLoginAlreadyExistsException.class, () -> {
            userService.create(User.builder().login("john.doe").build());
        });
    }

    @Test
    public void shouldFail_whenCreatingUser_withExistentEmail() {
        Assertions.assertThrows(UserEmailAlreadyExistsException.class, () -> {
            userService.create(User.builder().email("john@doe.com").build());
        });
    }

    @Test
    public void shouldFail_whenUpdatingUser_nonExistent() {
        Assertions.assertThrows(UserNotFoundException.class, () -> {
            userService.update(User.builder().id(UUID.randomUUID()).build());
        });
    }

    @Test
    public void shouldFail_whenDeletingUser_nonExistent() {
        Assertions.assertThrows(UserNotFoundException.class, () -> {
            userService.delete(UUID.randomUUID());
        });
    }

    @Test
    public void shouldFail_whenDeletingUser_withCarsAssociated() {
        Assertions.assertThrows(EntityInUseException.class, () -> {
            userService.delete(UUID.fromString("397f0134-5cec-4c5e-b100-401e11d1b6b1"));
        });
    }


}

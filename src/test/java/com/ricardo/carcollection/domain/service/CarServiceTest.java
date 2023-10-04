package com.ricardo.carcollection.domain.service;

import com.ricardo.carcollection.domain.entity.Car;
import com.ricardo.carcollection.domain.entity.User;
import com.ricardo.carcollection.domain.exception.CarLicensePlateAlreadyExistsException;
import com.ricardo.carcollection.domain.exception.CarNotFoundException;
import com.ricardo.carcollection.domain.exception.EntityInUseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.util.UUID;

@SpringBootTest
public class CarServiceTest {

    private static final UUID USER_ID = UUID.fromString("397f0134-5cec-4c5e-b100-401e11d1b6b1");

    @Autowired
    private CarService carService;

    @Autowired
    private UserService userService;

    @Test
    public void shouldGetSuccess_WhenCreatingCar() throws ParseException {
        User user = userService.findById(USER_ID);
        Car car = Car.builder()
                .year(2018)
                .licensePlate("PDV-0141")
                .model("Audi")
                .color("White")
                .build();
        Car userCreated = carService.create(car, user);
        Assertions.assertEquals(2018, userCreated.getYear());
    }

    @Test
    public void shouldFail_WhenCreatingCar_WithExistentLicensePlate() {
        User user = userService.findById(USER_ID);
        Assertions.assertThrows(CarLicensePlateAlreadyExistsException.class, () -> {
            carService.create(Car.builder().licensePlate("AAA-0145").build(), user);
        });
    }

    @Test
    public void shouldFail_WhenUpdatingCar_NonExistent() {
        User user = userService.findById(USER_ID);
        Assertions.assertThrows(CarNotFoundException.class, () -> {
            carService.update(Car.builder().id(UUID.randomUUID()).build(), user);
        });
    }

    @Test
    public void shouldFail_WhenDeletingCar_NonExistent() {
        User user = userService.findById(USER_ID);
        Assertions.assertThrows(CarNotFoundException.class, () -> {
            carService.delete(UUID.randomUUID(), user);
        });
    }

}

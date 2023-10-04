package com.ricardo.carcollection.api.converter;

import com.ricardo.carcollection.api.model.CarModel;
import com.ricardo.carcollection.api.model.UserModel;
import com.ricardo.carcollection.api.model.input.CarInput;
import com.ricardo.carcollection.api.model.input.CarInputUpdate;
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
public class CarConverterTest {

    @Autowired
    private CarConverter carConverter;

    @Test
    public void validate_domainObjectToModel() throws ParseException {

        Car car = Car.builder()
                .year(2018)
                .licensePlate("PDV-0141")
                .model("Audi")
                .color("White")
                .build();

        CarModel carModel = carConverter.toModel(car);

        Assertions.assertNotNull(carModel);
        Assertions.assertEquals(2018, carModel.getYear());

    }

    @Test
    public void validate_inputToDomainObject() {

        CarInput carInput = new CarInput();
        carInput.setYear(2018);
        carInput.setModel("Audi");

        Car car = carConverter.toDomainObject(carInput);

        Assertions.assertNotNull(car);
        Assertions.assertEquals(2018, car.getYear());

    }

    @Test
    public void validate_inputUpdateToDomainObject() {

        CarInputUpdate carInputUpdate = new CarInputUpdate();
        carInputUpdate.setYear(2018);
        carInputUpdate.setModel("Audi");

        Car car = carConverter.toDomainObject(carInputUpdate);

        Assertions.assertNotNull(car);
        Assertions.assertEquals(2018, car.getYear());

    }

}

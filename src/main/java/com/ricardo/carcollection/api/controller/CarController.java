package com.ricardo.carcollection.api.controller;

import com.ricardo.carcollection.api.contract.CarAPI;
import com.ricardo.carcollection.api.converter.CarConverter;
import com.ricardo.carcollection.api.model.CarModel;
import com.ricardo.carcollection.api.model.input.CarInput;
import com.ricardo.carcollection.api.model.input.CarInputUpdate;
import com.ricardo.carcollection.domain.entity.Car;
import com.ricardo.carcollection.domain.entity.User;
import com.ricardo.carcollection.domain.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class CarController implements CarAPI {

    @Autowired
    private CarService carService;

    @Autowired
    private CarConverter carConverter;

    @Override
    public List<CarModel> findAll(User authenticatedUser) {
        return carConverter.toCollectionModel(carService.findAllByUserId(authenticatedUser.getId()));
    }

    @Override
    public ResponseEntity<CarModel> findById(UUID id, User authenticatedUser) {
        Car car = carService.findById(id, authenticatedUser.getId());
        return ResponseEntity.ok(carConverter.toModel(car));
    }

    @Override
    @Transactional
    public CarModel create(CarInput input, User authenticatedUser) {
        Car car = carConverter.toDomainObject(input);
        carService.create(car, authenticatedUser);
        return carConverter.toModel(car);
    }

    @Override
    @Transactional
    public ResponseEntity<?> delete(UUID id, User authenticatedUser) {
        carService.delete(id, authenticatedUser);
        return ResponseEntity.noContent().build();
    }

    @Override
    public CarModel update(UUID id, CarInputUpdate input, User authenticatedUser) {
        Car car = carConverter.toDomainObject(input);
        car.setId(id);
        Car carDb = carService.update(car, authenticatedUser);
        return carConverter.toModel(carDb);
    }
}

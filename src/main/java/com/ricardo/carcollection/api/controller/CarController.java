package com.ricardo.carcollection.api.controller;

import com.ricardo.carcollection.api.contract.CarAPI;
import com.ricardo.carcollection.api.converter.CarConverter;
import com.ricardo.carcollection.api.model.CarModel;
import com.ricardo.carcollection.api.model.input.CarInput;
import com.ricardo.carcollection.api.model.input.CarInputUpdate;
import com.ricardo.carcollection.domain.entity.Car;
import com.ricardo.carcollection.domain.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarController implements CarAPI {

    @Autowired
    private CarService carService;

    @Autowired
    private CarConverter carConverter;

    @Override
    public List<CarModel> findAll() {
        return carConverter.toCollectionModel(carService.findAll());
    }

    @Override
    public ResponseEntity<CarModel> findById(Long id) {
        Car car = carService.findById(id);
        return ResponseEntity.ok(carConverter.toModel(car));
    }

    @Override
    @Transactional
    public CarModel create(CarInput input) {
        Car car = carConverter.toDomainObject(input);
        carService.create(car);
        return carConverter.toModel(car);
    }

    @Override
    @Transactional
    public ResponseEntity<?> delete(Long id) {
        carService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public CarModel update(Long id, CarInputUpdate input) {
        Car car = carConverter.toDomainObject(input);
        car.setId(id);
        Car carDb = carService.update(car);
        return carConverter.toModel(carDb);
    }
}

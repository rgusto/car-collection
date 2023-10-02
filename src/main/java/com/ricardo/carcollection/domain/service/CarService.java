package com.ricardo.carcollection.domain.service;

import com.ricardo.carcollection.domain.entity.Car;
import com.ricardo.carcollection.domain.entity.User;
import com.ricardo.carcollection.domain.exception.CarLicensePlateAlreadyExistsException;
import com.ricardo.carcollection.domain.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public List<Car> findAll() {
        return carRepository.findAll();
    }

    public Optional<Car> findById(UUID id) {
        return carRepository.findById(id);
    }

    @Transactional
    public Car create(Car car, User user) {
        Optional<Car> optionalCar = carRepository.findByLicensePlate(car.getLicensePlate());
        if (optionalCar.isPresent()) {
            throw new CarLicensePlateAlreadyExistsException(car.getId(), car.getLicensePlate());
        }
        return carRepository.save(car);
    }

    @Transactional
    public List<Car> create(List<Car> cars, User user) {
        List<Car> carList = new ArrayList<>();
        cars.stream().forEach(car -> {
            carList.add(this.create(car, user));
        });
        return carList;
    }

}

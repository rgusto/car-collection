package com.ricardo.carcollection.domain.service;

import com.ricardo.carcollection.domain.entity.Car;
import com.ricardo.carcollection.domain.entity.User;
import com.ricardo.carcollection.domain.exception.CarLicensePlateAlreadyExistsException;
import com.ricardo.carcollection.domain.exception.CarNotFoundException;
import com.ricardo.carcollection.domain.exception.EntityInUseException;
import com.ricardo.carcollection.domain.repository.CarRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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

    public List<Car> findAllByUserId(UUID userId) {
        return carRepository.findAllByUserId(userId);
    }

    public Car findById(UUID id, UUID userId) {
        return carRepository.findByIdAndUserId(id, userId).orElseThrow(() -> new CarNotFoundException(id));
    }

    @Transactional
    public Car create(Car car, User user) {
        Optional<Car> optionalCar = carRepository.findByLicensePlate(car.getLicensePlate());
        if (optionalCar.isPresent()) {
            throw new CarLicensePlateAlreadyExistsException(car.getId(), car.getLicensePlate());
        }
        car.setUser(user);
        return carRepository.save(car);
    }

    @Transactional
    public List<Car> create(List<Car> cars, User user) {
        List<Car> carList = new ArrayList<>();
        cars.forEach(car -> {
            carList.add(this.create(car, user));
        });
        return carList;
    }

    @Transactional
    public void delete(UUID id, User user) {
        try {
            Car carDb = this.findById(id, user.getId());
            carRepository.deleteById(carDb.getId());
            carRepository.flush();
        } catch (EmptyResultDataAccessException e) {
            throw new CarNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new EntityInUseException("Car with id %s is in use and cannot be removed".formatted(id));
        }
    }

    @Transactional
    public Car update(Car car, User user) {
        Car carDb = this.findById(car.getId(), user.getId());
        BeanUtils.copyProperties(car, carDb, "id");
        carRepository.save(carDb);
        return carDb;
    }

}

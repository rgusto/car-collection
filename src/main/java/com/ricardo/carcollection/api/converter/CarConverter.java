package com.ricardo.carcollection.api.converter;

import com.ricardo.carcollection.api.model.CarModel;
import com.ricardo.carcollection.api.model.input.CarInput;
import com.ricardo.carcollection.domain.entity.Car;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarConverter {
    @Autowired
    private ModelMapper modelMapper;

    public CarModel toModel(Car car) {
        return modelMapper.map(car, CarModel.class);
    }

    public List<CarModel> toCollectionModel(List<Car> cars) {
        return cars.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    public Car toDomainObject(CarInput input) {
        return modelMapper.map(input, Car.class);
    }
}

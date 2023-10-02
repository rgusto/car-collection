package com.ricardo.carcollection.domain.repository;

import com.ricardo.carcollection.domain.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Long> {

    Optional<Car> findByLicensePlate(String licensePlate);

}

package com.ricardo.carcollection.domain.repository;

import com.ricardo.carcollection.domain.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CarRepository extends JpaRepository<Car, UUID> {

    List<Car> findAllByUserId(UUID userId);

    Optional<Car> findByIdAndUserId(UUID id, UUID userId);

    Optional<Car> findByLicensePlate(String licensePlate);

}

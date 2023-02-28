package com.rentacar.RentACar.repository;

import com.rentacar.RentACar.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CarRepository extends JpaRepository<Car, UUID> {

    List<Car> findByYearAndPower(Integer year, Integer power);
}

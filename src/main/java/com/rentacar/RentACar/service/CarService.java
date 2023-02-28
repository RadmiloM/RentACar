package com.rentacar.RentACar.service;

import com.rentacar.RentACar.entity.Car;
import com.rentacar.RentACar.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public void addCar(Car car){
        carRepository.save(car);
    }

    public List<Car> fetchAllCars(){
        return carRepository.findAll();
    }
}

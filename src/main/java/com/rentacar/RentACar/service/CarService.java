package com.rentacar.RentACar.service;

import com.rentacar.RentACar.entity.Car;
import com.rentacar.RentACar.exception.CarNotFoundException;
import com.rentacar.RentACar.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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

    public Car getCarById(UUID uuid){
        var car = carRepository.findById(uuid);
        if(car.isEmpty()){
            throw new CarNotFoundException("car with id " + uuid + " does not exists in database");
        }
        return car.get();
    }
}

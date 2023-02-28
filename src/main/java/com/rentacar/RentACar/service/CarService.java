package com.rentacar.RentACar.service;

import com.rentacar.RentACar.entity.Car;
import com.rentacar.RentACar.exception.CarNotFoundException;
import com.rentacar.RentACar.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public void addCar(Car car) {
        carRepository.save(car);
    }

    public List<Car> fetchAllCars() {
        return carRepository.findAll();
    }

    public Car getCarById(UUID uuid) {
        var car = carRepository.findById(uuid);
        if (car.isEmpty()) {
            throw new CarNotFoundException("car with id " + uuid + " does not exists in database");
        }
        return car.get();
    }

    public void updateCar(Car car, UUID uuid) {
        var carDB = carRepository.findById(uuid);
        if(carDB.isEmpty()){
            throw  new CarNotFoundException("car with id " + uuid + " does not exists in database");
        }
        var optionalUser = carDB.get();
        if (Objects.nonNull(car.getLicencePlate()) && !"".equals(car.getLicencePlate())) {
            optionalUser.setLicencePlate(car.getLicencePlate());
        }
        if (Objects.nonNull(car.getMake()) && !"".equals(car.getMake())) {
            optionalUser.setMake(car.getMake());
        }
        if (Objects.nonNull(car.getModel()) && !"".equals(car.getModel())) {
            optionalUser.setModel(car.getModel());
        }
        if (Objects.nonNull(car.getYear())) {
            optionalUser.setYear(car.getYear());
        }
        if (Objects.nonNull(car.getEngineCapacity())) {
            optionalUser.setEngineCapacity(car.getEngineCapacity());
        }
        if (Objects.nonNull(car.getColor()) && !"".equals(car.getColor())) {
            optionalUser.setColor(car.getColor());
        }
        if (Objects.nonNull(car.getPrice())) {
            optionalUser.setPrice(car.getPrice());
        }
        if (Objects.nonNull(car.getDoors())) {
            optionalUser.setDoors(car.getDoors());
        }
        if (Objects.nonNull(car.getSize())) {
            optionalUser.setSize(car.getSize());
        }
        if (Objects.nonNull(car.getPower())) {
            optionalUser.setPower(car.getPower());
        }
        if (Objects.nonNull(car.getAutomatic())) {
            optionalUser.setAutomatic(car.getAutomatic());
        }
        if (Objects.nonNull(car.getFuel()) && !"".equals(car.getFuel())) {
            optionalUser.setFuel(car.getFuel());
        }
        if (Objects.nonNull(car.getImage()) && !"".equals(car.getImage())) {
            optionalUser.setImage(car.getImage());
        }
        carRepository.save(optionalUser);


    }
}

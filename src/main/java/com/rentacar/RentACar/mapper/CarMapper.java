package com.rentacar.RentACar.mapper;

import com.rentacar.RentACar.dto.CarRequest;
import com.rentacar.RentACar.dto.CarResponse;
import com.rentacar.RentACar.entity.Car;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarMapper {

    public Car mapToEntity(CarRequest carRequest) {
        Car car = new Car();
        car.setLicencePlate(carRequest.getLicencePlate());
        car.setMake(carRequest.getMake());
        car.setModel(carRequest.getModel());
        car.setYear(carRequest.getYear());
        car.setEngineCapacity(carRequest.getEngineCapacity());
        car.setColor(carRequest.getColor());
        car.setPrice(carRequest.getPrice());
        car.setDoors(carRequest.getDoors());
        car.setSize(carRequest.getSize());
        car.setPower(carRequest.getPower());
        car.setAutomatic(car.isAutomatic());
        car.setFuel(carRequest.getFuel());
        car.setImage(carRequest.getImage());
        return car;
    }

    public CarResponse mapToDTO(Car car) {
        CarResponse carResponse = new CarResponse();
        carResponse.setLicencePlate(car.getLicencePlate());
        carResponse.setMake(car.getMake());
        carResponse.setModel(car.getModel());
        carResponse.setYear(car.getYear());
        carResponse.setEngineCapacity(car.getEngineCapacity());
        carResponse.setColor(car.getColor());
        carResponse.setPrice(car.getPrice());
        carResponse.setDoors(car.getDoors());
        carResponse.setSize(car.getSize());
        carResponse.setPower(car.getPower());
        carResponse.setAutomatic(car.isAutomatic());
        carResponse.setFuel(car.getFuel());
        carResponse.setImage(car.getImage());
        return carResponse;
    }

    public List<CarResponse> mapToDTO(List<Car> cars) {
        return cars.stream().map(this::mapToDTO).collect(Collectors.toList());
    }
}

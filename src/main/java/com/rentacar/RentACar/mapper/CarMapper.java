package com.rentacar.RentACar.mapper;

import com.rentacar.RentACar.dto.CarRequest;
import com.rentacar.RentACar.entity.Car;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {

    public Car mapToEntity(CarRequest carRequest){
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
}

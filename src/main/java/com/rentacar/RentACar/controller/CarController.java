package com.rentacar.RentACar.controller;

import com.rentacar.RentACar.dto.CarRequest;
import com.rentacar.RentACar.dto.CarResponse;
import com.rentacar.RentACar.mapper.CarMapper;
import com.rentacar.RentACar.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;
    private final CarMapper carMapper;


    @PostMapping("/cars")
    public ResponseEntity<Void> addCar(@RequestBody CarRequest carRequest, @RequestHeader("id") UUID uuid){
            var car = carMapper.mapToEntity(carRequest);
            carService.addCar(car);
            return ResponseEntity.ok().build();
    }

    @GetMapping("/cars")
    public ResponseEntity<List<CarResponse>> fetchAllCars(){
        var cars = carService.fetchAllCars();
        var carsResponse = carMapper.mapToDTO(cars);
        return ResponseEntity.ok(carsResponse);
    }

    @GetMapping("/cars/{carId}")
    public ResponseEntity<CarResponse> getCarById(@PathVariable("carId") UUID uuid){
        var car = carService.getCarById(uuid);
        var carResponse = carMapper.mapToDTO(car);
        return ResponseEntity.ok(carResponse);
    }

    @PutMapping("/cars/{carId}")
    public ResponseEntity<Void> updateCar(@RequestBody CarRequest carRequest,@PathVariable("carId") UUID carId){
        var car  = carMapper.mapToEntity(carRequest);
        carService.updateCar(car,carId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/cars/{carId}")
    public void deleteCarById(@RequestHeader("carId") UUID uuid){
        carService.deleteCar(uuid);
    }
    @GetMapping("/cars/search")
    public ResponseEntity<List<CarResponse>> findByYearAndPower(@RequestParam Integer year, @RequestParam Integer power){
        var cars = carService.findByYearAndPower(year,power);
        var carResponse = carMapper.mapToDTO(cars);
        return ResponseEntity.ok(carResponse);
    }


}

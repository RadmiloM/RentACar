package com.rentacar.RentACar.exception;

public class CarNotFoundException extends RuntimeException{

    public CarNotFoundException(String message){
        super(message);
    }
}

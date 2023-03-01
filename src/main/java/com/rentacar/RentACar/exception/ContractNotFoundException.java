package com.rentacar.RentACar.exception;

public class ContractNotFoundException extends RuntimeException{

    public ContractNotFoundException(String message){
        super(message);
    }
}

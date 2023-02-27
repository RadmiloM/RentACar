package com.rentacar.RentACar.exception;

public class UsernameNotFoundException extends RuntimeException{

    public UsernameNotFoundException(String message){
        super(message);
    }
}

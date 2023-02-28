package com.rentacar.RentACar.controller;

import com.rentacar.RentACar.exception.CarNotFoundException;
import com.rentacar.RentACar.exception.UsernameAlreadyExistsException;
import com.rentacar.RentACar.exception.UsernameNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exceptions,
                                                               HttpHeaders headers,
                                                               HttpStatus status,
                                                               WebRequest request) {
        HashMap<String, String> errors = new HashMap<>();
        exceptions.getBindingResult().getAllErrors().forEach((error) -> {
            String rentACarFieldError = ((FieldError) error).getField();
            String rentACarMessage = error.getDefaultMessage();
            errors.put(rentACarFieldError, rentACarMessage);

        });
        return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UsernameAlreadyExistsException.class)
    public ResponseEntity<String> handleUsernameAlreadyExistsException(UsernameAlreadyExistsException usernameAlreadyExistsException) {
        return new ResponseEntity<String>(usernameAlreadyExistsException.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<String> handleUsernameNotFoundException(UsernameNotFoundException usernameNotFoundException) {
        return new ResponseEntity<String>(usernameNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CarNotFoundException.class)
    public ResponseEntity<String> handleCarNotFoundException(CarNotFoundException carNotFoundException){
        return new ResponseEntity<>(carNotFoundException.getMessage(),HttpStatus.NOT_FOUND);
    }

}

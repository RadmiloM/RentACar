package com.rentacar.RentACar.dto;

import com.rentacar.RentACar.validation.ValidPassword;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class UserUpdateRequest {
    @NotEmpty(message = "username may not be empty or null")
    @Size(min = 3, message = "username must be at least 3 characters long")
    private String username;
    @NotEmpty(message = "password may not be empty or null")
    @ValidPassword
    private String password;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String image;
}

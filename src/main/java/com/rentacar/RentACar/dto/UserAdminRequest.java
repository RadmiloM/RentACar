package com.rentacar.RentACar.dto;

import com.rentacar.RentACar.validation.ValidPassword;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class UserAdminRequest {

    @NotEmpty(message = "username may not be empty or null")
    @Size(min = 3, message = "username must be at least 3 characters long")
    private String username;
    @NotEmpty(message = "password may not be empty or null")
    @NotEmpty(message = "email should not be empty or null")
    @Email
    private String email;
    @NotEmpty(message = "first name should not be empty or null")
    @Size(min = 4,message = "first name size must be at least 4 letters")
    private String firstName;
    @NotEmpty(message = "last name should not be empty or null")
    @Size(min = 4,message = "last name size must be at least 4 letters")
    private String lastName;
    private String phoneNumber;
    private String personalNumber;
    private String image;
}

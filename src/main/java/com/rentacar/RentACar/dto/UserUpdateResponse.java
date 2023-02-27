package com.rentacar.RentACar.dto;

import lombok.Data;

@Data
public class UserUpdateResponse {

    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String personalNumber;
    private String image;
}

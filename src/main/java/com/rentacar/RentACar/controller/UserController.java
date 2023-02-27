package com.rentacar.RentACar.controller;

import com.rentacar.RentACar.dto.UserRequest;
import com.rentacar.RentACar.dto.UserResponse;
import com.rentacar.RentACar.mapper.UserMapper;
import com.rentacar.RentACar.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping("/users/register")
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest){
        var user = userMapper.mapToEntity(userRequest);
        userService.createUser(user);
        var message = userRequest.getUsername() + " - " + userRequest.getEmail() + " je uspesno registrovan";
        var userResponse = new UserResponse();
        userResponse.setSuccessful(true);
        userResponse.setMessage(message);
        return ResponseEntity.ok(userResponse);
    }
}

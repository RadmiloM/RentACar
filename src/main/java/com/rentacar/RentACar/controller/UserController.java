package com.rentacar.RentACar.controller;

import com.rentacar.RentACar.dto.UserRequest;
import com.rentacar.RentACar.dto.UserResponse;
import com.rentacar.RentACar.dto.UserUpdateRequest;
import com.rentacar.RentACar.dto.UserUpdateResponse;
import com.rentacar.RentACar.mapper.UserMapper;
import com.rentacar.RentACar.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping("/users/register")
    public ResponseEntity<UserResponse> registerUser(@Valid @RequestBody UserRequest userRequest) {
        var user = userMapper.mapToEntity(userRequest);
        userService.registerUser(user);
        var message = userRequest.getUsername() + " - " + userRequest.getEmail() + " je uspesno registrovan";
        var userResponse = new UserResponse();
        userResponse.setSuccessful(true);
        userResponse.setMessage(message);
        return ResponseEntity.ok(userResponse);
    }

    @PostMapping("/users/login/{id}")
    public ResponseEntity<UserResponse> loginUser(@Valid @RequestBody UserRequest userRequest, @PathVariable("id") UUID uuid) {
        var userDB = userService.getUserById(uuid);
        var userResponse = new UserResponse();
        if (userDB.getUsername().equals(userRequest.getUsername()) &&
                userDB.getPassword().equals(userRequest.getPassword())
                && userDB.getEmail().equals(userRequest.getEmail())) {
            String message = String.valueOf(uuid);
            userResponse.setMessage(message);
            userResponse.setSuccessful(true);
        } else {
            userResponse.setSuccessful(false);
            userResponse.setMessage("Pogresan username/email ili password");
        }
        return ResponseEntity.ok(userResponse);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<Void> updateUser(@Valid @RequestBody UserUpdateRequest userUpdateRequest, @PathVariable("id") UUID uuid){
        var user = userMapper.mapToEntity(userUpdateRequest);
         userService.updateUser(user,uuid);
         return ResponseEntity.ok().build();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserUpdateResponse> getUserById(@PathVariable("id") UUID uuid){
        var user = userService.getUserById(uuid);
        var userUpdate = userMapper.mapToDTO(user);
        return ResponseEntity.ok(userUpdate);
    }


}

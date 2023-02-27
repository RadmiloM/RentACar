package com.rentacar.RentACar.mapper;

import com.rentacar.RentACar.dto.UserRequest;
import com.rentacar.RentACar.dto.UserUpdateRequest;
import com.rentacar.RentACar.dto.UserUpdateResponse;
import com.rentacar.RentACar.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {


    public User mapToEntity(UserRequest userRequest) {
        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        return user;

    }

    public User mapToEntity(UserUpdateRequest userUpdateRequest){
        User user = new User();
        user.setUsername(userUpdateRequest.getUsername());
        user.setPassword(userUpdateRequest.getPassword());
        user.setFirstName(userUpdateRequest.getFirstName());
        user.setLastName(userUpdateRequest.getLastName());
        user.setPhoneNumber(userUpdateRequest.getPhoneNumber());
        user.setImage(userUpdateRequest.getImage());
        return user;

    }

    public UserUpdateResponse mapToDTO(User user){
        UserUpdateResponse userUpdateResponse = new UserUpdateResponse();
        userUpdateResponse.setUsername(user.getUsername());
        userUpdateResponse.setFirstName(user.getFirstName());
        userUpdateResponse.setEmail(user.getEmail());
        userUpdateResponse.setFirstName(user.getFirstName());
        userUpdateResponse.setLastName(user.getLastName());
        userUpdateResponse.setPhoneNumber(user.getPhoneNumber());
        userUpdateResponse.setPersonalNumber(user.getPersonalNumber());
        userUpdateResponse.setImage(user.getImage());
        return userUpdateResponse;
    }

    public List<UserUpdateResponse> mapToDTO(List<User> users){
        return users.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

}

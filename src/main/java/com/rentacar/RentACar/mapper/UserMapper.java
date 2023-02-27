package com.rentacar.RentACar.mapper;

import com.rentacar.RentACar.dto.UserRequest;
import com.rentacar.RentACar.dto.UserUpdateRequest;
import com.rentacar.RentACar.entity.User;
import org.springframework.stereotype.Component;

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

}

package com.rentacar.RentACar.mapper;

import com.rentacar.RentACar.dto.UserAdminRequest;
import com.rentacar.RentACar.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserAdminMapper {

    public User mapToEntity(UserAdminRequest userAdminRequest){
        User user = new User();
        user.setUsername(userAdminRequest.getUsername());
        user.setEmail(userAdminRequest.getEmail());
        user.setFirstName(userAdminRequest.getFirstName());
        user.setLastName(userAdminRequest.getLastName());
        user.setPhoneNumber(userAdminRequest.getPhoneNumber());
        user.setPersonalNumber(userAdminRequest.getPersonalNumber());
        user.setImage(userAdminRequest.getImage());
        return user;

    }
}

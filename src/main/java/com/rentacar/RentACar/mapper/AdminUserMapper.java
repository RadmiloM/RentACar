package com.rentacar.RentACar.mapper;

import com.rentacar.RentACar.dto.AdminUpdateUserRequest;
import com.rentacar.RentACar.entity.User;
import org.springframework.stereotype.Component;

@Component
public class AdminUserMapper {

    public User mapToEntity(AdminUpdateUserRequest userAdminRequest){
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

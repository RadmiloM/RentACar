package com.rentacar.RentACar.service;

import com.rentacar.RentACar.entity.User;
import com.rentacar.RentACar.exception.UsernameNotFoundException;
import com.rentacar.RentACar.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final UserRepository userRepository;


    public void updateUser(User user, UUID uuid) {
        var userDB = userRepository.findById(uuid);
        if (userDB.isEmpty()) {
            throw new UsernameNotFoundException("user with id " + uuid + " is not found in database");
        }
        var optionalUser = userDB.get();

        if (Objects.nonNull(user.getUsername()) && !"".equals(user.getUsername())) {
            optionalUser.setUsername(user.getUsername());
        }
        if (Objects.nonNull(user.getEmail()) && !"".equals(user.getEmail())) {
            optionalUser.setEmail(user.getEmail());
        }
        if (Objects.nonNull(user.getFirstName()) && !"".equals(user.getFirstName())) {
            optionalUser.setFirstName(user.getFirstName());
        }
        if (Objects.nonNull(user.getLastName()) && !"".equals(user.getLastName())) {
            optionalUser.setLastName(user.getLastName());
        }
        if (Objects.nonNull(user.getPhoneNumber()) && !"".equals(user.getPhoneNumber())) {
            optionalUser.setPhoneNumber(user.getPhoneNumber());
        }
        if (Objects.nonNull(user.getPersonalNumber()) && !"".equals(user.getPersonalNumber())) {
            optionalUser.setPersonalNumber(user.getPersonalNumber());
        }
        if (Objects.nonNull(user.getImage()) && !"".equals(user.getImage())) {
            optionalUser.setImage(user.getImage());
        }
        userRepository.save(optionalUser);
    }
}

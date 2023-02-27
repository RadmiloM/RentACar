package com.rentacar.RentACar.service;

import com.rentacar.RentACar.entity.User;
import com.rentacar.RentACar.exception.UsernameAlreadyExistsException;
import com.rentacar.RentACar.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void createUser(User user){
        var userDB = userRepository.findByUsername(user.getUsername());
        if(userDB.isPresent()){
            throw new UsernameAlreadyExistsException("user with username " + user.getUsername() + " already exists");
        }
        userRepository.save(user);
    }
}

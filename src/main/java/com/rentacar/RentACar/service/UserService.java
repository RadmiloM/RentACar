package com.rentacar.RentACar.service;

import com.rentacar.RentACar.entity.User;
import com.rentacar.RentACar.exception.UsernameAlreadyExistsException;
import com.rentacar.RentACar.exception.UsernameNotFoundException;
import com.rentacar.RentACar.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void registerUser(User user){
        var userDB = userRepository.findByUsername(user.getUsername());
        if(userDB.isPresent()){
            throw new UsernameAlreadyExistsException("user with username " + user.getUsername() + " already exists");
        }
        userRepository.save(user);
    }

    public User getUserById(UUID uuid){
        var userDB = userRepository.findById(uuid);
        if(userDB.isEmpty()){
            throw new UsernameNotFoundException("User with id: " + uuid + " does not exists in database");
        }
        return userDB.get();
    }
}

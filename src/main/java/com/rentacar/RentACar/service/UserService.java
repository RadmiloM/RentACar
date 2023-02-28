package com.rentacar.RentACar.service;

import com.rentacar.RentACar.entity.User;
import com.rentacar.RentACar.exception.UsernameAlreadyExistsException;
import com.rentacar.RentACar.exception.UsernameNotFoundException;
import com.rentacar.RentACar.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void registerUser(User user) {
        var userDB = userRepository.findByUsername(user.getUsername());
        if (userDB.isPresent()) {
            throw new UsernameAlreadyExistsException("user with username " + user.getUsername() + " already exists");
        }
        userRepository.save(user);
    }

    public User getUserById(UUID uuid) {
        var userDB = userRepository.findById(uuid);
        if (userDB.isEmpty()) {
            throw new UsernameNotFoundException("User with id: " + uuid + " does not exists in database");
        }
        return userDB.get();
    }

    public void updateUser(User user, UUID uuid) {
        var userDB = userRepository.findById(uuid);
        if(userDB.isEmpty()){
            throw new UsernameNotFoundException("user with id " + uuid + " does not exists in database");
        }
        var optionalUser = userDB.get();
        if (Objects.nonNull(user.getUsername()) && !"".equals(user.getUsername())) {
            optionalUser.setUsername(user.getUsername());
        }
        if (Objects.nonNull(user.getPassword()) && !"".equals(user.getPassword())) {
            optionalUser.setPassword(user.getPassword());
        }
        if (Objects.nonNull(user.getFirstName()) && !"".equals(user.getFirstName())) {
            optionalUser.setUsername(user.getFirstName());
        }
        if (Objects.nonNull(user.getLastName()) && !"".equals(user.getLastName())) {
            optionalUser.setUsername(user.getLastName());
        }
        if (Objects.nonNull(user.getPhoneNumber()) && !"".equals(user.getPhoneNumber())) {
            optionalUser.setUsername(user.getPhoneNumber());
        }
        if (Objects.nonNull(user.getImage()) && !"".equals(user.getImage())) {
            optionalUser.setUsername(user.getImage());
        }
        userRepository.save(optionalUser);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}

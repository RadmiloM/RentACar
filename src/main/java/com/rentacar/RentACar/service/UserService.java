package com.rentacar.RentACar.service;

import com.rentacar.RentACar.entity.User;
import com.rentacar.RentACar.exception.UsernameAlreadyExistsException;
import com.rentacar.RentACar.exception.UsernameNotFoundException;
import com.rentacar.RentACar.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
        var userDB = userRepository.findById(uuid).get();
        if (Objects.nonNull(user.getUsername()) && !"".equals(user.getUsername())) {
            userDB.setUsername(user.getUsername());
        }
        if (Objects.nonNull(user.getPassword()) && !"".equals(user.getPassword())) {
            userDB.setPassword(user.getPassword());
        }
        if (Objects.nonNull(user.getFirstName()) && !"".equals(user.getFirstName())) {
            userDB.setUsername(user.getFirstName());
        }
        if (Objects.nonNull(user.getLastName()) && !"".equals(user.getLastName())) {
            userDB.setUsername(user.getLastName());
        }
        if (Objects.nonNull(user.getPhoneNumber()) && !"".equals(user.getPhoneNumber())) {
            userDB.setUsername(user.getPhoneNumber());
        }
        if (Objects.nonNull(user.getImage()) && !"".equals(user.getImage())) {
            userDB.setUsername(user.getImage());
        }
        userRepository.save(userDB);
    }
}

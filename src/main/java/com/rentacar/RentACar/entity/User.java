package com.rentacar.RentACar.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
public class User {


    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String personalNumber;
    private String image;
    private String role;
    @OneToMany(mappedBy = "user")
    private List<Contract> contracts;
}

package com.rentacar.RentACar.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String licencePlate;
    private String make;
    private String model;
    private Integer year;
    private Integer engineCapacity;
    private String color;
    private Double price;
    private Integer doors;
    private Character size;
    private Integer power;
    private boolean automatic;
    private String fuel;
    private String image;
    @OneToMany(mappedBy = "car")
    private List<Contract>contracts;

}

package com.rentacar.RentACar.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
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
    private int year;
    private int engineCapacity;
    private String color;
    private double price;
    private int doors;
    private char size;
    private int power;
    private boolean automatic;
    private String fuel;
    private String image;

}

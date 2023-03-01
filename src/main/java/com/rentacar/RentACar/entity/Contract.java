package com.rentacar.RentACar.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "contracts")
public class Contract {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private LocalDate startDate;
    private LocalDate endDate;
    private double totalPrice;
    private boolean signed;
    private boolean approved;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;
}

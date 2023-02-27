package com.rentacar.RentACar.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "contracts")
public class Contract {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private double totalPrice;
    private boolean signed;
    private boolean approved;
    @ManyToOne
    private User user;
    @ManyToOne
    private Car car;
}

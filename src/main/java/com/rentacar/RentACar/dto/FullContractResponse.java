package com.rentacar.RentACar.dto;

import com.rentacar.RentACar.entity.Car;
import com.rentacar.RentACar.entity.User;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class FullContractResponse {

    private UUID id;
    private UUID userId;
    private UUID carId;
    private LocalDate startDate;
    private LocalDate endDate;
    private double totalPrice;
    private boolean signed;
    private boolean approved;
}

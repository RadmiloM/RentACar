package com.rentacar.RentACar.service;

import com.rentacar.RentACar.entity.Car;
import com.rentacar.RentACar.entity.Contract;
import com.rentacar.RentACar.entity.User;
import com.rentacar.RentACar.repository.ContractRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContractService {

    private final ContractRepository contractRepository;

    public void createContract(User user, Contract contract, Car car) {
        contract.setUser(user);
        contract.setCar(car);
        contractRepository.save(contract);
    }

    public List<Contract> fetchAllContracts(){
        return contractRepository.findAll();
    }


}

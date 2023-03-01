package com.rentacar.RentACar.service;

import com.rentacar.RentACar.entity.Car;
import com.rentacar.RentACar.entity.Contract;
import com.rentacar.RentACar.entity.User;
import com.rentacar.RentACar.exception.ContractNotFoundException;
import com.rentacar.RentACar.repository.ContractRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ContractService {

    private final ContractRepository contractRepository;

    public void updateContract(User user, Contract contract, Car car) {
        contract.setUser(user);
        contract.setCar(car);
        contractRepository.save(contract);
    }

    public List<Contract> fetchAllContracts(){
        return contractRepository.findAll();
    }

    public List<Contract> findPendingContracts(){
        return contractRepository.findByApprovedFalse();
    }

    public Contract getContractById(UUID uuid){
        var contract = contractRepository.findById(uuid);
        if(contract.isEmpty()){
            throw new ContractNotFoundException("contract with id: " + uuid + " does not exists in database");
        }
        return contract.get();
    }

    public void updateContract(Contract contract){
        contractRepository.save(contract);
    }




}

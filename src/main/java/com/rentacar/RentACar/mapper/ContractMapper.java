package com.rentacar.RentACar.mapper;

import com.rentacar.RentACar.dto.ContractRequest;
import com.rentacar.RentACar.entity.Contract;
import org.springframework.stereotype.Component;

@Component
public class ContractMapper {


    public Contract mapToEntity(ContractRequest contractRequest) {
        Contract contract = new Contract();
        contract.setStartDate(contractRequest.getStartDate());
        contract.setEndDate(contractRequest.getEndDate());
        contract.setTotalPrice(contractRequest.getTotalPrice());
        contract.setSigned(contractRequest.isSigned());
        return contract;
    }
}

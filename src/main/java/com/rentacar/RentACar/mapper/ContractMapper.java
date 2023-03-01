package com.rentacar.RentACar.mapper;

import com.rentacar.RentACar.dto.ContractRequest;
import com.rentacar.RentACar.dto.ContractResponse;
import com.rentacar.RentACar.dto.FullContractResponse;
import com.rentacar.RentACar.entity.Contract;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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

    public FullContractResponse mapToDTO(Contract contract){
        FullContractResponse fullContractResponse = new FullContractResponse();
        fullContractResponse.setId(contract.getId());
        fullContractResponse.setUserId(contract.getUser().getId());
        fullContractResponse.setCarId(contract.getCar().getId());
        fullContractResponse.setStartDate(contract.getStartDate());
        fullContractResponse.setEndDate(contract.getEndDate());
        fullContractResponse.setTotalPrice(contract.getTotalPrice());
        fullContractResponse.setSigned(contract.isSigned());
        fullContractResponse.setApproved(contract.isApproved());
        return fullContractResponse;
    }

    public List<FullContractResponse> mapToDTO(List<Contract> contracts){
        return contracts.stream().map(this::mapToDTO).collect(Collectors.toList());
    }
}

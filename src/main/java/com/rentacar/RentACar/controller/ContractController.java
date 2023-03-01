package com.rentacar.RentACar.controller;

import com.rentacar.RentACar.dto.*;
import com.rentacar.RentACar.mapper.ContractMapper;
import com.rentacar.RentACar.service.CarService;
import com.rentacar.RentACar.service.ContractService;
import com.rentacar.RentACar.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ContractController {

    private final ContractMapper contractMapper;
    private final ContractService contractService;

    private final CarService carService;

    private final UserService userService;


    @PostMapping("/contracts")
    public ResponseEntity<ContractShortResponse> createContract(@RequestBody ContractRequest contractRequest) {
        var contract = contractMapper.mapToEntity(contractRequest);
        var user = userService.getUserById(contractRequest.getUserId());
        var car = carService.getCarById(contractRequest.getCarId());
        contractService.updateContract(user, contract, car);
        ContractShortResponse contractShortResponse = new ContractShortResponse();
        contractShortResponse.setMessage("Ugovor kreiran, ceka odobrenje");
        contractShortResponse.setSuccessful(true);
        return ResponseEntity.ok(contractShortResponse);
    }

    @GetMapping("/contracts")
    public ResponseEntity<List<FullContractResponse>> fetchAllContracts(@RequestHeader("id") UUID uuid) {
        var contracts = contractService.fetchAllContracts();
        var fullContractResponse = contractMapper.mapToDTO(contracts);
        return ResponseEntity.ok(fullContractResponse);
    }

    @GetMapping("/contracts/pending")
    public ResponseEntity<List<FullContractResponse>> fetchPendingContracts(@RequestHeader("id") UUID uuid) {
        var contracts = contractService.findPendingContracts();
        var fullContractResponse = contractMapper.mapToDTO(contracts);
        return ResponseEntity.ok(fullContractResponse);
    }

    @PostMapping("/contracts/{contractId}/approval")
    public ResponseEntity<Void> approveContract(@RequestHeader("id") UUID uuid,
                                                @PathVariable("contractId") UUID contractId,
                                                @RequestBody ShortContractRequest shortContractRequest){
        var contract = contractService.getContractById(contractId);
        if(!shortContractRequest.isApproved()){
            contract.setApproved(true);
            contractService.updateContract(contract);
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/contracts/{userId}/history")
    public ResponseEntity<List<FullContractResponse>> fetchUserContractsHistory(@PathVariable("userId") UUID uuid){
        var user = userService.getUserById(uuid);
        var contracts = contractService.getAllContractsByUserId(user);
        var response = contractMapper.mapToDTO(contracts);
        return ResponseEntity.ok(response);

    }

    @PostMapping("/contracts/sample")
    public ResponseEntity<List<FullContractResponse>> createSample(@RequestBody ContractRequest contractRequest){
        var contract = contractService.findByDates(contractRequest.getStartDate(),contractRequest.getEndDate());
        var contractResponse = contractMapper.mapToDTO(contract);
        return ResponseEntity.ok(contractResponse);
    }
}

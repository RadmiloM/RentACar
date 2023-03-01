package com.rentacar.RentACar.controller;

import com.rentacar.RentACar.dto.ContractRequest;
import com.rentacar.RentACar.dto.ContractResponse;
import com.rentacar.RentACar.dto.ContractShortResponse;
import com.rentacar.RentACar.entity.User;
import com.rentacar.RentACar.mapper.ContractMapper;
import com.rentacar.RentACar.service.CarService;
import com.rentacar.RentACar.service.ContractService;
import com.rentacar.RentACar.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ContractController {

    private final ContractMapper contractMapper;
    private final ContractService contractService;

    private final CarService carService;

    private final UserService userService;


    @PostMapping("/contracts")
    public ResponseEntity<ContractShortResponse> createContract(@RequestBody ContractRequest contractRequest){
            var contract = contractMapper.mapToEntity(contractRequest);
            var user = userService.getUserById(contractRequest.getUserId());
            var car = carService.getCarById(contractRequest.getCarId());
            contractService.createContract(user,contract,car);
            ContractShortResponse contractShortResponse = new ContractShortResponse();
            contractShortResponse.setMessage("Ugovor kreiran, ceka odobrenje");
            contractShortResponse.setSuccessful(true);
            return ResponseEntity.ok(contractShortResponse);
    }

//    @PostMapping("/contracts/sample")
//    public ResponseEntity<ContractResponse> createSample(@RequestBody ContractRequest contractRequest){
//        var contract = contractMapper.mapToEntity(contractRequest);
//        contractService.createContract(contract);
//        var contractResponse = ContractResponse
//                .builder()
//                .userId(contractRequest.getUserId())
//                .carId(contractRequest.getCarId())
//                .startDate(contractRequest.getStartDate())
//                .endDate(contractRequest.getEndDate())
//                .totalPrice(550.99)
//                .signed(false)
//                .build();
//        return ResponseEntity.ok(contractResponse);
//    }
}

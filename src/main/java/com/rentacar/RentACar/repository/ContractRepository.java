package com.rentacar.RentACar.repository;

import com.rentacar.RentACar.entity.Contract;
import com.rentacar.RentACar.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface ContractRepository extends JpaRepository<Contract, UUID> {

    List<Contract> findByApprovedFalse();

    List<Contract> findAllByUser(User user);

    List<Contract> findByStartDateBetween(LocalDate startDate, LocalDate endDate);

}

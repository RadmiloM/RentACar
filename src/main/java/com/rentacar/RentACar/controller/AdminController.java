package com.rentacar.RentACar.controller;

import com.rentacar.RentACar.dto.AdminUpdateUserRequest;
import com.rentacar.RentACar.dto.AdminUpdateUserResponse;
import com.rentacar.RentACar.mapper.AdminUserMapper;
import com.rentacar.RentACar.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    private final AdminUserMapper userAdminMapper;

    @PutMapping("/admin/update/{id}")
    public ResponseEntity<AdminUpdateUserResponse> updateUser(@RequestBody AdminUpdateUserRequest adminUpdateUserRequest, @PathVariable("id") UUID uuid) {
        var user = userAdminMapper.mapToEntity(adminUpdateUserRequest);
        adminService.updateUser(user,uuid);
        var message = "Fields successfully changed";
        var userAdminResponse = new AdminUpdateUserResponse();
        userAdminResponse.setSuccessful(true);
        userAdminResponse.setMessage(message);
        return ResponseEntity.ok(userAdminResponse);
    }

}

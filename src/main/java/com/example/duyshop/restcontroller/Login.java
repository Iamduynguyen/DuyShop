package com.example.duyshop.restcontroller;

import com.example.duyshop.dto.StaffDto;
import com.example.duyshop.entity.StaffEntity;
import com.example.duyshop.service.IService.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Login {
    @Autowired
    IStaffService staffService;

    @GetMapping("/api/staffsession")
    public ResponseEntity<?> getstaff(){
        StaffDto staffDto = staffService.findByIdD(1);
        return ResponseEntity.ok(staffDto);
    }
}

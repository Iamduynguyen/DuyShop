package com.example.duyshop.restapi;

import com.example.duyshop.dto.StaffDto;
import com.example.duyshop.service.CategoryService;
import com.example.duyshop.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Login {
    @Autowired
    StaffService staffService;
    @Autowired
    CategoryService categoryService;

    @GetMapping("/api/staffsession")
    public ResponseEntity<?> getstaff(){
        StaffDto staffDto = staffService.findByIdD(1);
        return ResponseEntity.ok(staffDto);
    }

    @GetMapping("/api/cate")
    public ResponseEntity<?> getcate(){
        return ResponseEntity.ok(categoryService.findByid(1));
    }
}

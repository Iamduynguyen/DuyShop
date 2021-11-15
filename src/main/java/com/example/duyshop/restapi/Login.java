package com.example.duyshop.restapi;

import com.example.duyshop.dto.StaffDto;
import com.example.duyshop.service.CategoryService;
import com.example.duyshop.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class Login {
    @Autowired
    StaffService staffService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    HttpServletRequest req;

    @GetMapping("/api/staffsession")
    public ResponseEntity<?> getstaff(){
        StaffDto staffDto = staffService.findByIdD(1);
        return ResponseEntity.ok(staffDto);
    }

    @PostMapping("/api/postchoi")
    public Boolean postchoi(@RequestBody StaffDto staffDto){
        System.out.println("alo"+staffDto.getEmail());
        return false;
    }

    @GetMapping("/api/cate")
    public ResponseEntity<?> getcate(){
        return ResponseEntity.ok(categoryService.findByid(1));
    }
}

package com.example.duyshop.restapi;

import com.example.duyshop.dto.StaffDto;
import com.example.duyshop.dto.UserDto;
import com.example.duyshop.service.CategoryService;
import com.example.duyshop.service.StaffService;
import com.example.duyshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class Login {
    @Autowired
    UserService userService;


    @PostMapping("/api/sign")
    public Boolean postchoi(@RequestBody UserDto userDto){

        return false;
    }
}

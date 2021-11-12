package com.example.duyshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Signin {

    @GetMapping("/sign")
    public String getSign(){
        return "/signin";
    }
}

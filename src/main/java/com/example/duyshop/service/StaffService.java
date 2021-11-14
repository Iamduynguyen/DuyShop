package com.example.duyshop.service;

import com.example.duyshop.dto.StaffDto;
import com.example.duyshop.entity.StaffEntity;
import org.springframework.stereotype.Service;

import java.text.ParseException;
@Service
public interface StaffService {
    StaffEntity getFromSession();
    StaffEntity findById(Integer id);
    StaffEntity findByEmail(String email);
    StaffDto findByIdD(Integer id);
}

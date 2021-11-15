package com.example.duyshop.service;

import com.example.duyshop.dto.CustomerDto;
import com.example.duyshop.entity.CustomerEntity;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {
    CustomerEntity findEntityById(Integer id);
    CustomerDto findDtoBybyid(Integer id);
}

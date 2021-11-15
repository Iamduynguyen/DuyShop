package com.example.duyshop.service;

import com.example.duyshop.dto.BrandDto;
import com.example.duyshop.entity.BrandEntity;
import org.springframework.stereotype.Service;

@Service
public interface BrandService {
    BrandEntity findbyid(Integer id);
    BrandDto findById(Integer id);
}

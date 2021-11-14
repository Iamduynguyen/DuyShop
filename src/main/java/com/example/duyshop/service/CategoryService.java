package com.example.duyshop.service;

import com.example.duyshop.dto.CategoryDto;
import com.example.duyshop.entity.CategoryEntity;
import org.springframework.stereotype.Service;

@Service
public interface CategoryService {
    CategoryEntity findbyid(Integer id);
    CategoryDto findByid(Integer id);
}

package com.example.duyshop.service.ServiceIpm;

import com.example.duyshop.dto.CategoryDto;
import com.example.duyshop.entity.CategoryEntity;
import com.example.duyshop.reponsitory.CategoryReponsitory;
import com.example.duyshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceIpm extends AstractService implements CategoryService {
    @Autowired
    CategoryReponsitory categoryReponsitory;
    @Override
    public CategoryEntity findbyid(Integer id) {
        return categoryReponsitory.findById(id).get();
    }

    @Override
    public CategoryDto findByid(Integer id) {
        return (CategoryDto) map(categoryReponsitory.findById(1).get());
    }
}

package com.example.duyshop.service;

import com.example.duyshop.dto.ProductDto;
import com.example.duyshop.entity.ProductEntity;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {
    ProductEntity findEntityById(Integer id);
    ProductDto findDtoById(Integer id);
}

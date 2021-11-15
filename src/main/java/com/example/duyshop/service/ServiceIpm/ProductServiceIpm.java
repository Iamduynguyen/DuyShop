package com.example.duyshop.service.ServiceIpm;

import com.example.duyshop.dto.ProductDto;
import com.example.duyshop.entity.ProductEntity;
import com.example.duyshop.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceIpm extends AstractService implements ProductService {
    @Override
    public ProductEntity findEntityById(Integer id) {
        return null;
    }

    @Override
    public ProductDto findDtoById(Integer id) {
        return null;
    }
}

package com.example.duyshop.service;

import com.example.duyshop.dto.ProductDto;
import com.example.duyshop.entity.ProductEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<ProductDto> findAll();
    ProductEntity findEntityById(Integer id);
    ProductDto findDtoById(Integer id);
    List<ProductDto> findByCateAndPage(Integer cateId, Pageable pageable);
    Boolean saveProduct(ProductDto productDto);
    Boolean deleteProduct(Integer id);
    ProductDto findByName(String name);
    List<ProductDto> findBybrandId(Integer brandId, Pageable pageable);
    List<ProductDto> findByKey(String key);
}

package com.example.duyshop.service.ServiceIpm;

import com.example.duyshop.dto.BrandDto;
import com.example.duyshop.entity.BrandEntity;
import com.example.duyshop.service.BrandService;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceIpm extends AstractService implements BrandService {
    @Override
    public BrandEntity findbyid(Integer id) {
        return null;
    }

    @Override
    public BrandDto findById(Integer id) {
        return null;
    }
}

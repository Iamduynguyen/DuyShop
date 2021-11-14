package com.example.duyshop.service.ServiceIpm;

import com.example.duyshop.dto.*;
import com.example.duyshop.entity.CategoryEntity;
import com.example.duyshop.entity.ProductEntity;
import com.example.duyshop.entity.StaffEntity;
import com.example.duyshop.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.stream.Collectors;

@Component
public abstract class AstractService {
    @Autowired
    RoleService roleService;

    protected Object map(Object data) {
        // staff
        if (data instanceof StaffEntity){
            StaffEntity staffEntity = (StaffEntity) data;
            return StaffDto.builder()
                    .email(staffEntity.getEmail())
                    .password(staffEntity.getPassword())
                    .id(staffEntity.getId())
                    .active(staffEntity.isActive())
                    .image(staffEntity.getImage())
                    .birthDate(new SimpleDateFormat("dd-MM-yyyy").format(staffEntity.getBirthDate()))
                    .roleId(staffEntity.getRole().getId())
                    .roleName(staffEntity.getRole().getName()).build();
        }else if (data instanceof StaffDto){
            try {
                StaffDto staffDto = (StaffDto) data;
                return StaffEntity.builder()
                        .email(staffDto.getEmail())
                        .password(staffDto.getPassword())
                        .image(staffDto.getImage())
                        .active(staffDto.isActive())
                        .id(staffDto.getId())
                        .birthDate( new SimpleDateFormat("yyyy-MM-dd").parse(staffDto.getBirthDate()))
                        .role(roleService.findRoleEntitybyId(staffDto.getRoleId())).build();
            }catch (Exception e){
                e.printStackTrace();
                return null;
            }
        }
        //category
        if (data instanceof CategoryEntity){
            CategoryEntity categoryEntity = (CategoryEntity) data;
            return CategoryDto.builder()
                    .id(categoryEntity.getId())
                    .name(categoryEntity.getName()).build();
        }else if (data instanceof CategoryDto){
            CategoryDto categoryDto = (CategoryDto) data;
            return CategoryEntity.builder()
                    .id(categoryDto.getId())
                    .name(categoryDto.getName()).build();
        }

        //product
        if (data instanceof ProductEntity){
            ProductEntity productEntity = (ProductEntity) data;
            return ProductDto.builder()
                    .id(productEntity.getId())
                    .name(productEntity.getName())
                    .price(productEntity.getPrice())
                    .quantity(productEntity.getQuantity())
                    .discount(productEntity.getDiscount())
                    .images(productEntity.getImages()!= null ?
                            productEntity.getImages().stream()
                            .map(i ->(ImageDto) map(i)).collect(Collectors.toList()) : null)
                    .brandDto((BrandDto) map(productEntity.getBrand()))
                    .categoryDto((CategoryDto) map(productEntity.getCategory()))
                    .build();
        }
        return null;
    }
}

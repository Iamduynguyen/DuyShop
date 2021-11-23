package com.example.duyshop.service.ServiceIpm;

import com.example.duyshop.dto.*;
import com.example.duyshop.entity.*;
import com.example.duyshop.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.stream.Collectors;

@Component
public abstract class AstractService {
    @Autowired
    RoleService roleService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    StaffService staffService;
    @Autowired
    CustomerService customerService;
    @Autowired
    TransactionService transactionService;
    @Autowired
    ProductService productService;

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
        // customers
        if (data instanceof CustomerEntity){
            CustomerEntity entity = (CustomerEntity) data;
            return CustomerDto.builder()
                    .id(entity.getId())
                    .name(entity.getName())
                    .active(entity.getActive())
                    .address(entity.getAddress())
                    .rank(entity.getRank())
                    .email(entity.getEmail())
                    .phoneNumber(entity.getPhoneNumber())
                    .password(entity.getPassword())
                    .image(entity.getImage())
                    .role((RoleDto) map(entity.getRole()))
                    .build();
        }else if (data instanceof CustomerDto){
            CustomerDto dto = (CustomerDto) data;
            return CustomerEntity.builder()
                    .id(dto.getId())
                    .name(dto.getName())
                    .active(dto.getActive())
                    .address(dto.getAddress())
                    .phoneNumber(dto.getPhoneNumber())
                    .email(dto.getEmail())
                    .image(dto.getImage())
                    .password(dto.getPassword())
                    .rank(dto.getRank())
                    .role((RoleEntity) map(dto.getRole()))
                    .build();
        }
        // transaction
        if (data instanceof TransactionEntity){
            TransactionEntity entity = (TransactionEntity) data;
            return TransactionDto.builder()
                    .id(entity.getId())
                    .status(entity.getStatus())
                    .voucherId(entity.getVoucherId()!= null? entity.getVoucherId():null)
                    .CustomerId(entity.getCustomer().getId())
                    .customerName(entity.getCustomer().getName())
                    .customerAddress(entity.getCustomer().getAddress())
                    .customerPhone(entity.getCustomer().getPhoneNumber())
                    .created(new SimpleDateFormat("dd-MM-yyyy").format(entity.getCreated()))
                    .staffid(entity.getStaff().getId())
                    .staffName(entity.getStaff().getName())
                    .orderDetailDtos(entity.getOrderDetails()!= null ? entity.getOrderDetails().stream()
                            .map(o->(OrderDetailDto) map(o)).collect(Collectors.toList()) : null)
                    .build();
        }else if (data instanceof TransactionEntity){
            TransactionDto dto = (TransactionDto) data;
            try {
                return TransactionEntity.builder()
                        .id(dto.getId())
                        .created(new SimpleDateFormat("yyyy-MM-dd").parse(dto.getCreated()))
                        .status(dto.getStatus())
                        .staff(staffService.findById(dto.getId()))
                        .customer(customerService.findEntityById(dto.getId()))
                        .voucherId(dto.getVoucherId())
                        .build();
            }catch (Exception e){
                e.printStackTrace();
                return null;
            }
        }

        //orderdetail
        if (data instanceof OrderDetailEntity){
            OrderDetailEntity entity = (OrderDetailEntity) data;
            return OrderDetailDto.builder()
                    .id(entity.getId())
                    .product((ProductDto) map(entity.getProduct()))
                    .quantity(entity.getQuantity())
                    .transactionId(entity.getTransaction().getId())
                    .build();
        }else if (data instanceof OrderDetailDto){
            OrderDetailDto dto = (OrderDetailDto) data;
            return OrderDetailEntity.builder()
                    .id(dto.getId())
                    .quantity(dto.getQuantity())
                    .product((ProductEntity) map(dto.getProduct()))
                    .transaction(transactionService.findEntityById(dto.getTransactionId()))
                    .build();
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
                    .title(productEntity.getTitle())
                    .images(productEntity.getImages()!= null ?
                            productEntity.getImages().stream()
                            .map(i ->(ImageDto) map(i)).collect(Collectors.toList()) : null)
                    .brandDto((BrandDto) map(productEntity.getBrand()))
                    .categoryDto((CategoryDto) map(productEntity.getCategory()))
                    .build();
        }else  if (data instanceof ProductDto){
            ProductDto dto = (ProductDto) data;
            return ProductEntity.builder()
                    .id(dto.getId())
                    .name(dto.getName())
                    .discount(dto.getDiscount())
                    .title(dto.getTitle())
                    .images(dto.getImages()!= null ? dto.getImages().stream()
                            .map(imageDto -> (ImageEntity) map(imageDto)).collect(Collectors.toList()) : null)
                    .price(dto.getPrice())
                    .quantity(dto.getQuantity())
                    .category((CategoryEntity) map(dto.getCategoryDto()))
                    .brand((BrandEntity) map(dto.getBrandDto()))
                    .build();
        }
        // brands

        if (data instanceof BrandEntity){
            BrandEntity entity = (BrandEntity) data;
            return BrandDto.builder()
                    .id(entity.getId())
                    .name(entity.getName()).build();
        }else if (data instanceof BrandEntity){
            BrandDto dto = (BrandDto) data;
            return BrandEntity.builder()
                    .id(dto.getId())
                    .name(dto.getName())
                    .build();
        }
        // images
        if (data instanceof ImageEntity){
            ImageEntity entity = (ImageEntity) data;
            return ImageDto.builder()
                    .id(entity.getId())
                    .urlImage(entity.getImageUrl())
                    .build();
        }else if (data instanceof ImageDto){
            ImageDto dto = (ImageDto) data;
            return ImageEntity.builder()
                    .id(dto.getId())
                    .imageUrl(dto.getUrlImage())
                    .build();
        }
        //Role
        if (data instanceof RoleEntity){
            RoleEntity entity = (RoleEntity) data;
            return RoleDto.builder()
                    .id(entity.getId())
                    .name(entity.getName())
                    .build();
        }else if (data instanceof RoleDto){
            RoleDto dto = (RoleDto) data;
            return RoleEntity.builder()
                    .id(dto.getId())
                    .name(dto.getName())
                    .build();
        }
        //comment
        if (data instanceof CommentEntity){
            CommentEntity entity = (CommentEntity) data;
            return CommentDto.builder()
                    .id(entity.getId())
                    .comment(entity.getContent())
                    .productId(entity.getProduct().getId())
                    .create(new SimpleDateFormat("dd-MM-yyyy").format(entity.getCreated()))
                    .build();
        }else if (data instanceof CommentDto){
            CommentDto dto = (CommentDto) data;
            try {
                return CommentEntity.builder()
                        .id(dto.getId())
                        .content(dto.getComment())
                        .product(productService.findEntityById(dto.getProductId()))
                        .created( new SimpleDateFormat("yyyy-MM-dd").parse(dto.getCreate()))
                        .build();
            }catch (Exception e){
                e.printStackTrace();
                return null;
            }
        }

        return null;
    }
}

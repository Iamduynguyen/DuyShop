package com.example.duyshop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class CustomerDto {
    private Integer id;
    private String name;
    private Boolean active;
    private String email;
    private String password;
    private String address;
    private String phoneNumber;
    private Integer rank;
    private String image;
    private RoleDto role;
}

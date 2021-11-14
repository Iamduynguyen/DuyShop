package com.example.duyshop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Component
public class StaffDto {
    private Integer id;
    private String email;
    private String password;
    private String birthDate;
    private String image;
    private boolean active;
    private Integer roleId;
    private String roleName;
}

package com.example.duyshop.service;

import com.example.duyshop.dto.StaffDto;
import com.example.duyshop.entity.StaffEntity;
import com.example.duyshop.service.IService.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Component
public abstract class AstractService {
    @Autowired
    IRoleService roleService;

    protected Object map(Object data) {
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

        return null;
    }
}

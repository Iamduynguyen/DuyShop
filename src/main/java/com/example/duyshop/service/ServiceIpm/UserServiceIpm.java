package com.example.duyshop.service.ServiceIpm;
import com.example.duyshop.dto.CustomerDto;
import com.example.duyshop.dto.StaffDto;
import com.example.duyshop.dto.UserDto;
import com.example.duyshop.entity.CustomerEntity;
import com.example.duyshop.entity.StaffEntity;
import com.example.duyshop.reponsitory.CustomerReponsitory;
import com.example.duyshop.reponsitory.StaffRepository;
import com.example.duyshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class UserServiceIpm implements UserService {
    @Autowired
    CustomerReponsitory customerReponsitory;
    @Autowired
    StaffRepository staffRepository;

    @Override
    public UserDto castUser(Object object) {
        if (object instanceof StaffDto){
            StaffDto staffDto = (StaffDto) object;
            return UserDto.builder()
                    .email(staffDto.getEmail())
                    .password(staffDto.getPassword())
                    .role(staffDto.getRoleName()).build();
        }else if (object instanceof CustomerDto){
            CustomerDto customerDto = (CustomerDto) object;
            return UserDto.builder()
                    .email(customerDto.getEmail())
                    .password(customerDto.getPassword())
                    .role(customerDto.getRole().getName()).build();
        }
        if (object instanceof StaffEntity){
            StaffEntity staffEntity = (StaffEntity) object;
            return UserDto.builder()
                    .email(staffEntity.getEmail())
                    .password(staffEntity.getPassword())
                    .role(staffEntity.getRole().getName()).build();
        }
        if (object instanceof CustomerEntity){
            CustomerEntity customerEntity = (CustomerEntity) object;
            return UserDto.builder()
                    .email(customerEntity.getEmail())
                    .password(customerEntity.getPassword())
                    .role(customerEntity.getRole().getName()).build();
        }
        return null;
    }

    @Override
    public UserDto findUserbyEmail(String email) {
        listUser().forEach(userDto -> {
            if (userDto.getEmail().equals(email)) {
                return;
            }
        });
        return null;
    }

    @Override
    public List<UserDto> listUser() {
        List<UserDto> userDtoList = new ArrayList<>();
        customerReponsitory.findAll().forEach(customerEntity -> userDtoList.add(castUser(customerEntity)));
        staffRepository.findAll().forEach(staffEntity -> userDtoList.add(castUser(staffEntity)));
        return userDtoList;
    }
}

package com.example.duyshop.service;

import com.example.duyshop.entity.StaffEntity;
import com.example.duyshop.reponsitory.StaffRepository;
import com.example.duyshop.service.IService.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;

public class StaffService  implements IStaffService {
    @Autowired
    StaffEntity staffEntity;
    @Autowired
    StaffRepository staffRepository;

    @Override
    public StaffEntity getFromSession() {
        return staffEntity;
    }

    @Override
    public StaffEntity findById(Integer id) {
        staffEntity = staffRepository.findById(id).get();
        return staffEntity;
    }

    @Override
    public StaffEntity findByEmail(String email) {
        staffEntity = staffRepository.findByEmail(email);
        return staffEntity;
    }
}

package com.example.duyshop.service;

import com.example.duyshop.dto.StaffDto;
import com.example.duyshop.entity.StaffEntity;
import com.example.duyshop.reponsitory.StaffRepository;
import com.example.duyshop.service.IService.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;

@Service
public class StaffService extends AstractService  implements IStaffService {
    @Autowired
    StaffEntity staffEntity;
    @Autowired
    StaffRepository staffRepository;

    public StaffService(StaffEntity staffEntity, StaffRepository staffRepository) {
        super();
        this.staffEntity = staffEntity;
        this.staffRepository = staffRepository;
    }

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

    @Override
    public StaffDto findByIdD(Integer id){
        staffEntity = staffRepository.findById(id).get();
        return (StaffDto) map(staffEntity);
    }
}

package com.example.duyshop.service.ServiceIpm;

import com.example.duyshop.dto.StaffDto;
import com.example.duyshop.entity.StaffEntity;
import com.example.duyshop.reponsitory.StaffRepository;
import com.example.duyshop.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffServiceIpl extends AstractService  implements StaffService {
    @Autowired
    StaffEntity staffEntity;
    @Autowired
    StaffRepository staffRepository;

    public StaffServiceIpl(StaffEntity staffEntity, StaffRepository staffRepository) {
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

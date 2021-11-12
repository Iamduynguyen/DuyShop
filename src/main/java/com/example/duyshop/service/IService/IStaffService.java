package com.example.duyshop.service.IService;

import com.example.duyshop.entity.StaffEntity;

public interface IStaffService {
    StaffEntity getFromSession();
    StaffEntity findById(Integer id);
    StaffEntity findByEmail(String email);
}

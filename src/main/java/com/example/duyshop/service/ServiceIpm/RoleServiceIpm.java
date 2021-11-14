package com.example.duyshop.service.ServiceIpm;

import com.example.duyshop.entity.RoleEntity;
import com.example.duyshop.reponsitory.RoleReponsitory;
import com.example.duyshop.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceIpm extends AstractService implements RoleService {
    @Autowired
    private RoleReponsitory roleReponsitory;

    @Override
    public RoleEntity findRoleEntitybyId(Integer id) {
        return roleReponsitory.findById(id).get();
    }
}

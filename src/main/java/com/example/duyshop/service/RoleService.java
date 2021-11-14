package com.example.duyshop.service;

import com.example.duyshop.entity.RoleEntity;
import com.example.duyshop.reponsitory.RoleReponsitory;
import com.example.duyshop.service.IService.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends AstractService implements IRoleService {
    @Autowired
    private RoleReponsitory roleReponsitory;

    @Override
    public RoleEntity findRoleEntitybyId(Integer id) {
        return roleReponsitory.findById(id).get();
    }
}

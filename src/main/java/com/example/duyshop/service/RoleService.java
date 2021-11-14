package com.example.duyshop.service;

import com.example.duyshop.entity.RoleEntity;
import org.springframework.stereotype.Service;

@Service
public interface RoleService {

    RoleEntity findRoleEntitybyId(Integer id);
}

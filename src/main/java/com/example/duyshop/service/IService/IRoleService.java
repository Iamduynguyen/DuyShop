package com.example.duyshop.service.IService;

import com.example.duyshop.entity.RoleEntity;
import org.springframework.stereotype.Service;

@Service
public interface IRoleService {

    RoleEntity findRoleEntitybyId(Integer id);
}

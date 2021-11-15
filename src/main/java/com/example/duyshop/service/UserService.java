package com.example.duyshop.service;

import com.example.duyshop.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    UserDto castUser(Object object);
    UserDto findUserbyEmail(String email);
    List<UserDto> listUser();
}

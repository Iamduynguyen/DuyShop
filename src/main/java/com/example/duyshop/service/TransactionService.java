package com.example.duyshop.service;

import com.example.duyshop.dto.TransactionDto;
import com.example.duyshop.entity.TransactionEntity;
import org.springframework.stereotype.Service;

@Service
public interface TransactionService {
    TransactionEntity findEntityById(Integer id);
    TransactionDto findDtoById(Integer id);
}

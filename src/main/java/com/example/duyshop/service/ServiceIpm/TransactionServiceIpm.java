package com.example.duyshop.service.ServiceIpm;

import com.example.duyshop.dto.TransactionDto;
import com.example.duyshop.entity.TransactionEntity;
import com.example.duyshop.service.TransactionService;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceIpm extends AstractService implements TransactionService {
    @Override
    public TransactionEntity findEntityById(Integer id) {
        return null;
    }

    @Override
    public TransactionDto findDtoById(Integer id) {
        return null;
    }
}

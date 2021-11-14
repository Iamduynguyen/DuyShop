package com.example.duyshop.reponsitory;

import com.example.duyshop.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity,Integer> {
}

package com.example.duyshop.reponsitory;

import com.example.duyshop.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerReponsitory extends JpaRepository<CustomerEntity,Integer> {
}

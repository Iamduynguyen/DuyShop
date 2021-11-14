package com.example.duyshop.reponsitory;

import com.example.duyshop.entity.OrderDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface OrderDetailReponsitory extends JpaRepository<OrderDetailEntity,Integer> {
}

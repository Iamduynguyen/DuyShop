package com.example.duyshop.reponsitory;

import com.example.duyshop.entity.VoucherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoucherReponsitory extends JpaRepository<VoucherEntity,Integer> {
}

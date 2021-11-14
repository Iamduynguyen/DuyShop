package com.example.duyshop.reponsitory;

import com.example.duyshop.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandReponsitory extends JpaRepository<BrandEntity,Integer> {
}

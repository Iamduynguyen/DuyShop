package com.example.duyshop.reponsitory;

import com.example.duyshop.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Service
public interface ProductReponsitory extends JpaRepository<ProductEntity,Integer> {
}

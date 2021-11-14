package com.example.duyshop.reponsitory;

import com.example.duyshop.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryReponsitory extends JpaRepository<CategoryEntity,Integer> {
}

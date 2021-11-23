package com.example.duyshop.reponsitory;

import com.example.duyshop.entity.ProductEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
@Service
public interface ProductReponsitory extends JpaRepository<ProductEntity,Integer> {
    @Query("select p from ProductEntity p where p.category.id= :cateid")
    List<ProductEntity> getListByCateandPage(@Param("cateid")Integer cateid, Pageable pageable);
    @Query("select p from ProductEntity p where p.name like :name")
    ProductEntity findByName(@Param("name")String name);
    @Query("select p from ProductEntity p where p.brand.id = :brandid")
    List<ProductEntity> getByBrand(@Param("brandid") Integer brandid, Pageable pageable);
    @Query("select p from ProductEntity p where p.name like %:key% or p.title like %:key% or p.category.name like %:key%")
    List<ProductEntity> getByKey(@Param("key") String key);
}

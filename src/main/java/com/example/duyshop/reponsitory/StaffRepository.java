package com.example.duyshop.reponsitory;

import com.example.duyshop.entity.StaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.websocket.server.PathParam;

@Repository
public interface StaffRepository extends JpaRepository<StaffEntity,Integer> {

    @Query("select s from StaffEntity s where s.email = :email")
    StaffEntity findByEmail(@PathParam("email") String email);
}

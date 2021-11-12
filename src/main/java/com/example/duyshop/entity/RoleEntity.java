package com.example.duyshop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "role")
public class RoleEntity {
    @Id
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "role")
    private List<StaffEntity> staff;
    @OneToMany(mappedBy = "role")
    private List<CustomerEntity> customer;
}

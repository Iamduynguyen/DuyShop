package com.example.duyshop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    @OneToMany(mappedBy = "role")
    private List<StaffEntity> staff;
    @JsonIgnore
    @OneToMany(mappedBy = "role")
    private List<CustomerEntity> customer;
}

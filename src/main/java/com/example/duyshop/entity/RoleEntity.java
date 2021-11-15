package com.example.duyshop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder(toBuilder = true)
@Table(name = "role")
public class RoleEntity {
    @Id
    @Column(length = 1)
    private Integer id;
    @Column(length = 50,nullable = false)
    private String name;
    @JsonIgnore
    @OneToMany(mappedBy = "role")
    private List<StaffEntity> staff;
    @JsonIgnore
    @OneToMany(mappedBy = "role")
    private List<CustomerEntity> customer;
}

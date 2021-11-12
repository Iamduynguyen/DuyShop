package com.example.duyshop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "staff")
public class StaffEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String password;
    private Date birthDate;
    private String image;
    private boolean active;
    @ManyToOne
    @JoinColumn
    private RoleEntity role;
    @OneToMany(mappedBy = "staff")
    private List<TransactionEntity> transactions;
}

package com.example.duyshop.entity;

import lombok.AllArgsConstructor;
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
@Table(name = "customer")
public class CustomerEntity {
    @Id
    private Integer id;
    private String email;
    private String password;
    private String address;
    private String phoneNumber;
    private Integer rank;
    private String image;
    @ManyToOne
    @JoinColumn
    private RoleEntity role;
    @OneToMany(mappedBy = "customer")
    private List<TransactionEntity> transactionEntityList;
    @OneToMany(mappedBy = "customer")
    private List<VoucherEntity> voucherList;
}

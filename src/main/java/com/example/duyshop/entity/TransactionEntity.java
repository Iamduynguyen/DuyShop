package com.example.duyshop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "transaction")
@Component
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer status;
    private Integer voucherId;
    private Date created;
    @ManyToOne
    @JoinColumn
    private StaffEntity staff;
    @ManyToOne
    @JoinColumn
    private CustomerEntity customer;
    @OneToMany(mappedBy = "transaction")
    private List<OrderDetailEntity> orderDetails;
}

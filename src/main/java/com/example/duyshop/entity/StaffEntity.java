package com.example.duyshop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder(toBuilder = true)
public class StaffEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String password;
    private Date birthDate;
    private String image;
    private boolean active;
    @JsonIgnore
    @ManyToOne
    @JoinColumn
    private RoleEntity role;
    @JsonIgnore
    @OneToMany(mappedBy = "staff")
    private List<TransactionEntity> transactions;
}

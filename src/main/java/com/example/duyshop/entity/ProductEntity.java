package com.example.duyshop.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer price;
    private Integer discount;
    private Integer views;
    private Integer quantity;
    private String image;
    @OneToMany(mappedBy = "product")
    private List<OrderDetailEntity> orderDetails;
    @ManyToOne
    @JoinColumn
    private BrandEntity brand;
    @ManyToOne
    @JoinColumn
    private CategoryEntity category;
    @OneToMany(mappedBy = "product")
    private List<CommentEntity> comments;
}

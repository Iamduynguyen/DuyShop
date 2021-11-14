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
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder(toBuilder = true)
@Table(name = "product")
public class ProductEntity {

    @Id
    @Column(length = 10,nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 50,nullable = false)
    private String name;
    @Column(length = 10,nullable = false)
    private Integer price;
    @Column(length = 7,nullable = true)
    private Integer discount;
    @Column(length = 10,nullable = true,columnDefinition = "default '0'")
    private Integer views;
    @Column(length = 10,nullable = false)
    private Integer quantity;
    @Column(length = 50,nullable = false)
    @OneToMany(mappedBy = "product")
    private List<OrderDetailEntity> orderDetails;
    @JsonIgnore
    @ManyToOne
    @JoinColumn
    private BrandEntity brand;
    @JsonIgnore
    @ManyToOne
    @JoinColumn
    private CategoryEntity category;
    @JsonIgnore
    @OneToMany(mappedBy = "product",fetch = FetchType.LAZY)
    private List<CommentEntity> comments;
    @JsonIgnore
    @OneToMany(mappedBy = "product",fetch = FetchType.EAGER)
    private List<ImageEntity> images;
}

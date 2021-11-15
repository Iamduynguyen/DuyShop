package com.example.duyshop.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Component
@Entity
@NoArgsConstructor @AllArgsConstructor
@Data
@Table(name = "comment")
@Builder(toBuilder = true)
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String content;
    private Date created;
    private Integer customerId;
    @ManyToOne
    @JoinColumn
    private ProductEntity product;
}

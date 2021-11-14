package com.example.duyshop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailDto implements Serializable {
    private Integer id;
    private Integer quantity;
    private Integer transactionId;
    private Integer customerId;
    private Integer amount;
}

package com.example.duyshop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder(toBuilder = true)
@Component
public class TransactionDto {
    private Integer id;
    private Integer status;
    private Integer voucherId;
    private String created;
    private Integer staffid;
    private String staffName;
    private Integer CustomerId;
    private String customerName;
    private String customerAddress;
    private String customerPhone;
    private List<OrderDetailDto> orderDetailDtos;
    public Integer getAmounttotal(){
        AtomicReference<Integer> amount= new AtomicReference<>(0);
        orderDetailDtos.forEach(o-> amount.updateAndGet(v -> v + o.getAmount()));
        return amount.get();
    }
}

package com.example.duyshop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder(toBuilder = true)
@Component
public class TransactionDto {
    private Integer id;
    private Integer status;
    private Integer voucherId;
    private Date created;
    private Integer Staffid;
    private String StaffName;
    private Integer CustomerId;
    private String customerName;
    private Integer amountTotal;
    private List<OrderDetailDto> orderDetailDtos;
}

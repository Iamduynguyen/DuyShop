package com.example.duyshop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class BrandDto implements Serializable {
    private Integer id;
    private String name;
}

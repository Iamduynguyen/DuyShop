package com.example.duyshop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Component
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Integer id;
    @NotEmpty(message = "Vui lòng nhập tên")
    private String name;
    @NotEmpty(message = "Vui lòng nhập giá")
    private Integer price;
    private Integer discount;
    private Integer views;
    @NotEmpty(message = "Vui lòng nhập số lượng")
    private Integer quantity;
    private List<ImageDto> images;
    private BrandDto brandDto;
    private CategoryDto categoryDto;
    private String title;

    public Integer getRealprice(){
        return price-discount;
    }
}

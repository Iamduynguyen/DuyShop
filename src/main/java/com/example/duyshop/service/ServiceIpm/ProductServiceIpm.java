package com.example.duyshop.service.ServiceIpm;

import com.example.duyshop.dto.ProductDto;
import com.example.duyshop.entity.ProductEntity;
import com.example.duyshop.reponsitory.ProductReponsitory;
import com.example.duyshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceIpm extends AstractService implements ProductService {
    @Autowired
    ProductReponsitory productRepo;

    @Override
    public List<ProductDto> findAll() {
        return productRepo.findAll().stream().map(p->(ProductDto) map(p)).collect(Collectors.toList());
    }

    @Override
    public ProductEntity findEntityById(Integer id) {
        return productRepo.findById(id).get();
    }

    @Override
    public ProductDto findDtoById(Integer id) {
        return (ProductDto) map(findEntityById(id));
    }

    @Override
    public List<ProductDto> findByCateAndPage(Integer cateId, Pageable pageable) {
        return productRepo.getListByCateandPage(cateId,pageable).stream().map(p-> (ProductDto) map(p)).collect(Collectors.toList());
    }

    @Override
    public Boolean saveProduct(ProductDto productDto) {
        try { productRepo.save((ProductEntity) map(productDto)); return true;}
        catch (Exception e){e.printStackTrace();return false;}
    }

    @Override
    public Boolean deleteProduct(Integer id) {
        try { productRepo.deleteById(id); return true;}
        catch (Exception e){ e.printStackTrace(); return false;}
    }

    @Override
    public ProductDto findByName(String name) {
        return (ProductDto) map(productRepo.findByName(name));
    }

    @Override
    public List<ProductDto> findBybrandId(Integer brandId, Pageable pageable) {
        try{
            return productRepo.getByBrand(brandId,pageable).stream().map(p->(ProductDto)map(p)).collect(Collectors.toList());
        }catch (Exception e){ e.printStackTrace();return null; }
    }


}

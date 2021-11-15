package com.example.duyshop.restapi.admin;

import com.example.duyshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/website/product")
public class ProductApi {
    @Autowired
    HttpServletRequest req;
    @Autowired
    ProductService productService;


    @GetMapping("/all")
    public ResponseEntity<?> readProduct(@PathParam("cate") Integer cateId){
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/{cate}")
    public ResponseEntity<?> getProductCate(@PathParam("cate") Integer cateId){
        Pageable pageable= PageRequest.of(0, 6);
        return ResponseEntity.ok(productService.findByCateAndPage(cateId,pageable));
    }


    @GetMapping("/{cate}{page}")
    public ResponseEntity<?> getProductCatePage(@PathParam("cate") Integer cateId,@PathParam("page") Integer page){
        Pageable pageable= PageRequest.of(page, 6);
        return ResponseEntity.ok(cateId);
    }
}

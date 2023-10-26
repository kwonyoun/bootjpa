package com.example.bootjpa.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.bootjpa.data.dto.ProductDto;
import com.example.bootjpa.data.entity.ProductEntity;

public interface ProductService {

    public ProductDto getProduct(@PathVariable String productId);
    public ProductDto saveProduct(String productId, String productName, int productPrice, int productStock);
    public List<ProductEntity> getProductList();
}

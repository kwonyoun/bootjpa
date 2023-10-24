package com.example.bootjpa.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.bootjpa.data.dto.ProductDto;

public interface ProductService {

    public ProductDto getProduct(@PathVariable String productId);
    public ProductDto saveProduct(String productId, String productName, int productPrice, int productStock);
    
}

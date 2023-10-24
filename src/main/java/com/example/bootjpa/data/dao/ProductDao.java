package com.example.bootjpa.data.dao;

import com.example.bootjpa.data.entity.ProductEntity;

public interface ProductDao {

    ProductEntity saveProduct(ProductEntity productEntity);
    ProductEntity getProduct(String productId); 
    
}

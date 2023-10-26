package com.example.bootjpa.data.dao;

import java.util.List;

import com.example.bootjpa.data.entity.ProductEntity;

public interface ProductDao {

    ProductEntity saveProduct(ProductEntity productEntity);
    ProductEntity getProduct(String productId); 
    List<ProductEntity> getProductList();
}

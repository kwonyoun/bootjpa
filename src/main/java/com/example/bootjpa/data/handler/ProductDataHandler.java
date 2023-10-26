package com.example.bootjpa.data.handler;

import java.util.List;

import com.example.bootjpa.data.entity.ProductEntity;

public interface ProductDataHandler {

    ProductEntity saveProductEntity(String productId, String productName, int productPrice, int productStock);
    ProductEntity getProductEntity(String productId);
    List<ProductEntity> getProductList();
    
}

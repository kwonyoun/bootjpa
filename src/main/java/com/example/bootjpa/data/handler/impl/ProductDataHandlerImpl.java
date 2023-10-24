package com.example.bootjpa.data.handler.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.bootjpa.data.dao.ProductDao;
import com.example.bootjpa.data.entity.ProductEntity;
import com.example.bootjpa.data.handler.ProductDataHandler;

@Service
@Transactional
public class ProductDataHandlerImpl implements ProductDataHandler {

    ProductDao productDao;
    @Autowired
    public ProductDataHandlerImpl(ProductDao productDao){
        this.productDao =  productDao;
    }

    @Override
    public ProductEntity saveProductEntity(String productId, String productName, int productPrice, int productStock){

        ProductEntity productEntity = new ProductEntity(productId, productName, productPrice, productStock);
        return productDao.saveProduct(productEntity);
    }

    @Override
    public ProductEntity getProductEntity(String productId){
        return productDao.getProduct(productId);
    }
    
}

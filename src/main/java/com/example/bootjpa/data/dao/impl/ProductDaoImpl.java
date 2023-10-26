package com.example.bootjpa.data.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bootjpa.data.dao.ProductDao;
import com.example.bootjpa.data.entity.ProductEntity;
import com.example.bootjpa.data.repository.ProductRepository;

@Service
public class ProductDaoImpl implements ProductDao {

    ProductRepository productRepository;
    @Autowired
    public ProductDaoImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public ProductEntity saveProduct(ProductEntity productEntity){
        productRepository.save(productEntity);
        return productEntity;
    }

    @Override
    public ProductEntity getProduct(String productId){
        ProductEntity productEntity = productRepository.getById(productId);
        return productEntity;
    }

    @Override
    public List<ProductEntity> getProductList(){
        List<ProductEntity> productEntity = productRepository.findAll();
        return productEntity;
    }

    
    
}

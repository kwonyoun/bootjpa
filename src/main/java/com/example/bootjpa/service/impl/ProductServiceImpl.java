package com.example.bootjpa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.bootjpa.data.dto.ProductDto;
import com.example.bootjpa.data.entity.ProductEntity;
import com.example.bootjpa.data.handler.ProductDataHandler;
import com.example.bootjpa.data.repository.ProductRepository;
import com.example.bootjpa.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService  {

    ProductDataHandler productDataHandler;

    @Autowired
    public ProductServiceImpl(ProductDataHandler productDataHandler){
        this.productDataHandler =  productDataHandler;
    }

    @Override
    public ProductDto saveProduct(String productId, String productName, int productPrice, int productStock){

        ProductEntity productEntity = productDataHandler.saveProductEntity(productId, productName, productPrice, productStock);
        ProductDto produdctDto = new ProductDto(productEntity.getProductId(), productEntity.getProductName(), productEntity.getProductPrice(), productEntity.getProductStock());
        return produdctDto;
    }  

    @Override
    public ProductDto getProduct(@PathVariable String productId){
        ProductEntity productEntity = productDataHandler.getProductEntity(productId);
        ProductDto produdctDto = new ProductDto(productEntity.getProductId(), productEntity.getProductName(), productEntity.getProductPrice(), productEntity.getProductStock());
        return produdctDto;
    }

    @Override
    public List<ProductEntity> getProductList(){
        List<ProductEntity> productEntity = productDataHandler.getProductList();
        return productEntity;
    }

     

}

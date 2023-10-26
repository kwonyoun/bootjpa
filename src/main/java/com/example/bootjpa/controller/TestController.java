package com.example.bootjpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.bootjpa.data.entity.ProductEntity;
import com.example.bootjpa.service.ProductService;

@RestController
public class TestController {

    private ProductService productService;
    public TestController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/test")
    public String test(){
        return "test";
    }

    @GetMapping("/test2")
    public ModelAndView test2(){
        return new ModelAndView("test");
    }

    // @GetMapping(value = "/")
    // public ModelAndView homePage(Model model) { 
    //     model.addAttribute("person", "nanan"); // 3
    //     return new ModelAndView("test");
    // }

    @GetMapping("/")
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView("home/home");
        List<ProductEntity> productEntity = productService.getProductList();
        mav.addObject("list", productEntity);
        mav.addObject("whatlist", "what");
        return mav;
    }

    @GetMapping("/login/login")
    public ModelAndView login(){
        return new ModelAndView("login/login");
    }
    
}

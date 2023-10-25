package com.example.bootjpa.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class TestController {

    @GetMapping("/test")
    public String test(){
        return "test";
    }

    @GetMapping("/test2")
    public ModelAndView test2(){
        return new ModelAndView("test");
    }

    @GetMapping(value = "/")
    public ModelAndView homePage(Model model) { 
        model.addAttribute("person", "nanan"); // 3
        return new ModelAndView("test");
    }

    // @GetMapping("/")
    // public ModelAndView index(){
    //     return new ModelAndView("home/home");
    // }

    // @GetMapping("/login/login")
    // public ModelAndView login(){
    //     return new ModelAndView("login/login");
    // }
    
}

package com.example.bootjpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    //회원가입페이지
    @GetMapping("/signup")
    public String signupPage2(){
        return "signup" ;
    }
    
}

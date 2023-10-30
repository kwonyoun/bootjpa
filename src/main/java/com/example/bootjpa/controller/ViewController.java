package com.example.bootjpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.bootjpa.data.dto.MemberDto;

@Controller
public class ViewController {

    //회원가입페이지
    @GetMapping("/signup")
    public String signupPage(Model model, MemberDto memberDto){
        model.addAttribute("memberDto", memberDto);
        return "signup" ;
    }
    
}

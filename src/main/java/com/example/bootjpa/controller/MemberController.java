package com.example.bootjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.bootjpa.service.MemberService;

@RestController
@RequestMapping("/signup")
public class MemberController {

    private MemberService memberService;
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }
    

    //회원가입페이지
    @GetMapping
    public ModelAndView signupPage(){
        return new ModelAndView("signup") ;
    }

}

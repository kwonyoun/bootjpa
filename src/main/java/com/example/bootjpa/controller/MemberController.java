package com.example.bootjpa.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.bootjpa.data.dto.MemberDto;
import com.example.bootjpa.security.AccountValidator;
import com.example.bootjpa.service.MemberService;

@RestController
@RequestMapping("/signup")
public class MemberController {

    private MemberService memberService;
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }
    private AccountValidator accountValidator;
    
    @PostMapping("/save")
     public String register(@Valid MemberDto memberDto, BindingResult bindingResult){

         accountValidator.validate(memberDto, bindingResult);

         System.out.println(bindingResult.hasErrors());
         if(bindingResult.hasErrors()) {
             return "/signup"; // 실패
         }
         try {
             // 성공
             memberService.save(memberDto);
             return "redirect:/";

         } catch (IllegalStateException e) {
            // model.addAttribute("errorMessage", e.getMessage());
            return "/signup";
        }

     }

    

}

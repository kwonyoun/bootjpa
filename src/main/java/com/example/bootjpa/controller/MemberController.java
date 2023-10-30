package com.example.bootjpa.controller;

import javax.validation.Valid;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.bootjpa.data.dto.MemberDto;
import com.example.bootjpa.data.repository.MemberRepository;
// import com.example.bootjpa.security.MemberValidator;
import com.example.bootjpa.service.MemberService;
import com.example.bootjpa.service.SignupService;

@RestController
@RequestMapping("/signup")
public class MemberController {

    @Autowired
    private SignupService signupService;
    
    
    @PostMapping("/save")
     public ModelAndView signup(@Valid MemberDto memberDto){
      //@RequestBody로 받으려 했는데 
      //Content type 'application/x-www-form-urlencoded;charset=UTF-8' not supported 이런 오류가 뜸.
      

        // accountValidator.validate(memberDto, bindingResult);

         System.out.println("회원가입        ㅡㅡ..");
         System.out.println("memberDto: "+memberDto.getUsername());

         try {
                // 성공
                signupService.signup(memberDto);
                ModelAndView mav = new ModelAndView("redirect:/login)");
                return mav;
             

         } catch (IllegalStateException e) {
            System.out.println("catch");
            ModelAndView mav = new ModelAndView("redirect://signup)");
            return mav;
        }

     }

    

}

package com.example.bootjpa.controller;

import javax.validation.Valid;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.bootjpa.data.dto.MemberDto;
import com.example.bootjpa.security.MemberValidator;
import com.example.bootjpa.service.MemberService;

@RestController
@RequestMapping("/signup")
public class MemberController {

    private MemberService memberService;
    private MemberValidator memberValidator;
    
    @PostMapping("/save")
     public Response register(@Valid MemberDto memberDto, BindingResult bindingResult){

        Response response = new Response();
         memberValidator.validate(memberDto, bindingResult);

         System.out.println(bindingResult.hasErrors());
         if(bindingResult.hasErrors()) {
            response.setMessage("유효성 검사 에러");
             return response; // 실패
         }
         try {
             // 성공
             memberService.save(memberDto);
             response.setMessage("회원가입 성공하였습니다.");
             return response;

         } catch (IllegalStateException e) {
                // response.setResponse("failed");
                response.setMessage("회원가입을 하는 도중 오류가 발생했습니다.");
                // response.setData(e.toString());
            return response;
        }

     }

    

}

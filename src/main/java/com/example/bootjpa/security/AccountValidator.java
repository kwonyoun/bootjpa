package com.example.bootjpa.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.bootjpa.data.dto.MemberDto;
import com.example.bootjpa.data.repository.MemberRepository;

@Component
 public class AccountValidator implements Validator {

     @Autowired
     private MemberRepository memberRepository;

    //  @Override
    //  public boolean supports(Class<?> clazz) {
    //      return AccountRequestDto.class.equals(clazz);
    //  }

    //  @Override
    //  public void validate(Object obj, Errors errors) {
    //      MemberDto accountRequestDto = (MemberDto) obj;
    //      if(!((MemberDto) obj).getMemberPw().equals(((MemberDto) obj).getMemberPwConfirm())){
    //          //비밀번호와 비밀번호 확인이 다르다면
    //          errors.rejectValue("password", "key","비밀번호가 일치하지 않습니다.");
    //      } else if(memberRepository.findByUsername(((MemberDto) obj).getMemberName()) !=null){
    //          // 이름이 존재하면
    //          errors.rejectValue("username", "key","이미 사용자 이름이 존재합니다.");
    //      }

    //  }// 비밀번호 검사할때 쓰면 될듯
 }
package com.example.bootjpa.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.bootjpa.data.dto.MemberDto;
import com.example.bootjpa.data.entity.MemberEntity;
import com.example.bootjpa.data.repository.MemberRepository;

@Service
@Transactional
public class SignupService {

    private MemberRepository memberRepository;
    private PasswordEncoder passwordEncoder;
    public SignupService(MemberRepository memberRepository, PasswordEncoder passwordEncoder){
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void signup(MemberDto memberDto){
        System.out.println("svc: "+memberDto.getUsername());
        MemberEntity member = MemberEntity.createMember(memberDto, passwordEncoder);
        memberRepository.save(member);
    }
    
}

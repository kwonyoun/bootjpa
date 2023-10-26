package com.example.bootjpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.bootjpa.data.repository.MemberRepository;
import com.example.bootjpa.service.MemberService;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {

    MemberRepository memberRepository;
    public MemberServiceImpl(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }
    
}

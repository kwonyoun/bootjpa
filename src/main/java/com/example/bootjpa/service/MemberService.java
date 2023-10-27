package com.example.bootjpa.service;


import com.example.bootjpa.data.dto.MemberDto;
import com.example.bootjpa.data.entity.MemberEntity;

public interface MemberService {

    public MemberEntity save(MemberDto memberDto);
    
}

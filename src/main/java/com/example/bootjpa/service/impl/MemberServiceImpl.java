package com.example.bootjpa.service.impl;

import org.aspectj.weaver.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.bootjpa.data.dto.MemberDto;
import com.example.bootjpa.data.entity.MemberEntity;
import com.example.bootjpa.data.repository.MemberRepository;
import com.example.bootjpa.service.MemberService;

@Service
@Transactional
public class MemberServiceImpl implements UserDetailsService {

    MemberRepository memberRepository;
    public MemberServiceImpl(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MemberEntity account = memberRepository.findByUsername(username);
        throw new User("name","pw","roles");
    }

    public MemberEntity save(MemberDto memberDto){
        MemberEntity member = MemberEntity.createMember(memberDto, passwordEncoder);
        return memberRepository.save(member);
    }

    // private void validateDuplicateMember(Member member) {
    //     Member findMember = memberRepository.findByEmail(member.getEmail());
    //     if (findMember != null) {
    //         throw new IllegalStateException("이미 가입된 회원입니다.");
    //     }

        
    
    
}

package com.example.bootjpa.service;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.weaver.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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

@Service
@Transactional
public class MemberService implements UserDetailsService {

    private MemberRepository memberRepository;
    private PasswordEncoder passwordEncoder;
    public MemberService(MemberRepository memberRepository, PasswordEncoder passwordEncoder){
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
    }
    
    //로그인 서비스
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MemberEntity memberEntity = memberRepository.findByUsername(username);
        // List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        // grantedAuthorities.add(new SimpleGrantedAuthority("role_user"));
        // System.out.println(new User(memberEntity.getMemberName(),memberEntity.getMemberPw(),grantedAuthorities));
        return  User.builder()
                .username(memberEntity.getUsername())
                .password(memberEntity.getPassword())
                .roles(memberEntity.getRoles())
                .build();
    }

    // public void signup(MemberDto memberDto){
    //     System.out.println("svc: "+memberDto.getMemberName());
    //     MemberEntity member = MemberEntity.createMember(memberDto, passwordEncoder);
    //     memberRepository.save(member);
    // }

    // private void validateDuplicateMember(Member member) {
    //     Member findMember = memberRepository.findByEmail(member.getEmail());
    //     if (findMember != null) {
    //         throw new IllegalStateException("이미 가입된 회원입니다.");
    //     }

        
    
    
}

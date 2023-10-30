package com.example.bootjpa.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Role;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.bootjpa.data.dto.MemberDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "user")
public class MemberEntity {

    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int userno; //회원 일련번호 
    
    @Id
    @Column(unique = true)
    String username; //아이디

    String password; //비밀번호

    String usernickname; //회원 닉네임

    String roles;

    
    public MemberEntity(String username, String password, String usernickname, String roles) {      
        this.username = username;
        this.password = password;
        this.usernickname = usernickname;
        this.roles = roles;
    }

    public static MemberEntity createMember(MemberDto memberDto, PasswordEncoder passwordEncoder) {
        MemberEntity member = MemberEntity.builder()
                .username(memberDto.getUsername())
                .password(passwordEncoder.encode(memberDto.getPassword()))  //암호화처리
                .usernickname(memberDto.getUsernickname())
                .roles("USER")
                .build();
        return member;
    }
    
}

package com.example.bootjpa.data.entity;

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
@Table(name = "member")
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String memberNo;

    String memberId;
    String memberPw;
    String memberName;
    String memberNickname;

    String roles;

    @Builder
    public MemberEntity(String id, String password, String name, String nickname, String role) {      
        this.memberId = id;
        this.memberPw = password;
        this.memberName = name;
        this.memberNickname = nickname;
        this.roles = role;
    }

    public static MemberEntity createMember(MemberDto memberDto, PasswordEncoder passwordEncoder) {
        MemberEntity member = MemberEntity.builder()
                .id(memberDto.getMemberId())
                .password(passwordEncoder.encode(memberDto.getMemberPw()))  //암호화처리
                .name(memberDto.getMemberName())
                .nickname(memberDto.getMemberNickname())
                .role("USER")
                .build();
        return member;
    }
    
}
